/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.accounts;

import accounts.Doctor;
import appointments.Prescription;
import appointments.results.Notes;
import java.io.Serializable;

/**
 * a history item associated with a patient containing all the information
 * needed to print a report on the appointment
 * @author davie
 */
public class HistoryItem implements Serializable{
    private final Notes notes;
    private final Prescription prescription;
    private final Doctor doctor;
    private final Boolean isFurtherAppointment;
    
    /**
     *
     * @param notes - notes made during the appointment
     * @param prescription - the prescription made (a full reference needed so that the dosage guidelines can also be printed)
     * @param doctor - the doctor who took the appointment
     * @param isFurtherAppointment - whether or not a further appointment was scheduled
     */
    public HistoryItem(Notes notes, Prescription prescription, Doctor doctor, Boolean isFurtherAppointment) {
        this.notes = notes;
        this.prescription = prescription;
        this.doctor = doctor;
        this.isFurtherAppointment = isFurtherAppointment;
    }

    /**
     * standard accessor
     * @return - notes made during consultation
     */
    public Notes getNotes() {
        return notes;
    }

    /**
     * standard accessor
     * @return - any prescription made
     */
    public Prescription getPrescription() {
        return prescription;
    }

    /**
     * standard accessor
     * @return - the doctor who took the appointment
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * standard accessor
     * @return - whether or not a further appointment was needed
     */
    public Boolean getIsFurtherAppointment() {
        return isFurtherAppointment;
    }
    
    /**
     * @return - returns a report on the history item based on the stored information
     */
    public String printHistoryItem()
    {
        String strReturn = "<html>Appointment taken by " + doctor.getFirstName() + " " + doctor.getSurname() + ":<br/>" + notes.getNotes() + ".<br/>";
        
        if (prescription != null)
            strReturn += "Patient prescribed: " + prescription.getQuantity() + " " + prescription.getMedicine() + "<br/>Dosage: " + prescription.getDosage() + ".<br/>";       
        else
            strReturn += "No prescription given.<br/>";
        
        
        if (isFurtherAppointment)
            strReturn += "Further apppointment scheduled. ";
        else
            strReturn += "No further appointment needed. ";
        
        return strReturn;
    }
    
}
