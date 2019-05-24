/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import utilities.accounts.AccountType;
import java.io.Serializable;

/**
 * a class to generate a new id for an account 
 * @author Anthony
 */
public class IdGenerator implements Serializable{
    private static int idNumber;
    
    private IdGenerator()
    {
        idNumber = 1;
    }
    
    /**
     * used only in deserialisation to assign a new base number
     * @param number - the starting number for new id's
     */
    public static void setIdNumber(int number)
    {
        idNumber = number;
    }

    /**
     * standard accessor used in serialisation
     * @return - the current id number
     */
    public static int getIdNumber() {
        return idNumber;
    }
    
    /**
     * static method to generate a new id
     * @param account - the account type of the new account
     * @return - returns the new id
     */
    public static String generateNextId(AccountType account)
    {
        String accountCode;
        
        //decides which letter to add to id based on account type
        switch (account)
        {
            case ADMIN:
                accountCode = "A";
                break;
            case SECRETARY:
                accountCode = "S";
                break;
            case DOCTOR:
                accountCode = "D";
                break;
            case PATIENT:
                accountCode = "P";
                break;
            default:
                accountCode = "X";
                break;
        }
        
       String accountNo = "";
        
       //decides how many 0's are needed based on the size of number and concatenates
        if (idNumber < 10)
            accountNo = "000" + idNumber;
        else if (idNumber < 100)
            accountNo = "00" + idNumber;
        else if (idNumber < 1000)
            accountNo = "0" + idNumber;
        else if (idNumber < 10000)
            accountNo = "" + idNumber;     
        
        //increments idNumber for use in next generation
        idNumber++;
        return accountCode + accountNo;
    }
}
