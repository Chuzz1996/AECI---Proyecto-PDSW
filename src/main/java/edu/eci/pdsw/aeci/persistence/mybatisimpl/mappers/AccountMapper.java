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
    
}
