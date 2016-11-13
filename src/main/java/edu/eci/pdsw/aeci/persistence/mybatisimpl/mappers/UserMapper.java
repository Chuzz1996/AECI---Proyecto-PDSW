/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.aeci.entities.*;

/**
 *
 * @author 2095498
 */
public interface UserMapper {
    
    public void addUser(User user);
    
    public void updateUserFirstName(int idUser, String firstName);
    
    public void updateUserLastName(int idUser, String lastName);
    
    public void updateUserEmail(int idUser, String email);
    
    public void updateUserPhone(int idUser, String phone);
    
    public void updateUserCellphone(int idUser, String cellphone);
    
    public void updateUserProgram_Id(int idUser, int program_Id);
    
    public void updateUserYearGraduate(int idUser, int yearGraduate);
    
    public void updateUserBirthDate(int idUser, java.sql.Date birthDate);
    
    public void updateUserPeriod(int idUser, int period);
    
    public void updateUserRol_Id(int idUser, int rol_Id);
    
}
