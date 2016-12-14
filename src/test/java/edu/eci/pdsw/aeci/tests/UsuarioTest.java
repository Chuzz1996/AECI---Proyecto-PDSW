/*
 * Copyright (C) 2095498 JohanRamirezC
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.aeci.tests;


import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.Rol;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.persistence.DaoFactory;
import edu.eci.pdsw.aeci.persistence.DaoUser;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import edu.eci.pdsw.aeci.services.ServicioEnvioCorreos;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.*;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author FelipeLosada
 * 
 * 
 * clases de equivalencia
 * 
 * clase1: Enviar Correo Aprobado
 * falla:No
 * nombre:EnvioAprobado
 * 
 * clase2: Envia Correo no aprobado
 * falla: No
 * nombre: EnvioSinAprobar
 * 
 */
public class UsuarioTest {
    
    public DaoFactory getDataPru() throws IOException{
        InputStream input = getClass().getClassLoader().getResource("h2-applicationconfig.properties").openStream();
        Properties properties=new Properties();
        properties.load(input);
        return DaoFactory.getInstance(properties);
    }

    @Test
    public void pruebaADescartarDespues(){
        try{
            DaoFactory dao = getDataPru();

            try{
                dao.beginSession();
                Program pr = dao.getDaoProgram().getProgram(1);
                assertTrue("Error en daoProgram",pr.getName().equals("Ingenieria Civil"));
            }catch(Exception x){
                x.printStackTrace();
                fail("CO:O PASEEE "+x.getMessage());
            }
            finally{
                try{
                    dao.endSession();
                }catch(PersistenceException ww){
                    fail("Fallo cerrar dao ");
                }
            }
        }catch(IOException x){
            fail("Fallo ingreso base de datos de prueba");
        }
    }
    
    /**
     * 
     */
    @Test
    public void EnvioDeAprobado() {
        try{
            List<Request> solicitudesPendientes =  ServiciosAeci.getInstance().getPendingRequests();
            for (Request x : solicitudesPendientes){
                if (x.getUser() == null || x.getUser().getRole() == null || x.getUser().getProgram() == null){
                    fail("No se estan construyendo bien los objetos en la base de datos");
                }
            }
        } catch(ExcepcionServiciosAeci e){
        
        }
    }
    
    /**
     * 
     */
    @Test
    public void consultarUsuario(){
        try{
            DaoFactory dao = getDataPru();
            try{
                dao.beginSession();
                DaoUser usuarioAgregar = dao.getDaoUser();
                Program carrera = dao.getDaoProgram().getProgram(1);
                Rol rolePersona = dao.getDaoRol().getDAORol(1);
                User Solicitante = new User(666, "Ricky", "Ricon", "JustMoney@mail.escuelaing.edu.co", "", "904827364", carrera, 2011, 2, new java.sql.Date(1990, 7, 20),rolePersona);
                usuarioAgregar.addUser(Solicitante);
                User revision = usuarioAgregar.getUser(Solicitante.getId());
                assertEquals("Usuario no consultado correctamente ",revision.getId(),Solicitante.getId());
        }catch(PersistenceException e){
                fail("Fallo inicio dao");
            }catch(ExcepcionServiciosAeci ex){
                fail("Lanzo exception ServiciosAeci, revision en base de datos");
            }finally{
                try{
                    dao.endSession();
                }catch(PersistenceException ww){
                    fail("Fallo cerrar dao ");
                }
            }
        }catch(IOException x){
            fail("Fallo ingreso base de datos de prueba");
        } 
    }
    
