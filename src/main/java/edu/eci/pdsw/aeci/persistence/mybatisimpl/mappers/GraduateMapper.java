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
public interface GraduateMapper {
    
    public void addGraduate(@Param ("graduate") Graduate graduate);
    
    public List<Graduate> getGraduates();
    
}
