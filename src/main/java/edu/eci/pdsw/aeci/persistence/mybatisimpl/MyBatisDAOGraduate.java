/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoGraduate;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.GraduateMapper;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.StudentMapper;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.UserMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2095498
 */
public class MyBatisDAOGraduate implements DaoGraduate {
    
    private SqlSession currentSession=null;
    
    public MyBatisDAOGraduate(SqlSession session){
        this.currentSession=session;
    }

    @Override
    public void addGraduate(Graduate graduate) throws PersistenceException {
        currentSession.getMapper(GraduateMapper.class).addGraduate(graduate);
    }

    @Override
    public List<Graduate> getGraduates() throws PersistenceException {
        return currentSession.getMapper(GraduateMapper.class).getGraduates();
    }
    
    
}
