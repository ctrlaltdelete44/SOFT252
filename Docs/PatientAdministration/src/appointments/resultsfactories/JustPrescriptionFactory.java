/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.resultsfactories;

import accounts.Doctor;
import accounts.Patient;
import appointments.results.Action;
import appointments.results.AssignedPrescription;
import utilities.accounts.HistoryItem;

/**
 * the concrete implementation for when only a prescription needed
 *
 * @author davie
 */
public class JustPrescriptionFactory extends AbstractResultsFactory {

    private AssignedPrescription prescription;

    /**
     * the notes made during consultation
     *
     * @param strNotes - notes made by doctor during consultation
     */
    public JustPrescriptionFactory(String strNotes) {
        super(strNotes);
    }

    /**
     * the overridden method for adding the prescription, with additional
     * validation to prevent appointments from being added
     *
     * @param a - action to add
     */
    @Override
    public void addAction(Action a) {
        switch (a.getActionType()) {
            case PRESCRIPTION:
                //System.out.println("Adding prescription:PRESCRIPTIONANDAPPOINTMENT");
                prescription = (AssignedPrescription) a;
                prescription.processRequest();
                break;
        }
    }

    /**
     * adds this appointment result as a history item to the patient
     *
     * @param p - patient to add item to
     * @param d - doctor who hosted consultation
     */
    @Override
    public void addHistory(Patient p, Doctor d) {
        HistoryItem h = new HistoryItem(this.notes, this.prescription.getPrescription(), d, false);
        p.addHistoryItem(h);
        p.addNotification("Your appointment has been processed with a prescription assigned");
    }
}
