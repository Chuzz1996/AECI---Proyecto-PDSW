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
import edu.eci.pdsw.aeci.seguridad.ShiroLoginBean;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

/**
  @Inject
    private ShiroLoginBean loginBean;
 * @author alfa
 */
@ManagedBean(name="PDF")
@SessionScoped
public class GenerarPDFbean implements Serializable {

    private static final long serialVersionUID = 1L;

    private StreamedContent streamedContent;
    
  
    
    
    private String text;
    private String Carrera=" fail ";
    private int periodo= 0 ;
    private String nombre;

    
    private int Cedula= 0 ;
    private String Consignacion="234535";
    private String factura="44882";
    private String fechaActual = "hoy";
     
    /**
        Inicio injection 
    **/
    
    @ManagedProperty(value="#{loginBean}")
    private ShiroLoginBean login;
     
    public void setLogin(ShiroLoginBean messageBean) {
	this.login = messageBean;
    }
    
    /**
        fin injection  
    **/
    
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
            
            Carrera=login.getPersonaLog().getProgram().getName();
            
        
            Document doc = new Document();
            Paragraph parrafo,parrafo2,parrafo3,parrafo4;
            Image imagenLogo = Image.getInstance("Logo.jpeg");
            Image imagenFirma = Image.getInstance("firmaDigital.jpeg"); 
            OutputStream out = new ByteArrayOutputStream();
            PdfWriter writer = PdfWriter.getInstance(doc, out);
            
            doc.open();
            imagenLogo.setAlignment(Element.ALIGN_CENTER);
            doc.add(imagenLogo);
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
            parrafo2 = new Paragraph("La Asociación de  Egresados de la  Escuela Colombiana de Ingeniería Julio Garavito AECI, con "
                    + "Nit. 830.031.137- 4, certifica que el Ingeniero(a) egresado de la carrera "+ Carrera +" Graduado en el perido "+ periodo+","
                    + " "+nombre+", identificado con la cédula de Ciudadanía Nº"+Cedula +","
                    + " está afiliado a esta Asociación y se encuentra al día con su aporte, "
                    + " el cual fue realizado a través de la consignación "+ Consignacion + " y"
                    + " la factura de venta Nº "+factura+" del "+fechaActual);
            parrafo2.setAlignment(Element.ALIGN_JUSTIFIED);
            doc.add(parrafo2);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            /** add **/
            parrafo = new Paragraph("Coordialmente");
            parrafo.setAlignment(Element.ALIGN_CENTER);
            doc.add(parrafo);
            
            imagenFirma.setAlignment(Element.ALIGN_CENTER);
            doc.add(imagenFirma);
            parrafo = new Paragraph("JUAN CARLOS ROMERO ORDÓÑEZ");
            parrafo.setAlignment(Element.ALIGN_CENTER);
            doc.add(parrafo);
            parrafo = new Paragraph("Director");
            parrafo.setAlignment(Element.ALIGN_CENTER);
            doc.add(parrafo);
            parrafo = new Paragraph("Asociacion de Egresados Escuela Colombiana de Ingeniería Julio Garavito");
            parrafo.setAlignment(Element.ALIGN_CENTER);
            doc.add(parrafo);
            doc.add(new Paragraph("\n"));
            doc.add(new Paragraph("\n"));
            parrafo = new Paragraph("AK 45 no 205-59 * Bloque A -piso 2 * Teléfonos 6683600 ext 323-Móvil 3124570612 *");
            parrafo.setAlignment(Element.ALIGN_CENTER);
            doc.add(parrafo);
            parrafo = new Paragraph("Correo electronico aeci@escuelaing.edu.co * Facebook Twitter AECI/escuelaing www.aeci.org.co");
            parrafo.setAlignment(Element.ALIGN_CENTER);
            doc.add(parrafo);
            parrafo = new Paragraph("Bogotá-Colombia");
            parrafo.setAlignment(Element.ALIGN_CENTER);
            doc.add(parrafo);
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
            System.out.println(Carrera+ "mierdaadw");
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
