/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.tests;

import edu.eci.pdsw.aeci.services.ServiciosAeciDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.junit.Before;

/**
 *
 * @author kevin
 */
public class RequestTest {
    
    private ServiciosAeciDAO sad;
    
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
    
    
    
    
}
