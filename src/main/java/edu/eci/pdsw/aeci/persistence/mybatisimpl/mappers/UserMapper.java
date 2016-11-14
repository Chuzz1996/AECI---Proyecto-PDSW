/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.aeci.entities.*;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2095498
 */
public interface UserMapper {
    
    public List<User> getUsers();
    
    public List<User> getPendingUsers();
    
    public void addUser(@Param("user") User user);
    
    public void updateUserFirstName(@Param("id") int idUser, @Param("fname") String firstName);
    
    public void updateUserLastName(@Param("id") int idUser, @Param("lname") String lastName);
    
    public void updateUserEmail(@Param("id") int idUser, @Param("email") String email);
    
    public void updateUserPhone(@Param("id") int idUser, @Param("phone") String phone);
    
    public void updateUserCellphone(@Param("id") int idUser, @Param("cphone") String cellphone);
    
    public void updateUserProgram_Id(@Param("id") int idUser, @Param("pid") int program_Id);
    
    public void updateUserYearGraduate(@Param("id") int idUser, @Param("ygraduate") int yearGraduate);
    
    public void updateUserBirthDate(@Param("id") int idUser, @Param("bdate") java.sql.Date birthDate);
    
    public void updateUserPeriod(@Param("id") int idUser, @Param("period") int period);
    
    public void updateUserRol_Id(@Param("id") int idUser, @Param("rid") int rol_Id);
    
}
