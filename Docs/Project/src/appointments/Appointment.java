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

/**
 * class containing all information pertaining to an appointment
 *
 * @author davie
 */
public class Appointment implements Serializable {

    private Patient patient;
    private Doctor doctor;
    private final LocalDate date;

    private String doctorNotes;

    private final AppointmentSingleton appointments = AppointmentSingleton.getOrCreate();
    private final AccountSingleton accounts = AccountSingleton.getOrCreate();

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
        
        System.out.println("New appt created!");
    }

    /**
     * utility method to link this appointment to the patient and to addObject it to
 tracker
     */
    public void connect() {
        System.out.println("Connecting to patient account");
        appointments.addObject(this);
        patient.setAppointment(this);

        accounts.saveChanges();
        //appointments.saveChanges();
    }

    public Patient getPatient() {
        return patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDoctorNotes() {
        return doctorNotes;
    }

}
