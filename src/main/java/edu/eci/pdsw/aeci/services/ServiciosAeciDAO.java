/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.services;



import edu.eci.pdsw.aeci.entities.Account;
import edu.eci.pdsw.aeci.entities.Graduate;
import edu.eci.pdsw.aeci.entities.Membership;
import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Rate;
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
    public void addStudentUser(User user, Student student, Request request) throws ExcepcionServiciosAeci {
        try {
            daof.beginSession();
            daof.getDaoUser().addUser(user);
            daof.getDaoStudent().addStudent(student);
            daof.getDaoRequest().addRequest(request);
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            try{
                daof.rollbackTransaction();
                daof.endSession();
            }catch(PersistenceException e){
                Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
                throw new ExcepcionServiciosAeci(e.getMessage());
            }            
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void addGraduateUser(User user, Graduate graduate, Request request) throws ExcepcionServiciosAeci {
        try {
            daof.beginSession();
            daof.getDaoUser().addUser(user);
            daof.getDaoGraduate().addGraduate(graduate);
            daof.getDaoRequest().addRequest(request);
            daof.commitTransaction();
            daof.endSession();
        }catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            try{
                daof.rollbackTransaction();
                daof.endSession();
            }catch(PersistenceException e){
                Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, e);
                throw new ExcepcionServiciosAeci(e.getMessage());                
            }            
            throw new ExcepcionServiciosAeci(ex.getMessage());
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
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
            daof.commitTransaction();
            daof.endSession();
        } catch (PersistenceException ex) {
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        }
    }

    @Override
    public void addAccount(Account account) throws ExcepcionServiciosAeci {
        try{
            daof.beginSession();
            daof.getDaoAccount().addAccount(account.getId(), account.getSalt());
            daof.commitTransaction();
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
    }

    @Override
    public void addMembership(Membership membership) throws ExcepcionServiciosAeci {
        try{
            daof.beginSession();
            daof.getDaoMembership().addMembership(membership);
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
    }

    @Override
    public void updatePayment(Membership membership) throws ExcepcionServiciosAeci {
        try{
            daof.beginSession();
            daof.getDaoMembership().updatePayment(membership);
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
    }

    @Override
    public void addCarnet(Student student) throws ExcepcionServiciosAeci {
        try{
            daof.beginSession();
            daof.getDaoStudent().addCarnet(student);
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
    }

    @Override
    public User getUser(int id) throws ExcepcionServiciosAeci {
        User user = null;
        try{
            daof.beginSession();
            user = daof.getDaoUser().getUser(id);
            daof.endSession();
        } catch(PersistenceException ex){
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, ex);
            throw new ExcepcionServiciosAeci(ex.getMessage());
        } return user;
    }

    @Override
    public List<Membership> getSolicitudesPorVencerse() throws ExcepcionServiciosAeci {
        List<Membership> res = null;
        try{
            daof.beginSession();
            res = daof.getDaoMembership().getSolicitudesPorVencerse();
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
        }return res;
    }

    @Override
    public List<Membership> getAfiliacionesVencidas() throws ExcepcionServiciosAeci {
        List<Membership> res = null;
        try{
            daof.beginSession();
            res = daof.getDaoMembership().getAfiliacionesVencidas();
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
        }return res;
    }

    @Override
    public Rate getRate(int id) throws ExcepcionServiciosAeci {
        Rate res = null;
        try{
            daof.beginSession();
            res = daof.getDaoRate().getRate(id);
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
        }return res;
    }

    @Override
    public Account getAccount(int id) throws ExcepcionServiciosAeci {
        Account res = null;
        try{
            daof.beginSession();
            res = daof.getDaoAccount().getAccount(id);
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
        }return res;
    }

    @Override
    public List<Request> getRequestsSinAprobar() throws ExcepcionServiciosAeci {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verifySemester(int programId, int semester) throws ExcepcionServiciosAeci {
        boolean isCorrect = false;
        try{
            Program program = getProgram(programId);
            int duration = program.getDuration();
            if(duration>=semester && semester>duration-3) isCorrect = true;
        }catch(ExcepcionServiciosAeci e){
            Logger.getLogger(ServiciosAeciDAO.class.getName()).log(Level.SEVERE, null, e);
            throw new ExcepcionServiciosAeci(e.getMessage());
        }return isCorrect;
    }
}