   /**
     * Actualizar Datos de usuario
     */
    @Test
    public void actualizarDatosUsuario(){
        try{
            DaoFactory dao = getDataPru();
            try{
                dao.beginSession();
                DaoUser usuarioAgregar = dao.getDaoUser();
                Program carrera = dao.getDaoProgram().getProgram(1);
                Rol rolePersona = dao.getDaoRol().getDAORol(1);
                User Solicitante = new User(845, "Ricky", "Ricon", "JustMoney@mail.escuelaing.edu.co", "", "904827364", carrera, 2011, 2, new java.sql.Date(1990, 7, 20),rolePersona);
                usuarioAgregar.addUser(Solicitante);
                String firstName = "Negro";
                String lastName = "Confundido";
                String email = "loca@hotmail.com";
                String phone = "9632584";
                String cellphone = "+123569764821";
                int yearGraduate = 2000;
                int period = 1;
                java.util.Date birthDate = new java.util.Date(1989, 7, 20);
                usuarioAgregar.updateUserFirstName(Solicitante.getId(), firstName);
                usuarioAgregar.updateUserLastName(Solicitante.getId(), lastName);
                usuarioAgregar.updateUserEmail(Solicitante.getId(), email);
                usuarioAgregar.updateUserPhone(Solicitante.getId(), phone);
                usuarioAgregar.updateUserCellphone(Solicitante.getId(), cellphone);
                usuarioAgregar.updateUserYearGraduate(Solicitante.getId(), yearGraduate);
                usuarioAgregar.updateUserPeriod(Solicitante.getId(), period);
                usuarioAgregar.updateUserBirthDate(Solicitante.getId(), birthDate);
                User x = usuarioAgregar.getUser(Solicitante.getId());
                assertTrue("Cambio de nombre",x.getFirstName().equals(firstName));
                assertTrue("Cambio de apellido",x.getLastName().equals(lastName));
                assertTrue("Cambio de correo",x.getEmail().equals(email));
                assertTrue("Cambio de telefono fijo",x.getPhone().equals(phone));
                assertTrue("Cambio de celular",x.getCellphone().equals(cellphone));
                assertEquals("Cambio de año de graduacion",x.getYearGraduate(),yearGraduate);
                assertEquals("Cambio de periodo de graduacion",period, x.getPeriod());
                assertTrue("Cambio de cumpleaños",x.getBirthDate().equals(birthDate));
            }catch(PersistenceException e){
                fail("Fallo inicio dao");
            }catch(ExcepcionServiciosAeci ex){
                fail("Lanzo exception ServiciosAeci, revision en base de datos");
            }finally{
                try{
                    dao.endSession();
                }catch(PersistenceException ww){
                    fail("Fallo cerrar dao ");
                }
            }
        }catch(IOException x){
            fail("Fallo ingreso base de datos de prueba");
        }    
    }
    
    /**
     * No es posible agregar un programa no valido 
     */
    @Test
    public void programaNoExistente(){
        try{
            DaoFactory dao = getDataPru();
            try{
                dao.beginSession();
                DaoUser usuarioAgregar = dao.getDaoUser();
                Program carrera = new Program("Contaduria publica", 10);
                Rol rolePersona = dao.getDaoRol().getDAORol(1);
                User Solicitante = new User(3604978, "Richar", "Nixon", "niidea@mail.escuelaing.edu.co", "3659748", "065876894", carrera, 1991, 2, new java.sql.Date(1970, 7, 20),rolePersona);
                try{
                    usuarioAgregar.updateUserProgram_Id(Solicitante.getId(),87);
                    fail("Fallo con las llaves foraneas, programa no valido");
                }catch(PersistenceException xx){
                    assertTrue("Programa valido",true);
                }
            }catch(PersistenceException e){
                fail("Fallo inicio dao");
            }catch(ExcepcionServiciosAeci ex){
                fail("Lanzo exception ServiciosAeci, revision en base de datos");
            }finally{
                try{
                    dao.endSession();
                }catch(PersistenceException ww){
                    fail("Fallo cerrar dao ");
                }
            }
        }catch(IOException x){
            fail("Fallo ingreso base de datos de prueba");
        }   
    }
    
    /**
     * No es un correo el indicado
     */
    /*@Test
    public void NoEsUnCorreo(){
        try{
            DaoFactory dao = getDataPru();
            try{
                dao.beginSession();
                DaoUser usuarioAgregar = dao.getDaoUser();
                Program carrera = new Program("Contaduria publica", 10);
                Rol role = dao.getDaoRol().getDAORol(1);
                User Solicitante = new User(3604978, "Richar", "Nixon", "niideamail.escuelaing.edu.co", "3659748", "065876894", carrera, 1991, 2, new java.sql.Date(1970, 7, 20),role);
                fail("No es un correo valido");
            }catch(PersistenceException ex){
                fail("Fallo inicio dao");
            }catch(ExcepcionServiciosAeci ff){
                assertTrue("No es un correo valido",true);
            }finally{
                try{
                    dao.endSession();
                }catch(PersistenceException ww){
                    fail("Fallo cerrar dao ");
                }
            }
        }catch(IOException x){
            fail("Fallo ingreso base de datos de prueba");
        }
    }*/
}
