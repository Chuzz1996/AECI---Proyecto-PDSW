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
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.persistence.DaoFactory;
import edu.eci.pdsw.aeci.persistence.DaoUser;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import edu.eci.pdsw.aeci.services.ServicioEnvioCorreos;
import edu.eci.pdsw.aeci.services.ServiciosAeci;
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
    
    public static Properties properties = new Properties();
    public static ServiciosAeci  Rp = ServiciosAeci.getInstance();
    
     /**
     * Obtiene una conexion a la base de datos de prueba
     * @return
     * @throws SQLException 
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:h2:file:./target/db/testdb;MODE=MYSQL", "anonymous", "");        
    }
    
    
    /*No es necesario hacer la prueba de correo
    @Test
    public void EnvioDeAprobado() {
       String NombrePersona = "Felipe Losada";
       String CorreoPersona = "pruebapdsw@gmail.com";
       String comentarioPersona = "Probando el envio de correos";
       ServicioEnvioCorreos EnviarCorreo = new ServicioEnvioCorreos();
       assertTrue("No se ha enviado el correo exitosamente",EnviarCorreo.EnviarCorreo(NombrePersona, CorreoPersona, comentarioPersona));
    }*/
    
   /**
     * Actualizar Datos de usuario
     */
    /*@Test
    public void ActualizarDatosUsuario(){
        DaoFactory dao = DaoFactory.getInstance(properties);
        try{
            dao.beginSession();
            DaoUser usuarioAgregar = dao.getDaoUser();
            Program carrera = Rp.getProgram(1);
            User Solicitante = new User(666, "Ricky", "Ricon", "JustMoney@mail.escuelaing.edu.co", "", "904827364", carrera, 2011, 2, new java.util.Date(1990, 7, 20));
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
            usuarioAgregar.updateUserYearGraduate(Solicitante.getId(), yearGraduate);
            List<User> revision = usuarioAgregar.getUsers();
            for(User x:revision){
                assertTrue("Cambio de nombre",x.getFirstName().equals(firstName));
                assertTrue("Cambio de apellido",x.getLastName().equals(lastName));
                assertTrue("Cambio de correo",x.getEmail().equals(email));
                assertTrue("Cambio de telefono fijo",x.getPhone().equals(phone));
                assertTrue("Cambio de celular",x.getCellphone().equals(cellphone));
                assertEquals("Cambio de año de graduacion",x.getYearGraduate(),yearGraduate);
                assertEquals("Cambio de periodo de graduacion",period, x.getPeriod());
                assertTrue("Cambio de cumpleaños",x.getBirthDate().equals(birthDate));
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
    }*/
    
    /**
     * No es posible agregar un programa no valido 
     */
    /*@Test
    public void programaNoExistente(){
        DaoFactory dao = DaoFactory.getInstance(properties);
        try{
            dao.beginSession();
            DaoUser usuarioAgregar = dao.getDaoUser();
            Program carrera = new Program("Contaduria publica", 10);
            User Solicitante = new User(3604978, "Richar", "Nixon", "niidea@mail.escuelaing.edu.co", "3659748", "065876894", carrera, 1991, 2, new java.util.Date(1970, 7, 20));
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
    }*/
    
    /**
     * No es un correo el indicado
     */
    /*@Test
    public void NoEsUnCorreo(){
        DaoFactory dao = DaoFactory.getInstance(properties);
        try{
            dao.beginSession();
            DaoUser usuarioAgregar = dao.getDaoUser();
            Program carrera = new Program("Contaduria publica", 10);
            User Solicitante = new User(3604978, "Richar", "Nixon", "niideamail.escuelaing.edu.co", "3659748", "065876894", carrera, 1991, 2, new java.util.Date(1970, 7, 20));
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
    }*/
}
