/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoStudent;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.StudentMapper;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2095498
 */
public class MyBatisDAOStudent implements DaoStudent {
    
    private SqlSession currentSession=null;
    
    public MyBatisDAOStudent(SqlSession session){
        this.currentSession=session;
    }

    @Override
    public void addStudent(Student student) throws PersistenceException {
        currentSession.getMapper(StudentMapper.class).addStudent(student);      
    }

    @Override
    public List<Student> getStudents() throws PersistenceException {
        return currentSession.getMapper(StudentMapper.class).getStudents();
    }
}
