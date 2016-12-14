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
 * @author 2118677
 */
public abstract class ServiciosAeci implements Serializable{
    
    private static final ServiciosAeciDAO instance=new ServiciosAeciDAO();
    
    /**
     * Gives a instance for ServiciosAeci.
     * @return instance for ServiciosAeci.
     * @throws RuntimeException if something went wrong.
     */
    public static ServiciosAeciDAO getInstance() throws RuntimeException{        
        return instance;
    }
    
    /**
     * verifies if given a program id and a semester is valid, a semester is valid
     * if is on the last three semesters of a program.
     * @param programId the id of the program
     * @param semester the current semester to evaluate
     * @return True or False depending if the semester is valid
     * @throws ExcepcionServiciosAeci if something wents wrong.
     */
    public abstract boolean verifySemester(int programId, int semester)throws ExcepcionServiciosAeci;
    
    /**
     * adds the respective user, request and student to de database.
     * @param user the user to add.
     * @param student the student to add.
     * @param request the request to add.
     * @throws ExcepcionServiciosAeci if something wents wrong.
     */
    public abstract void addStudentUser(User user, Student student, Request request) throws ExcepcionServiciosAeci;
    
    /**
     * adds the respective user, request and graduate to de database.
     * @param user the user to add.
     * @param graduate the graduate to add.
     * @param request the request to add.
     * @throws ExcepcionServiciosAeci if something went wrong.
     */
    public abstract void addGraduateUser(User user, Graduate graduate, Request request) throws ExcepcionServiciosAeci;
    
    /**
     * Adds an user to the data base
     * @param user The user to be added
     * @throws ExcepcionServiciosAeci if something went wrong.
     */
    public abstract void addUser(User user) throws ExcepcionServiciosAeci;
    
    /**
     * Adds an account to the data base
     * @param account The account to be added
     * @throws ExcepcionServiciosAeci if something went wrong.
     */
    public abstract void addAccount(Account account)throws ExcepcionServiciosAeci;
    
    /**
     * Update an user given his id
     * @param idUser The user's id
     * @param user The user with new attributes 
     * @throws ExcepcionServiciosAeci if idUser is null
     */
    public abstract void updateUser(int idUser, User user) throws ExcepcionServiciosAeci;

    /**
     * Adds a request to the data base
     * @param request The request to be added
     * @throws ExcepcionServiciosAeci If the user of the request or his id is null
     */
    public abstract void addRequest(Request request) throws ExcepcionServiciosAeci;
    
    /**
     * Update a request in the data base, with a new commentary and state
     * @param request The request with new attributes
     * @param commentary The new commentary
     * @param state The new state
     * @throws ExcepcionServiciosAeci If the user of the request or his id is null
     */
    public abstract void updateRequest(Request request, String commentary, String state) throws ExcepcionServiciosAeci;
    
    /**
     * Obtains the program given his id
     * @param id The program's id
     * @return The program
     * @throws ExcepcionServiciosAeci if id is null
     */
    public abstract Program getProgram(int id)throws ExcepcionServiciosAeci;
    
    /**
     * Gives a list with all the pending requests in the database.
     * @return a list with all the pending requests.
     * @throws ExcepcionServiciosAeci if occurs any error
     */
    public abstract List<Request> getPendingRequests() throws ExcepcionServiciosAeci;
    
    /**
     * Obtains a list with requests that aren't approved yet
     * @return Return the list
     * @throws ExcepcionServiciosAeci if occurs any error.
     */
    public abstract List<Request> getRequestsSinAprobar() throws ExcepcionServiciosAeci;
    
    /**
     * Obtains the user given his id
     * @param id The user's id
     * @return The user searched
     * @throws ExcepcionServiciosAeci if id is null.
     */
    public abstract User getUser(int id)throws ExcepcionServiciosAeci;
    
    /**
     * Obtains the role given his id
     * @param id The role's id
     * @return The role
     * @throws ExcepcionServiciosAeci If id is null
     */
    public abstract Rol getRol(int id)throws ExcepcionServiciosAeci;
    
    /**
     * Update The user's first name given his id
     * @param idUser The user's id
     * @param firstName The new first name
     * @throws ExcepcionServiciosAeci if idUser is null
     */
    public abstract void updateUserFirstName(int idUser, String firstName) throws ExcepcionServiciosAeci;
    
    /**
     * Update The user's last name given his id
     * @param idUser The user's id
     * @param lastName The new last name
     * @throws ExcepcionServiciosAeci if idUser is null
     */
    public abstract void updateUserLastName(int idUser, String lastName) throws ExcepcionServiciosAeci;
    
