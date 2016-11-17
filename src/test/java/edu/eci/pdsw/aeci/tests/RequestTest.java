/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.tests;

import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.persistence.DaoFactory;
import edu.eci.pdsw.aeci.persistence.DaoRequest;
import edu.eci.pdsw.aeci.persistence.DaoUser;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
import edu.eci.pdsw.aeci.services.ServiciosAeciDAO;
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
    
    private ServiciosAeciDAO sad;
    public static Properties properties = new Properties();
    public static ServiciosAeci  Rp = ServiciosAeci.getInstance();
    
    public RequestTest() {
    }

    @Before
    public void setUp() {
        sad = new ServiciosAeciDAO();
    }
    
    /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");        
    }
    
    
    /**
     * Solcitudes agregadas correctamente
     * Falla: No
     */
    /*@Test
    public void solicitudesPendientes(){
        DaoFactory dao = DaoFactory.getInstance(properties);
        try{
            dao.beginSession();
            DaoRequest request = dao.getDaoRequest();
            DaoUser usuarioAAgregar = dao.getDaoUser();
            Program carreraPrimerSolicitante = Rp.getProgram(2);
            User primerSolicitante = new User(2105409, "Pepo", "Gomez", "pepo.gomez@hotmail.com", "2697490", "+573158207964", carreraPrimerSolicitante, 2012, 1, new java.util.Date(1990, 7, 20));
            usuarioAAgregar.addUser(primerSolicitante);
            Request PrimeraSolicitudAEnviar = new Request(primerSolicitante);
            Program carreraSegundoSolicitante = Rp.getProgram(5);
            User SegundoSolicitante = new User(20698764, "Jaimito", "Chapo", "jaimito.chapo@gmail.com", "987654321", "+573002644743", carreraSegundoSolicitante, 2010, 2, new java.util.Date(1987, 5, 1));
            usuarioAAgregar.addUser(SegundoSolicitante);
            Request SegundaSolicitudAEnviar = new Request(SegundoSolicitante);
            request.addRequest(PrimeraSolicitudAEnviar);
            request.addRequest(SegundaSolicitudAEnviar);
            List<Request> result = request.getPendingRequests();
            for(Request x:result){
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
    } */
    
    /**
     * no es posible el cambio de estado en las solicitudes
     * Falla: si
    */
    /*@Test
    public void CambioDeEstadosDeLaSolicitud(){
        DaoFactory dao = DaoFactory.getInstance(properties);
        try{
            dao.beginSession();
            DaoRequest request = dao.getDaoRequest();
            DaoUser usuarioAAgregar = dao.getDaoUser();
            Program carreraSolicitante = Rp.getProgram(1);
            User primerSolicitante = new User(19906578, "Nana", "Ramirez", "Pepita92@gmail.com", "5555555", "+13186209763", carreraSolicitante, 2001, 1, new java.util.Date(1980, 1, 1));
            usuarioAAgregar.addUser(primerSolicitante);
            Request PrimeraSolicitudAEnviar = new Request(primerSolicitante);
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
    }*/
    
    /**
     * Rectificar ingreso de base de datos
     */
    /*@Test
    public void insertarSolicitudNoValidad(){
        DaoFactory dao = DaoFactory.getInstance(properties);
        try{
            dao.beginSession();
            DaoUser usuarioAAgregar = dao.getDaoUser();
            Program carreraSolicitante = Rp.getProgram(1);
            User primerSolicitante = new User(2032483872, "Harry", "Potter", "Potter.sinpapas@magia.com", "1348954", "+17868182661", carreraSolicitante, 2001, 1, new java.util.Date(1980, 1, 1));
            Request solicitudAEnviar = new Request(primerSolicitante);
            try{
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
    }*/
    
    
    
    
    
}
