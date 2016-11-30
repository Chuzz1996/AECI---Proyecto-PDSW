/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.aeci.entities.*;
import java.sql.Date;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2095498
 */
public interface AccountMapper {
    
    public User getDetails(@Param("ActualDay") Date ActualDay);
    
    public User getStudent(@Param("est") int est);
    
    public User getGraduate(@Param("Grad") int Grad);
    
    public void addAccount(@Param("user") User user,@Param("salt") int salt);
    
    public void updatePassword(@Param("password")String password, @Param("id")int id);
    
    public void disableAccount(@Param("id")int id);
    
    public void enableAccount(@Param("id")int id);
    
    public Account getAccount(@Param("id")int id);
}
