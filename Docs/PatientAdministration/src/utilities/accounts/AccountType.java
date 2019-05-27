/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.accounts;

/**
 * an enumeration to identify the access level for an account
 *
 * @author Anthony
 */
public enum AccountType {

    /**
     * denotes the account as a patient
     */
    PATIENT,
    /**
     * denotes the account as a secretary
     */
    SECRETARY,
    /**
     * denotes the account as an admin
     */
    ADMIN,
    /**
     * denotes the account as a doctor
     */
    DOCTOR
}
