/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.services;



import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.persistence.DaoFactory;
import edu.eci.pdsw.aeci.persistence.DaoProgram;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author suntse
 */
public class ServiciosAeciDAO extends ServiciosAeci{
    
    private DaoFactory daof;
    
    public ServiciosAeciDAO() {
        try{
            InputStream input = getClass().getClassLoader().getResource("applicationconfig.properties").openStream();
            Properties properties=new Properties();
            properties.load(input);
            daof = DaoFactory.getInstance(properties);
        }catch(IOException ex){
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void addUser(User user) throws ExcepcionServiciosAeci {
        try {
            daof.beginSession();
            daof.getDaoUser().addUser(user);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void addRequest(Request request) throws ExcepcionServiciosAeci {
        try {
            daof.beginSession();
            daof.getDaoRequest().addRequest(request);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateRequest(Request request, String commentary, String state) throws ExcepcionServiciosAeci {
        try {
            daof.beginSession();
            daof.getDaoRequest().updateRequest(request, state, commentary);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public List<Request> getPendingRequests() throws ExcepcionServiciosAeci {
        List<Request> activeRequest = null;
        try {
            daof.beginSession();
            activeRequest = daof.getDaoRequest().getPendingRequests();
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
        return activeRequest;
    }

    @Override
    public Program getProgram(int id) throws ExcepcionServiciosAeci {
        Program program = null;
        try{
            daof.beginSession();
            DaoProgram pr = daof.getDaoProgram();
            program = pr.getProgram(id);
        }catch(PersistenceException ex){
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }finally{
            try{
                daof.endSession();
            }catch(PersistenceException e){
                Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, e);
               throw new ExcepcionServiciosAeci(e.getMessage());
            }
        }
        return program;
    }

    @Override
    public void updateUser(int idUser, User user) throws ExcepcionServiciosAeci {
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserBirthDate(idUser, (java.sql.Date) user.getBirthDate());
            daof.getDaoUser().updateUserCellphone(idUser, user.getCellphone());
            daof.getDaoUser().updateUserEmail(idUser, user.getEmail());
            daof.getDaoUser().updateUserFirstName(idUser, user.getFirstName());
            daof.getDaoUser().updateUserLastName(idUser, user.getLastName());
            daof.getDaoUser().updateUserPeriod(idUser, user.getPeriod());
            daof.getDaoUser().updateUserYearGraduate(idUser, user.getYearGraduate());
            daof.getDaoUser().updateUserRol_Id(idUser, user.getRole().getId());
            daof.getDaoUser().updateUserProgram_Id(idUser, user.getProgram().getId());
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

}