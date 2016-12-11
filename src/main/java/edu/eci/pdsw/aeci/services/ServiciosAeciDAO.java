/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.services;



import edu.eci.pdsw.aeci.entities.Graduate;
import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.Rol;
import edu.eci.pdsw.aeci.entities.Student;
import edu.eci.pdsw.aeci.entities.User;
import edu.eci.pdsw.aeci.persistence.DaoFactory;
import edu.eci.pdsw.aeci.persistence.PersistenceException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
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
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }
    
    @Override
    public void addStudent(Student student) throws ExcepcionServiciosAeci {
        try {
            daof.beginSession();
            daof.getDaoStudent().addStudent(student);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }
    
    @Override
    public void addGraduate(Graduate graduate) throws ExcepcionServiciosAeci {
        try {
            daof.beginSession();
            daof.getDaoGraduate().addGraduate(graduate);
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            program = daof.getDaoProgram().getProgram(id);
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
            daof.getDaoUser().updateUser(idUser, user);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public Rol getRol(int id) throws ExcepcionServiciosAeci{
        Rol role = null;
        try{
            daof.beginSession();
            role = daof.getDaoRol().getDAORol(id);
            daof.endSession();
        } catch(PersistenceException ex){
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        } return role;
    }

    @Override
    public void updateUserFirstName(int idUser, String firstName) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserFirstName(idUser, firstName);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateUserLastName(int idUser, String lastName) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserLastName(idUser, lastName);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateUserEmail(int idUser, String email) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserEmail(idUser, email);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateUserPhone(int idUser, String phone) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserPhone(idUser, phone);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateUserCellphone(int idUser, String cellphone) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserCellphone(idUser, cellphone);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateUserProgram_Id(int idUser, int program_Id) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserProgram_Id(idUser, program_Id);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateUserYearGraduate(int idUser, int yearGraduate) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserYearGraduate(idUser, yearGraduate);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateUserBirthDate(int idUser, Date birthDate) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserBirthDate(idUser, birthDate);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateUserPeriod(int idUser, int period) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserPeriod(idUser, period);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void updateUserRol_Id(int idUser, int rol_Id) throws ExcepcionServiciosAeci{
        try {
            daof.beginSession();
            daof.getDaoUser().updateUserRol_Id(idUser, rol_Id);
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }
}