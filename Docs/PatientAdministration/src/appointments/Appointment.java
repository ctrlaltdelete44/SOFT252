/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments;

import accounts.Doctor;
import accounts.Patient;
import java.io.Serializable;
import java.time.LocalDate;
import utilities.serialised.AccountSingleton;
import utilities.serialised.AppointmentSingleton;
//import utilities.serialised.Compilation;

/**
 * class containing all information pertaining to an appointment
 * @author davie
 */
public class Appointment implements Serializable{
    private Patient patient;
    private Doctor doctor;
    private final LocalDate date;
    
    private String doctorNotes;
    
    private final AppointmentSingleton appointments = AppointmentSingleton.getOrCreate();
    private final AccountSingleton accounts = AccountSingleton.getOrCreate();
    
    //private final Compilation c = new Compilation();

    /**
     *
     * @param patient - the patient attending the appointment
     * @param doctor - the doctor hosting the appointment
     * @param date - date of appointment
     */
    public Appointment(Patient patient, Doctor doctor, LocalDate date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;   
        //System.out.println("Appointment created");
    }

    /**
     * utility method to link this appointment to the patient and to add it to tracker
     */
    public void connect()
    {
        //System.out.println("Attempting to connect appointment");
        appointments.addAppointment(this);
        patient.setAppointment(this);
        
        accounts.saveChanges();
        appointments.saveChanges();
    }
    
    /**
     * standard getter
     * @return - returns patient associated to patient
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * standard setter
     * @param patient - the patient to assign to an appointment
     */
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    /**
     * standard getter
     * @return - the doctor linked to appointment
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * standard setter
     * @param doctor - the doctor to assign to this appointment
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * standard getter
     * @return - the date of appointment
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * standard getter
     * @return - the notes made by doctor during consultation
     */
    public String getDoctorNotes() {
        return doctorNotes;
    }

    
}
