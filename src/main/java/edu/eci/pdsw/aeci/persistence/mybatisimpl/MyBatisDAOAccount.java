/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoAccount;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.AccountMapper;
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
    public Account getDaccount() throws PersistenceException {
        return currentSession.getMapper(Account.class).getDetails();
    }

    @Override
    public void addAccount(User user, int salt) throws PersistenceException {
        currentSession.getMapper(AccountMapper.class).addAccount(user, salt);
    }

    @Override
    public void updatePassword(String password, int id) throws PersistenceException {
        currentSession.getMapper(AccountMapper.class).updatePassword(password, id);
    }

    @Override
    public void disableAccount(int id) throws PersistenceException {
        currentSession.getMapper(AccountMapper.class).disableAccount(id);
    }

    @Override
    public void enableAccount(int id) throws PersistenceException {
        currentSession.getMapper(AccountMapper.class).enableAccount(id);
    }

    @Override
    public Account getAccount(int id) throws PersistenceException {
        return currentSession.getMapper(AccountMapper.class).getAccount(id);
    }
    

    
}
