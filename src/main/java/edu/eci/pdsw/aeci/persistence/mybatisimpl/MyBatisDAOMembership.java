/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoMembership;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.MembershipMapper;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2095498
 */
public class MyBatisDAOMembership implements DaoMembership {
    
    private SqlSession currentSession=null;
    
    public MyBatisDAOMembership(SqlSession session){
        this.currentSession=session;
    }

    @Override
    public void addMembership(Membership membership) throws PersistenceException {
        currentSession.getMapper(MembershipMapper.class).addMembership(membership);
    }

    @Override
    public void updatePayment(Membership membership) throws PersistenceException {
        currentSession.getMapper(MembershipMapper.class).updatePayment(membership);
    }
    
}
