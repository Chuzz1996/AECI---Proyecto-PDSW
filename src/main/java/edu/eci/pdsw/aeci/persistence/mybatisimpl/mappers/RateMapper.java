/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.aeci.entities.*;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author 2095498
 */
public interface RateMapper {
    
    public Rate getRate(@Param("id")int id);
    
}
