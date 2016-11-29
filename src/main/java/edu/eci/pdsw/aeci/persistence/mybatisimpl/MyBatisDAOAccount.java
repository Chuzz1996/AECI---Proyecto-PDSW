/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoAccount;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.UserMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2095498
 */
public class MyBatisDAOAccount implements DaoAccount{
    
    private SqlSession currentSession=null;
    
    public MyBatisDAOAccount(SqlSession session){
        this.currentSession=session;
    }

    @Override
    public Account getDAccount() throws PersistenceException {
        return currentSession.getMapper(Account.class).getDetails();
    }
    

    
}
