/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.results;

import accounts.Patient;
import appointments.Prescription;
import java.io.Serializable;

/**
 * this combines the prescription class and the overridden method for processing
 * a request
 *
 * @author davie
 */
public class AssignedPrescription extends Action implements Serializable {

    private final Prescription prescription;
    private final Patient p;

    /**
     * the prescription to process
     *
     * @param prescription - the prescription
     * @param p - the patient making the request
     */
    public AssignedPrescription(Prescription prescription, Patient p) {
        this.prescription = prescription;
        this.p = p;
    }

    /**
     * standard accessor
     *
     * @return the prescription associated with this
     */
    public Prescription getPrescription() {
        return prescription;
    }

    /**
     * creates a new request from the patient who is currently having an
     * appointment
     */
    @Override
    public void processRequest() {
        p.createPrescriptionRequest(prescription);
    }

    /**
     * returns prescription enum
     *
     * @return - returns PRESCRIPTION
     */
    @Override
    public ActionType getActionType() {
        return ActionType.PRESCRIPTION;
    }

}
