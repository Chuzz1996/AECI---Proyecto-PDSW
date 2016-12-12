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
import com.itextpdf.text.Image;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
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
@ManagedBean(name="PDF")
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
            Paragraph parrafo,parrafo2;
            Image imagen = Image.getInstance("Logo.jpeg"); 
            OutputStream out = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(doc, out);
            
            doc.open();
            doc.add(imagen);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            parrafo = new Paragraph("CERTIFICADO DE AFILIACIÓN AECI");
            parrafo.setAlignment(Element.ALIGN_CENTER);
            doc.add(parrafo);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            parrafo2 = new Paragraph("La Asociación de Egresados de la Escuela Colombiana de Ingeniería Julio Garavito AECI,con "
                    + "               Nit. 830.031.137- 4, certifica que el Ingeniero Industrial Graduado en el perido 2009-2,"
                    + "               JOEL FERNANDO JARAMILLO GARCÍA, identificado con la cédula de Ciudadanía Nº80.851.912,"
                    + "               está afiliado a esta Asociación y se encuentra al día con su aporte, "
                    + "               el cual fue realizado a través de la consignación 234535 y"
                    + "               la factura de venta Nº 4668 del veintinueve (29) de Noviembre de 2016.");
            parrafo2.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(parrafo2);
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
