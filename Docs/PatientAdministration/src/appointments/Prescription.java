/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments;

import accounts.Doctor;
import accounts.Patient;
import java.io.Serializable;

/**
 * class containing all information pertaining to a prescription
 * @author davie
 */
public class Prescription implements Serializable {
    private final String medicine;
    private final int quantity;
    private final String dosage;
    private final String notes;
    private final Patient patient;
    private final Doctor doctor;
    
    /**
     * all information required on creation of a prescription
     * @param medicine - the medicine prescribed
     * @param quantity - the quantity of medicine prescribed
     * @param dosage - dosage guidelines from doctor
     * @param notes - notes made by doctor during consultation
     * @param patient - patient to receive prescription
     * @param doctor - doctor who assigned prescription
     */
    public Prescription(String medicine, int quantity, String dosage, String notes, Patient patient, Doctor doctor) {
        this.medicine = medicine;
        this.quantity = quantity;
        this.dosage = dosage;
        this.patient = patient;
        this.doctor = doctor;
        this.notes = notes;
        
        //System.out.println("Prescription has doasge of: " + this.dosage + ":PRESCRIPTION");
    }

    /**
     * standard accessor method
     * @return - the type of medicine 
     */
    public String getMedicine() {
        return medicine;
    }

    /**
     * standard accessor method
     * @return - the quantity of medicine
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * standard accessor method
     * @return - any dosage guidelines being written by doctor
     */
    public String getDosage() {
        return dosage;
    }

    /**
     * standard accessor method
     * @return - the patient prescribed to
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * standard accessor method
     * @return - doctor who prescribed this
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * standard accessor method
     * @return - notes made by doctor
     */
    public String getNotes() {
        return notes;
    }
    
    
    
    
}
