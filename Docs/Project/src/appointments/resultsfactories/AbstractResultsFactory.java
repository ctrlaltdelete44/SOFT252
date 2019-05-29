/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.resultsfactories;

import accounts.Doctor;
import accounts.Patient;
import appointments.Prescription;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashMap;

/**
 *
 * @author Anthony
 */
public abstract class AbstractResultsFactory implements Serializable {

    protected final HashMap<String, Boolean> actions;
    
    protected String notes = null;
    protected Boolean isAppointment = false;
    protected Boolean isPrescription = false;

    protected Patient patient = null;
    protected Doctor doctor = null;
    
    protected LocalDate appointmentDate = LocalDate.MIN;
    
    protected String prescriptionName = null;
    protected String prescriptionDosage = null;
    protected Integer prescriptionQuantity = null;
    
    protected Prescription prescription = null;

    public AbstractResultsFactory(HashMap<String, Boolean> actions, String notes, Patient patient, Doctor doctor, LocalDate appointmentDate, String prescriptionName, String prescriptionDosage, Integer prescriptionQuantity) {
        this.actions = actions;
        this.notes = notes;
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDate = appointmentDate;
        this.prescriptionName = prescriptionName;
        this.prescriptionDosage = prescriptionDosage;
        this.prescriptionQuantity = prescriptionQuantity;
        
        createActions();
    }
   
    
    public abstract void createActions(); 
    
    public abstract void addHistory(Patient patient, Doctor doctor);
}
