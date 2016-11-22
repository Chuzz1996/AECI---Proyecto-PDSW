/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.Rol;
import edu.eci.pdsw.aeci.persistence.DaoRol;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.RolMapper;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.UserMapper;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author estudiante
 */
public class MyBatisDAORol implements DaoRol{

    private SqlSession currentSession=null;
    
    public MyBatisDAORol(SqlSession session){
        this.currentSession=session;
    }

    @Override
    public Rol getDAORol(int id) throws PersistenceException {
        return currentSession.getMapper(RolMapper.class).getRol(id);
    }
    
    
}
