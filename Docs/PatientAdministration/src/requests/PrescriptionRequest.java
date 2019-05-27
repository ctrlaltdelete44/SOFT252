/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

import accounts.Account;
import accounts.Patient;
import appointments.Prescription;
import java.io.Serializable;
import medicinecabinet.StockItem;
import utilities.serialised.StockSingleton;

/**
 * request for a prescription - when a patient is assigned a prescription, it
 * follows the same pipeline as other requests as a patient would need to visit
 * a secretary to collect it
 *
 * @author davie
 */
public class PrescriptionRequest extends Request implements Serializable {

    private Prescription prescription;

    /**
     * all requests start with basic information assigned
     *
     * @param a - the account making the request
     * @param rt - the type of request
     */
    public PrescriptionRequest(Account a, RequestType rt) {
        super(a, rt);
    }

    /**
     * after creation, the target prescription is added to the request
     *
     * @param p - the prescription to addObject
     */
    public void assignPrescription(Prescription p) {
        prescription = p;
        track();
    }

    /**
     * standard accessor for prescription
     *
     * @return - the prescription linked to this request
     */
    public Prescription getPrescription() {
        return prescription;
    }

    /**
     * the request type used for identification purposes
     *
     * @return - returns PRESCRIPTION
     */
    @Override
    public RequestType getRequestType() {
        return RequestType.PRESCRIPTION;
    }

    /**
     * on processing, this will check that the requested prescription is in
     * stock. then it will set the prescription associated with this request to
     * be the patients active prescription
     *
     * @return - returns a positive or negative message based on whether the
     * item is in stock
     */
    @Override
    public String process() {
        Patient patient = (Patient) account;

        StockItem stockToGive = StockSingleton.getOrCreate().requestStock(prescription.getMedicine(), prescription.getQuantity());
        if (stockToGive != null) {
            patient.setPrescription(prescription);
            return patient.getFirstName() + " " + patient.getSurname() + " has collected prescription of " + prescription.getQuantity() + " " + prescription.getMedicine();
        } else {
            return "This prescription is not in stock. Please replenish stock";
        }
    }

    /**
     * prescription template for viewing the request
     *
     * @return - returns a summary of request
     */
    @Override
    public String viewRequest() {
        return account.getFirstName() + " " + account.getSurname() + ": " + RequestType.PRESCRIPTION + ": " + prescription.getQuantity() + " " + prescription.getMedicine();
    }

}
