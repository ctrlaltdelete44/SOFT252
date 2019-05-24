/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

/**
 *
 * @author Anthony
 */
public enum RequestType {

    /**
     * requests to create an account
     */
    CREATE,

    /**
     * requests to delete an account
     */
    DELETE,

    /**
     * requests for an appointment
     */
    APPOINTMENT,

    /**
     * requests for a prescription
     */
    PRESCRIPTION,

    /**
     * requests for new stock (made by doctors)
     */
    STOCK;
}
