/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.tests;

import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.Rol;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.persistence.DaoFactory;
import edu.eci.pdsw.aeci.persistence.DaoRequest;
import edu.eci.pdsw.aeci.persistence.DaoUser;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
import edu.eci.pdsw.aeci.services.ServiciosAeciDAO;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author kevin
 */
public class RequestTest {
    
    
    public RequestTest() {
    }
    
    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");        
    }
    
    public DaoFactory getDataPru() throws IOException{
        InputStream input = getClass().getClassLoader().getResource("applicationconfig.properties").openStream();
        Properties properties=new Properties();
        properties.load(input);
        return DaoFactory.getInstance(properties);
    }
    
    /**
     * Solcitudes agregadas correctamente
     * Falla: No
     */
    @Test
    public void solicitudesPendientes(){
        System.out.println("lol");
        try{
            DaoFactory dao = getDataPru();
            try{
                dao.beginSession();
                DaoRequest request = dao.getDaoRequest();
                DaoUser usuarioAAgregar = dao.getDaoUser();
                Program carreraPrimerSolicitante = dao.getDaoProgram().getProgram(2);
                Rol rolePersona = dao.getDaoRol().getDAORol(1);
                User primerSolicitante = new User(210409, "Pepo", "Gomez", "pepo.gomez@hotmail.com", "2697490", "+573158207964", carreraPrimerSolicitante, 2012, 1, new java.sql.Date(1990, 7, 20),rolePersona);
                usuarioAAgregar.addUser(primerSolicitante);
                Request PrimeraSolicitudAEnviar = new Request(primerSolicitante,1);
                Program carreraSegundoSolicitante = dao.getDaoProgram().getProgram(5);
                User SegundoSolicitante = new User(2068764, "Jaimito", "Chapo", "jaimito.chapo@gmail.com", "987654321", "+573002644743", carreraSegundoSolicitante, 2010, 2, new java.sql.Date(1987, 5, 1),rolePersona);
                usuarioAAgregar.addUser(SegundoSolicitante);
                Request SegundaSolicitudAEnviar = new Request(SegundoSolicitante,2);
                request.addRequest(PrimeraSolicitudAEnviar);
                request.addRequest(SegundaSolicitudAEnviar);
                List<Request> result = request.getPendingRequests();
                for(Request x:result){
                    System.out.println(x.getUser().getFirstName());
                    assertEquals("Estado pendiente",x.getState(),"E");
                }
            }catch(PersistenceException ex){
                fail("Fallo en inicio dao");
            }catch(ExcepcionServiciosAeci w){
                fail("Lanzo exception ServiciosAeci, revision en base de datos");
            }finally{
                try{
                    dao.endSession();
                }catch(PersistenceException e){
                    fail("Fallo cerrar dao");
                }
            }
        }catch(IOException x){
            fail("Fallo ingreso base de datos de prueba");
        }
    } 
    
    /**
     * no es posible el cambio de estado en las solicitudes
     * Falla: si
    */
    /*@Test
    public void CambioDeEstadosDeLaSolicitud(){
        try{
            DaoFactory dao = getDataPru();
            try{
                dao.beginSession();
                DaoRequest request = dao.getDaoRequest();
                DaoUser usuarioAAgregar = dao.getDaoUser();
                Program carreraSolicitante = dao.getDaoProgram().getProgram(1);
                Rol rolePersona = dao.getDaoRol().getDAORol(2);
                User primerSolicitante = new User(19906578, "Nana", "Ramirez", "Pepita92@gmail.com", "5555555", "+13186209763", carreraSolicitante, 2001, 1, new java.sql.Date(1980, 1, 1),rolePersona);
                usuarioAAgregar.addUser(primerSolicitante);
                Request PrimeraSolicitudAEnviar = new Request(primerSolicitante,1 );
                request.addRequest(PrimeraSolicitudAEnviar);
                try{
                    request.updateRequest(PrimeraSolicitudAEnviar, "R", "Felicitaciones su solicitud fue aprobada");
                    request.updateRequest(PrimeraSolicitudAEnviar, "A","");
                    fail("No es posible el cambio de estado de aprobada o rechaza a su contraria");
                }catch(PersistenceException ww){
                    assertTrue("No es posible hacer cambio de estado de la solicitud",true);
                }
            }catch(PersistenceException ex){
                fail("Fallo inicio dao");
            }catch(ExcepcionServiciosAeci e){
                fail("Lanzo exception ServiciosAeci, revision en base de datos");
            }finally{
                try{
                    dao.endSession();
                }catch(PersistenceException w){
                    fail("Fallo cerrar dao");
                }
            }
        }catch(IOException x){
            fail("Fallo ingreso base de datos de prueba");
        }
    }*/
    
    /**
     * Rectificar ingreso de base de datos
     */
    /*@Test
    public void insertarSolicitudNoValidad(){
        try{
            DaoFactory dao = getDataPru();
            try{
                dao.beginSession();
                DaoUser usuarioAAgregar = dao.getDaoUser();
                Program carreraSolicitante = dao.getDaoProgram().getProgram(1);
                Rol rolePersona = dao.getDaoRol().getDAORol(1);
                User primerSolicitante = new User(2032483872, "Harry", "Potter", "Potter.sinpapas@magia.com", "1348954", "+17868182661", carreraSolicitante, 2001, 1, new java.util.Date(1980, 1, 1),rolePersona);
                Request solicitudAEnviar = new Request(primerSolicitante);
                try{
                    dao.
                    Rp.addRequest(solicitudAEnviar);
                    fail("Fallo en llaves foraneas en la base de datos");
                }catch(ExcepcionServiciosAeci tt){
                    assertTrue("",true);
                }
            }catch(PersistenceException e){
                fail("fallo inicio dao");
            }catch(ExcepcionServiciosAeci w){
                fail("Lanzo exception ServiciosAeci, revision en base de datos");
            }finally{
                try{
                    dao.endSession();
                }catch(PersistenceException w){
                    fail("Fallo cerrar dao");
                }
            }
        }catch(IOException x){
            fail("Fallo ingreso base de datos de prueba");
        }
    }*/
    
    
    
    
    
}
