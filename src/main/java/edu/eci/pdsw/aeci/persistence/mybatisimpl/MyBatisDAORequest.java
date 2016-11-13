/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoRequest;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.RequestMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2095498
 */
public class MyBatisDAORequest implements DaoRequest {
    
    private SqlSession currentSession=null;
    
    public MyBatisDAORequest(SqlSession session){
        this.currentSession=session;
    }

    @Override
    public void updateRequestCommentary(Request r, String commentary) throws PersistenceException {
        currentSession.getMapper(RequestMapper.class).updateRequestCommentary(r, commentary);
    }

    @Override
    public void addRequest(Request r) throws PersistenceException {
        currentSession.getMapper(RequestMapper.class).addRequest(r);
    }

    @Override
    public List<Request> getActiveRequests() throws PersistenceException {
        return currentSession.getMapper(RequestMapper.class).getActiveRequests();
    }

    @Override
    public void updateRequestState(Request r, String state) throws PersistenceException {
        currentSession.getMapper(RequestMapper.class).updateRequestState(r, state);
    }
    
}
