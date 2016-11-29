/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence;

import edu.eci.pdsw.aeci.entities.*;
import java.util.List;

/**
 *
 * @author 2095498
 */
public interface DaoUser {
    
    /**
     * Get the users
     * @return a list with all the users.
     * @throws PersistenceException if there is error with the data base
     */
    public List<User> getUsers() throws PersistenceException;
    
    /**
     * Add new user to Data Base
     * @param user User to be added
     * @throws PersistenceException if User_id is null
     */
    public void addUser(User user) throws PersistenceException;
    
    /**
     * Update a user with the new elements
     * @param userId identification for the user
     * @param user with new parameters
     * @throws PersistenceException if userId is null
     */
    public void updateUser(int userId, User user) throws PersistenceException;
    
    /**
     * Update the first name of User
     * @param idUser identification for the user
     * @param firstName the user first name
     * @throws PersistenceException if userId is null
     */
    public void updateUserFirstName(int idUser, String firstName) throws PersistenceException;
    
    /**
     * Update the last name of User
     * @param idUser identification for the user
     * @param lastName the user last name
     * @throws PersistenceException if userId is null
     */
    public void updateUserLastName(int idUser, String lastName) throws PersistenceException;
    
    /**
     * Update the email of User
     * @param idUser identification for the user
     * @param email the user email
     * @throws PersistenceException if userId is null
     */
    public void updateUserEmail(int idUser, String email) throws PersistenceException;
    
    /**
     * Update the phone of User
     * @param idUser identification for the user
     * @param phone the user phone
     * @throws PersistenceException if userId is null
     */
    public void updateUserPhone(int idUser, String phone) throws PersistenceException;
    
    /**
     * Update the cellphone of User
     * @param idUser identification for the user
     * @param cellphone the user cell phone
     * @throws PersistenceException if userId is null
     */
    public void updateUserCellphone(int idUser, String cellphone) throws PersistenceException;
    
    /**
     * Update the program_id of User
     * @param idUser identification for the user
     * @param program_Id the user program id that indicates the program associated
     * @throws PersistenceException if userId is null
     */
    public void updateUserProgram_Id(int idUser, int program_Id) throws PersistenceException;
    
    /**
     * Update the year of graduation of User
     * @param idUser identification for the user
     * @param yearGraduate the year of graduation
     * @throws PersistenceException if userId is null
     */
    public void updateUserYearGraduate(int idUser, int yearGraduate) throws PersistenceException;
    
    /**
     * Update the birth date of User
     * @param idUser identification for the user
     * @param birthDate the user's birth date
     * @throws PersistenceException if userId is null
     */
    public void updateUserBirthDate(int idUser, java.util.Date birthDate) throws PersistenceException;
    
    /**
     * Update the period of graduation of User
     * @param idUser identification for the user
     * @param period period of graduation of the user
     * @throws PersistenceException if userId is null
     */
    public void updateUserPeriod(int idUser, int period) throws PersistenceException;
    
    /**
     * Update the roll_id of User
     * @param idUser identification for the user
     * @param roll_Id roll associated with the user
     * @throws PersistenceException if userId is null
     */
    public void updateUserRol_Id(int idUser, int roll_Id) throws PersistenceException;
    
}
