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
    private byte[] receipt;
    private int playmentNumber;
    private Account account;
    private Rate rate;

    public Membership() {
    }

    public Membership(int Id,Date Start_Date,Date End_Date,Account Account_id,Rate Rate_id){        
        this.id=Id;
        this.start_Date=Start_Date;
        this.account=Account_id;
        this.rate=Rate_id;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the start_Date
     */
    public Date getStart_Date() {
        return start_Date;
    }

    /**
     * @param start_Date the start_Date to set
     */
    public void setStart_Date(Date start_Date) {
        this.start_Date = start_Date;
    }

    /**
     * @return the end_Date
     */
    public Date getEnd_Date() {
        return end_Date;
    }

    /**
     * @param end_Date the end_Date to set
     */
    public void setEnd_Date(Date end_Date) {
        this.end_Date = end_Date;
    }

    /**
     * @return the receipt
     */
    public byte[] getReceipt() {
        return receipt;
    }

    /**
     * @param receipt the receipt to set
     */
    public void setReceipt(byte[] receipt) {
        this.receipt = receipt;
    }

    /**
     * @return the playmentNumber
     */
    public int getPlaymentNumber() {
        return playmentNumber;
    }

    /**
     * @param playmentNumber the playmentNumber to set
     */
    public void setPlaymentNumber(int playmentNumber) {
        this.playmentNumber = playmentNumber;
    }

    /**
     * @return the account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * @param account the account to set
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * @return the rate
     */
    public Rate getRate() {
        return rate;
    }

    /**
     * @param rate the rate to set
     */
    public void setRate(Rate rate) {
        this.rate = rate;
    }
    
    /**
     * 
     */
    @Override
    public String toString(){
        return "Image{"+"img="+receipt+", name="+id+"}";
    }
}
