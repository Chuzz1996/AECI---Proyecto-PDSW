/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence;

import edu.eci.pdsw.aeci.entities.*;

/**
 *
 * @author 2095498
 */
public interface DaoUser {
    
    /**
     * Add new user to Data Base
     * @param user
     * @throws PersistenceException if User_id is null
     */
    public void addUser(User user)throws PersistenceException;
    
    /**
     * Update the first name of User
     * @param idUser
     * @param firstName
     * @throws PersistenceException
     */
    public void updateUserFirstName(int idUser, String firstName) throws PersistenceException;
    
    /**
     * Update the last name of User
     * @param idUser
     * @param lastName
     * @throws PersistenceException
     */
    public void updateUserLastName(int idUser, String lastName) throws PersistenceException;
    
    /**
     * Update the email of User
     * @param idUser
     * @param email
     * @throws PersistenceException
     */
    public void updateUserEmail(int idUser, String email) throws PersistenceException;
    
    /**
     * Update the phone of User
     * @param idUser
     * @param phone
     * @throws PersistenceException
     */
    public void updateUserPhone(int idUser, String phone) throws PersistenceException;
    
    /**
     * Update the cellphone of User
     * @param idUser
     * @param cellphone
     * @throws PersistenceException
     */
    public void updateUserCellphone(int idUser, String cellphone) throws PersistenceException;
    
    /**
     * Update the program_id of User
     * @param idUser
     * @param program_Id
     * @throws PersistenceException
     */
    public void updateUserProgram_Id(int idUser, int program_Id) throws PersistenceException;
    
    /**
     * Update the year of graduation of User
     * @param idUser
     * @param yearGraduate
     * @throws PersistenceException
     */
    public void updateUserYearGraduate(int idUser, int yearGraduate) throws PersistenceException;
    
    /**
     * Update the birth date of User
     * @param idUser
     * @param birthDate
     * @throws PersistenceException
     */
    public void updateUserBirthDate(int idUser, java.sql.Date birthDate) throws PersistenceException;
    
    /**
     * Update the period of graduation of User
     * @param idUser
     * @param period
     * @throws PersistenceException
     */
    public void updateUserPeriod(int idUser, int period) throws PersistenceException;
    
    /**
     * Update the rol_id of User
     * @param idUser
     * @param rol_Id
     * @throws PersistenceException
     */
    public void updateUserRol_Id(int idUser, int rol_Id) throws PersistenceException;
    
}
