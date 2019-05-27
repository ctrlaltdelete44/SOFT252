/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import utilities.accounts.AccountType;
import java.io.Serializable;
import utilities.Serialiser;

/**
 * a class to generate a new id for an account
 *
 * @author Anthony
 */
public class IdGenerator implements Serializable {

    private static Integer idNumber;
    //private static final Serialiser idSerialiser = new Serialiser("data/series.paa");

    public IdGenerator() {
       loadData();

            //idNumber = 0;
            //saveChanges();

    }

    /**
     * used only in deserialisation to assign a new base number
     *
     * @param number - the starting number for new id'idSerialiser
     */
    public static void setIdNumber(int number) {
        idNumber = number;
    }

    /**
     * standard accessor used in serialisation
     *
     * @return - the current id number
     */
    public static int getIdNumber() {
        loadData();
        return idNumber;
    }

    /**
     * static method to generate a new id
     *
     * @param account - the account type of the new account
     * @return - returns the new id
     */
    public static String generateNextId(AccountType account) {
        String accountCode;
        loadData();

        //decides which letter to add to id based on account type
        switch (account) {
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

        //decides how many 0'idSerialiser are needed based on the size of number and concatenates
        if (idNumber < 10) {
            accountNo = "000" + idNumber;
        } else if (idNumber < 100) {
            accountNo = "00" + idNumber;
        } else if (idNumber < 1000) {
            accountNo = "0" + idNumber;
        } else if (idNumber < 10000) {
            accountNo = "" + idNumber;
        }

        //increments idNumber for use in next generation
        idNumber++;
        saveChanges();

        return accountCode + accountNo;
    }

    public static void saveChanges() {
        new Serialiser("data/series.paa").serialise(idNumber);;
    }

    public static void loadData() {
        idNumber = (Integer) new Serialiser("data/series.paa").deserialise();
    }
}
