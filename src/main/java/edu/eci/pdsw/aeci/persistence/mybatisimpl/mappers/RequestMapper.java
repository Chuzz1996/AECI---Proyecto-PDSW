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
public interface RequestMapper {
    
    public List<Request> getActiveRequests();
    
    public void addRequest(@Param("request") Request r);
    
    public void updateRequest(@Param("request") Request r,@Param("commentary") String commentary,@Param("state") String state);
    
}
