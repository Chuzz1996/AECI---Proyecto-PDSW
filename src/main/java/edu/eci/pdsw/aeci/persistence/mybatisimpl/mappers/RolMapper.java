/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.persistence.mybatisimpl.mappers;

import edu.eci.pdsw.aeci.entities.Rol;
import org.apache.ibatis.annotations.Param;

/**
 *
 * @author estudiante
 */
public interface RolMapper {
    
    public Rol getRol(@Param("id") int id);
    
}
