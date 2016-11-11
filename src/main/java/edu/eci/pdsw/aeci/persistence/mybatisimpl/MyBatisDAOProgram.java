/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoProgram;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.ProgramMapper;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2095498
 */
public class MyBatisDAOProgram implements DaoProgram {

    private SqlSession currentSession=null;
    
    public MyBatisDAOProgram(SqlSession session){
        this.currentSession=session;
    }
    
    @Override
    public Program getProgram(int id)throws PersistenceException {
        return currentSession.getMapper(ProgramMapper.class).getProgram(id);
    }
    
}
