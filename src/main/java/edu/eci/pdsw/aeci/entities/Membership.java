/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.pdsw.aeci.entities;

import java.sql.Date;

/**
 *
 * @author 2095498
 */
public class Membership {
    
    private int id;
    private Date start_Date;
    private Date end_Date;
    private String receipt;
    private int playmentNumber;
    private Account account;
    private Rate rate;

    public Membership() {
    }

    public Membership(int Id,Date Start_Date,Date End_Date,String Receipt,int PlaymentNumber,Account Account_id,Rate Rate_id){        
        id=Id;
        start_Date=Start_Date;
        end_Date=End_Date;
        receipt=Receipt;
        playmentNumber=PlaymentNumber;
        account=Account_id;
        rate=Rate_id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStart_Date() {
        return start_Date;
    }

    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    public Date getEnd_Date() {
        return end_Date;
    }

    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    public String getReceipt() {
        return receipt;
    }

    public void setReceipt(String receipt) {
        this.receipt = receipt;
    }

    public int getPlaymentNumber() {
        return playmentNumber;
    }

    public void setPlaymentNumber(int playmentNumber) {
        this.playmentNumber = playmentNumber;
    }

    public Account getAccount_id() {
        return account;
    }

    public void setAccount_id(Account account_id) {
        this.account = account_id;
    }

    public Rate getRate_id() {
        return rate;
    }

    public void setRate_id(Rate rate_id) {
        this.rate = rate_id;
    }
    
}
