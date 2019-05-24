/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import utilities.accounts.AccountType;

/**
 * an adapter to return an AccountType enum from a given string
 * @author Anthony
 */
public class AccountTypeAdapter implements IConvert {
    private final String strAccountType;
    
    /**
     * the string of account type to return
     * @param strAcctType - a string representation of the account type
     */
    public AccountTypeAdapter(String strAcctType)
    {
        strAccountType = strAcctType;
    }
    
    /**
     * the input string will always be of a set form, so only requires this 
     * switch statement to identify the enum to return
     * @return - returns an enum reference
     */
    @Override
    public AccountType convert()
    {
        switch (strAccountType)
        {
            case "Admin":
                return AccountType.ADMIN;
            case "Secretary":
                return AccountType.SECRETARY;
            case "Doctor":
                return AccountType.DOCTOR;
            case "Patient":
                return AccountType.PATIENT;
        }
        return null;
    }
}
