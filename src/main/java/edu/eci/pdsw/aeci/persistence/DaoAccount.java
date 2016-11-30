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
public interface DaoAccount {
    /**
     *
     * @return
     * @throws PersistenceException 
     */
    public Account getDaccount()throws PersistenceException;
    
    /**
     * Agrega la cuenta, con habilitacion inmediata a la asociacion 
     * @param user
     * @param salt
     * @throws PersistenceException 
     */
    public void addAccount(User user,int salt)throws PersistenceException;
    
    /**
     * Cambia la contrasena de la cuenta
     * @param password
     * @param id
     * @throws PersistenceException 
     */
    public void updatePassword(String password,int id)throws PersistenceException;
    
    /**
     * Desabilita la cuenta
     * @param id
     * @throws PersistenceException 
     */
    public void disableAccount(int id)throws PersistenceException;
    
    /**
     * Activa la cuenta
     * @param id
     * @throws PersistenceException 
     */
    public void enableAccount(int id)throws PersistenceException;
    
    /**
     * Consultar una cuenta
     * @param id
     * @return
     * @throws PersistenceException 
     */
    public Account getAccount(int id)throws PersistenceException;
}
