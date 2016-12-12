/*
 * Copyright (C) 2015 hcadavid
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
package edu.eci.pdsw.aeci.persistence.mybatisimpl;


/**
import edu.eci.pdsw.aeci.persistence.Dao;
**/
import edu.eci.pdsw.aeci.entities.Rol;
import edu.eci.pdsw.aeci.persistence.DaoAccount;
import edu.eci.pdsw.aeci.persistence.DaoFactory;
import edu.eci.pdsw.aeci.persistence.DaoGraduate;
import edu.eci.pdsw.aeci.persistence.DaoMembership;
import edu.eci.pdsw.aeci.persistence.DaoProgram;
import edu.eci.pdsw.aeci.persistence.DaoRequest;
import edu.eci.pdsw.aeci.persistence.DaoRol;
import edu.eci.pdsw.aeci.persistence.DaoStudent;
import edu.eci.pdsw.aeci.persistence.DaoUser;

import edu.eci.pdsw.aeci.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 *
 * @author hcadavid
 */
public class MyBatisDaoFactory extends DaoFactory {

    private static volatile SqlSessionFactory sessionFactory;
    
    private Properties appProperties=null;
    
    private SqlSession currentSession=null;
    
    public MyBatisDaoFactory(Properties appProperties) {
        this.appProperties=appProperties;
        if (sessionFactory==null){
            synchronized(MyBatisDaoFactory.class){
                if (sessionFactory==null){
                    sessionFactory=getSqlSessionFactory(this.appProperties); 
                }
            }
           
        }
    }
    
   /**
     * Construye un SQLSessionFactory usando el archivo de configuración de
     * MyBatis cuyo nombre está en el archivo de configuración de la aplicación.
     * @param appProperties
     * @return una nueva SQLSessionFactory
     */
    private SqlSessionFactory getSqlSessionFactory(Properties appProperties) {
        SqlSessionFactory sqlSessionFactory = null;
        if (sqlSessionFactory == null) {
            InputStream inputStream;
            try {
                inputStream = Resources.getResourceAsStream(appProperties.getProperty("mybatis-config-file"));
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return sqlSessionFactory;
    }
    
    @Override
    public void beginSession() throws PersistenceException {
        currentSession=sessionFactory.openSession();
    }


    
    
    @Override
    public void commitTransaction() throws PersistenceException {
        currentSession.commit();
    }

    @Override
    public void rollbackTransaction() throws PersistenceException {
        currentSession.rollback();
    }

    @Override
    public void endSession() throws PersistenceException {
        currentSession.close();
    }

    @Override
    public DaoUser getDaoUser() {
        return new MyBatisDAOUser(currentSession);
    }

    @Override
    public DaoRequest getDaoRequest() {
        return new MyBatisDAORequest(currentSession);
    }

    @Override
    public DaoProgram getDaoProgram() {
        return new MyBatisDAOProgram(currentSession);
    }

    @Override
    public DaoRol getDaoRol() {
        return new MyBatisDAORol(currentSession);
    }
    
    @Override
    public DaoAccount getDaoAccount (){
       return new MyBatisDAOAccount(currentSession); 
    }

    @Override
    public DaoStudent getDaoStudent() {
        return new MyBatisDAOStudent(currentSession);
    }

    @Override
    public DaoGraduate getDaoGraduate() {
        return new MyBatisDAOGraduate(currentSession);
    }

    @Override
    public DaoMembership getDaoMembership() {
        return new MyBatisDAOMembership(currentSession);
    }

    
}
