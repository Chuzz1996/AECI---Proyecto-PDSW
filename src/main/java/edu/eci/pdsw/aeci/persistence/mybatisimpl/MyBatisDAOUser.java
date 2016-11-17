/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl;

import edu.eci.pdsw.aeci.entities.*;
import edu.eci.pdsw.aeci.persistence.DaoUser;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers.UserMapper;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

/**
 *
 * @author 2095498
 */
public class MyBatisDAOUser implements DaoUser {

    private SqlSession currentSession=null;
    
    public MyBatisDAOUser(SqlSession session){
        this.currentSession=session;
    }
    
    @Override
    public void addUser(User user) {
        currentSession.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public void updateUserFirstName(int idUser, String firstName) {
        currentSession.getMapper(UserMapper.class).updateUserFirstName(idUser, firstName);
    }

    @Override
    public void updateUserLastName(int idUser, String lastName) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUserLastName(idUser, lastName);
    }

    @Override
    public void updateUserEmail(int idUser, String email) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUserEmail(idUser, email);
    }

    @Override
    public void updateUserPhone(int idUser, String phone) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUserPhone(idUser, phone);
    }

    @Override
    public void updateUserCellphone(int idUser, String cellphone) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUserCellphone(idUser, cellphone);
    }

    @Override
    public void updateUserProgram_Id(int idUser, int program_Id) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUserProgram_Id(idUser, program_Id);
    }

    @Override
    public void updateUserYearGraduate(int idUser, int yearGraduate) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUserYearGraduate(idUser, yearGraduate);
    }

    @Override
    public void updateUserBirthDate(int idUser, Date birthDate) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUserBirthDate(idUser, birthDate);
    }

    @Override
    public void updateUserPeriod(int idUser, int period) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUserPeriod(idUser, period);
    }

    @Override
    public void updateUserRol_Id(int idUser, int roll_Id) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUserRol_Id(idUser, roll_Id);
    }

    @Override
    public List<User> getUsers() throws PersistenceException {
        return currentSession.getMapper(UserMapper.class).getUsers();
    }

    @Override
    public void updateUser(int userId, User user) throws PersistenceException {
        currentSession.getMapper(UserMapper.class).updateUser(userId, user);
    }
    
}
