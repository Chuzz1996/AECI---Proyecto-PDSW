/*
 * Copyright (C) 2015 hcadavid
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.aeci.services;


/**
import edu.eci.pdsw.aeci.entities.Usuario;
**/
import edu.eci.pdsw.aeci.entities.Account;
import edu.eci.pdsw.aeci.entities.Graduate;
import edu.eci.pdsw.aeci.entities.Membership;
import edu.eci.pdsw.aeci.entities.Program;
import edu.eci.pdsw.aeci.entities.Rate;
import edu.eci.pdsw.aeci.entities.Request;
import edu.eci.pdsw.aeci.entities.Rol;
import edu.eci.pdsw.aeci.entities.Student;
import edu.eci.pdsw.aeci.entities.User;
import java.io.Serializable;
import java.util.List;


/**
 *
 * @author hcadavid
 */
public abstract class ServiciosAeci implements Serializable{
    
    private static ServiciosAeciDAO instance=new ServiciosAeciDAO();
    
    public static ServiciosAeciDAO getInstance() throws RuntimeException{        
        return instance;
    }
    
    public abstract void addStudentUser(User user, Student student, Request request) throws ExcepcionServiciosAeci;
    
    public abstract void addGraduateUser(User user, Graduate graduate, Request request) throws ExcepcionServiciosAeci;
    
    public abstract void addUser(User user) throws ExcepcionServiciosAeci;
    
    public abstract void addAccount(Account account)throws ExcepcionServiciosAeci;
    
    public abstract void updateUser(int idUser, User user) throws ExcepcionServiciosAeci;

    public abstract void addRequest(Request request) throws ExcepcionServiciosAeci;
    
    public abstract void updateRequest(Request request, String commentary, String state) throws ExcepcionServiciosAeci;
    
    public abstract Program getProgram(int id)throws ExcepcionServiciosAeci;

    public abstract List<Request> getPendingRequests() throws ExcepcionServiciosAeci;
    
    public abstract User getUser(int id)throws ExcepcionServiciosAeci;
    
    public abstract Rol getRol(int id)throws ExcepcionServiciosAeci;
    
    public abstract void updateUserFirstName(int idUser, String firstName) throws ExcepcionServiciosAeci;
    
    public abstract void updateUserLastName(int idUser, String lastName) throws ExcepcionServiciosAeci;
    
    public abstract void updateUserEmail(int idUser, String email) throws ExcepcionServiciosAeci;
    
    public abstract void updateUserPhone(int idUser, String phone) throws ExcepcionServiciosAeci;
    
    public abstract void updateUserCellphone(int idUser, String cellphone) throws ExcepcionServiciosAeci;
    
    public abstract void updateUserProgram_Id(int idUser, int program_Id) throws ExcepcionServiciosAeci;
    
    public abstract void updateUserYearGraduate(int idUser, int yearGraduate) throws ExcepcionServiciosAeci;
    
    public abstract void updateUserBirthDate(int idUser, java.util.Date birthDate) throws ExcepcionServiciosAeci;
    
    public abstract void updateUserPeriod(int idUser, int period) throws ExcepcionServiciosAeci;
    
    public abstract void updateUserRol_Id(int idUser, int rol_Id) throws ExcepcionServiciosAeci;
       
    public abstract void addStudent(Student student) throws ExcepcionServiciosAeci;
    
    public abstract void addCarnet(Student student)throws ExcepcionServiciosAeci;
    
    public abstract void addGraduate(Graduate graduate) throws ExcepcionServiciosAeci;
    
    public abstract void addMembership(Membership membership)throws ExcepcionServiciosAeci;
    
    public abstract void updatePayment(Membership membership)throws ExcepcionServiciosAeci;
    
    public abstract List<Membership> getSolicitudesPorVencerse()throws ExcepcionServiciosAeci;
    
    public abstract List<Membership> getAfiliacionesVencidas()throws ExcepcionServiciosAeci;
    
    public abstract Rate getRate(int id)throws ExcepcionServiciosAeci;
    
    public abstract Account getAccount(int id)throws ExcepcionServiciosAeci;
}
