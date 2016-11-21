package edu.eci.pdsw.aeci.managedbeans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2105409
 */

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
 *
 * @author alfa
 */
@ManagedBean
@RequestScoped
public class GenerarPDFbean{

    private static final long serialVersionUID = 1L;

    private StreamedContent streamedContent;


    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    
    @PostConstruct     
    public void init() {
        try {
        //----------------------------------
            Document doc = new Document();

            OutputStream out = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(doc, out);

            doc.open();
            doc.add(new Paragraph("Hello World. ok........"));
            doc.close(); 
            out.close();

            InputStream in =new ByteArrayInputStream(((ByteArrayOutputStream)out).toByteArray());

            streamedContent = new DefaultStreamedContent(in, "application/pdf");
        //-------
        Map<String, Object> session = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        byte[] b = (byte[]) session.get("reportBytes");
        if (b != null) {
            streamedContent = new DefaultStreamedContent(new ByteArrayInputStream(b), "application/pdf");
        }            
        } catch (Exception e) {
        }

    }
    //==================================================================
    public StreamedContent getStreamedContent() {
        if (FacesContext.getCurrentInstance().getRenderResponse()) {
            return new DefaultStreamedContent();
        } else {
            return streamedContent;
        }
     }
    //==================================================================
    public void setStreamedContent(StreamedContent streamedContent) {
        this.streamedContent = streamedContent;
    }
    //=====================================================================

}
