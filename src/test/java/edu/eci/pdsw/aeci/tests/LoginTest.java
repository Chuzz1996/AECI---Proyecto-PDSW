/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.tests;

import edu.eci.pdsw.aeci.entities.Account;
import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Rol;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.persistence.DaoAccount;
import edu.eci.pdsw.aeci.persistence.DaoFactory;
import edu.eci.pdsw.aeci.persistence.DaoUser;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.seguridad.ShiroLoginBean;
import edu.eci.pdsw.aeci.services.ExcepcionServiciosAeci;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
/**
 *
 * @author 2105409
 */
public class LoginTest {
    
    public LoginTest(){
    
    }
    
     /**
     * Conexion de prueba
     * @return
     * @throws IOException 
     */
    public DaoFactory getDataPru() throws IOException{
        InputStream input = getClass().getClassLoader().getResource("applicationconfig.properties").openStream();
        Properties properties=new Properties();
        properties.load(input);
        return DaoFactory.getInstance(properties);
    }
    
    /**
     * 
     */
    /*@Test
    public void Login(){
        try{
            DaoFactory dao = getDataPru();
            try{
                dao.beginSession();
                DaoAccount account = dao.getDaoAccount();
                DaoUser user = dao.getDaoUser();
                Program carreraPrimerSolicitante = dao.getDaoProgram().getProgram(2);
                Rol rolePersona = dao.getDaoRol().getDAORol(1);
                User pruUser = new User(210409, "Pepo", "Gomez", "pepo.gomez@hotmail.com", "2697490", "+573158207964", carreraPrimerSolicitante, 2012, 1, new java.sql.Date(1990, 7, 20),rolePersona);
                user.addUser(pruUser);
                account.addAccount(pruUser, 12);
                ShiroLoginBean login = new ShiroLoginBean();
                Account revision = account.getAccount(pruUser.getId());
                login.setPassword(revision.getPassword());
                login.setUsername(revision.getId().getId()+"");
                login.doLogin();
            }catch(PersistenceException ex){
                fail("Fallo en inicio dao");
            }catch(ExcepcionServiciosAeci zz){
                fail("Lanzo exception ServiciosAeci, revision en base de datos");
            }finally{
                try{
                    dao.endSession();
                }catch(PersistenceException e){
                    fail("Fallo cerrar dao");
                }
            }
        }catch(IOException ex){
            fail("Fallo ingreso base de datos de prueba");
        }
    }*/
    
}
