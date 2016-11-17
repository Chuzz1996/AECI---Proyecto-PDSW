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


import edu.eci.pdsw.aeci.services.ServicioEnvioCorreos;
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
     * 
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
            List<User> revision = usuarioAgregar.getUsers();
            for(User x:revision){
                assertEquals("iguales",x.getBirthDate(),Solicitante.getBirthDate());
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
    
    
}
