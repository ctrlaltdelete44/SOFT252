/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.accounts;

import accounts.Doctor;
import appointments.Prescription;
import java.io.Serializable;

/**
 * a history item associated with a patient containing all the information
 * needed to print a report on the appointment
 *
 * @author davie
 */
public class HistoryItem implements Serializable {

    private final String notes;
    private final Prescription prescription;
    private final Doctor doctor;
    private final Boolean isFurtherAppointment;

    /**
     *
     * @param notes - notes made during the appointment
     * @param prescription - the prescription made (a full reference needed so
     * that the dosage guidelines can also be printed)
     * @param doctor - the doctor who took the appointment
     * @param isFurtherAppointment - whether or not a further appointment was
     * scheduled
     */
    public HistoryItem(String notes, Prescription prescription, Doctor doctor, Boolean isFurtherAppointment) {
        this.notes = notes;
        this.prescription = prescription;
        this.doctor = doctor;
        this.isFurtherAppointment = isFurtherAppointment;
    }

    public String getNotes() {
        return notes;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Boolean getIsFurtherAppointment() {
        return isFurtherAppointment;
    }

    /**
     * @return - returns a report on the history item based on the stored
     * information
     */
    @Override
    public String toString() {
        String strReturn = "<html>Appointment taken by " + doctor.getFirstName() + " " + doctor.getSurname() + ":<br/>" + notes + ".<br/>";

        if (prescription != null) {
            strReturn += "Patient prescribed: " + prescription.getQuantity() + " " + prescription.getMedicine() + "<br/>Dosage: " + prescription.getDosage() + ".<br/>";
        } else {
            strReturn += "No prescription given.<br/>";
        }

        if (isFurtherAppointment) {
            strReturn += "Further apppointment scheduled. ";
        } else {
            strReturn += "No further appointment needed. ";
        }

        return strReturn;
    }

}