    /**
     * Update The user's email given his id
     * @param idUser The user's id
     * @param email The new email
     * @throws ExcepcionServiciosAeci if idUser is null
     */
    public abstract void updateUserEmail(int idUser, String email) throws ExcepcionServiciosAeci;
    
    /**
     * Update The user's phone given his id
     * @param idUser The user's id
     * @param phone The new phone
     * @throws ExcepcionServiciosAeci id idUser is null
     */
    public abstract void updateUserPhone(int idUser, String phone) throws ExcepcionServiciosAeci;
    
    /**
     * Update The user's cell phone given his id
     * @param idUser The user's id
     * @param cellphone The new cell phone
     * @throws ExcepcionServiciosAeci If idUser is null
     */
    public abstract void updateUserCellphone(int idUser, String cellphone) throws ExcepcionServiciosAeci;
    
    /**
     * Update the user's program given his id
     * @param idUser The user's id
     * @param program_Id The new program id
     * @throws ExcepcionServiciosAeci If idUser is null or program_Id isn't in the data base or if it's null
     */
    public abstract void updateUserProgram_Id(int idUser, int program_Id) throws ExcepcionServiciosAeci;
    
    /**
     * Update the user's year graduate given his id
     * @param idUser The user's id
     * @param yearGraduate The new year graduate
     * @throws ExcepcionServiciosAeci if idUser is null
     */
    public abstract void updateUserYearGraduate(int idUser, int yearGraduate) throws ExcepcionServiciosAeci;
    
    /**
     * Update the user's birth date given his id
     * @param idUser The user's id
     * @param birthDate The new birth date
     * @throws ExcepcionServiciosAeci If idUser is null
     */
    public abstract void updateUserBirthDate(int idUser, java.util.Date birthDate) throws ExcepcionServiciosAeci;
    
    /**
     * Update the user's period of graduation given his id
     * @param idUser The user's id
     * @param period The new period
     * @throws ExcepcionServiciosAeci if idUser is null
     */
    public abstract void updateUserPeriod(int idUser, int period) throws ExcepcionServiciosAeci;
    
    /**
     * Update the user's role given his id
     * @param idUser The user's id
     * @param rol_Id The new role id
     * @throws ExcepcionServiciosAeci If idUser is null or if rol_Id is null
     */
    public abstract void updateUserRol_Id(int idUser, int rol_Id) throws ExcepcionServiciosAeci;
       
    /**
     * Add a new student into the data base
     * @param student The new student
     * @throws ExcepcionServiciosAeci If student id is null
     */
    public abstract void addStudent(Student student) throws ExcepcionServiciosAeci;
    
    /**
     * Sets the new photo in the database
     * @param student the student with a new photo of his student identification
     * @throws ExcepcionServiciosAeci If student id is null
     */
    public abstract void addCarnet(Student student)throws ExcepcionServiciosAeci;
    
    /**
     * Add a new graduate to the data base
     * @param graduate The new graduate
     * @throws ExcepcionServiciosAeci If the id of the graduate is null
     */
    public abstract void addGraduate(Graduate graduate) throws ExcepcionServiciosAeci;
    
    /**
     * Add a new membership to the data base
     * @param membership The new membership
     * @throws ExcepcionServiciosAeci If the membership id is null
     */
    public abstract void addMembership(Membership membership)throws ExcepcionServiciosAeci;
    
    /**
     * Update the membership payment, i.e, the image of the receipt and the payment number
     * @param membership The membership to be updated
     * @throws ExcepcionServiciosAeci If occurs any error
     */
    public abstract void updatePayment(Membership membership)throws ExcepcionServiciosAeci;
    
    /**
     * Gives a list with all the memberships nearly to expire.
     * @return a list with all the memberships nearly to expire.
     * @throws ExcepcionServiciosAeci if occurs any error
     */
    public abstract List<Membership> getSolicitudesPorVencerse()throws ExcepcionServiciosAeci;
    
    /**
     * Gives a list with all the memberships that's expire.
     * @return a list with all the memberships that's expire.
     * @throws ExcepcionServiciosAeci if occurs any error
     */
    public abstract List<Membership> getAfiliacionesVencidas()throws ExcepcionServiciosAeci;
    
    /**
     * Obtains the rate given his id
     * @param id The rate id
     * @return The rate
     * @throws ExcepcionServiciosAeci If the id is null
     */
    public abstract Rate getRate(int id)throws ExcepcionServiciosAeci;
    
    /**
     * Obtains the account given his id
     * @param id The account id
     * @return The account
     * @throws ExcepcionServiciosAeci if id is null
     */
    public abstract Account getAccount(int id)throws ExcepcionServiciosAeci;
}