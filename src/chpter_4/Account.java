/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chpter_4;

import java.io.Serializable;

/**
 *
 * @author WH1108
 */
public class Account implements Serializable{
    private int accountNo ;
    private String accountName;
    private float accountBalance;

    public Account(int accountNo, String accountName, float accountBalance) {
        this.accountNo = accountNo;
        this.accountName = accountName;
        this.accountBalance = accountBalance;
    }

    public Account() {
    }

    public int getAccountNo() {
        return accountNo;
    }

    public String getAccountName() {
        return accountName;
    }

    public float getAccountBalance() {
        return accountBalance;
    }

    public void setAccountNo(int accountNo) {
        this.accountNo = accountNo;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountBalance(float accountBalance) {
        this.accountBalance = accountBalance;
    }
    
}
