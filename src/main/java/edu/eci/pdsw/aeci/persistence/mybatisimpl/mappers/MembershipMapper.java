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
 * @author PDSW GRUPO 1
 */
public interface MembershipMapper {
    
    public void addMembership(@Param("membership")Membership membership);
    
    public void updatePayment(@Param("membership")Membership membership);
    
}
