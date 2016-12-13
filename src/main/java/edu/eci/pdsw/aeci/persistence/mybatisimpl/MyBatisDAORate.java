/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoRate;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.RateMapper;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2095498
 */
public class MyBatisDAORate implements DaoRate {
    
    private SqlSession currentSession=null;
    
    public MyBatisDAORate(SqlSession session){
        this.currentSession=session;
    }

    @Override
    public Rate getRate(int id) {
        return currentSession.getMapper(RateMapper.class).getRate(id);
    }
    
}
