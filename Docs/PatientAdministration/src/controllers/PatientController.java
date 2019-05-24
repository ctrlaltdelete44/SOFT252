/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Doctor;
import utilities.accounts.AccountType;
import accounts.Patient;
import utilities.AccountAdapter;
import appointments.Appointment;
import java.time.LocalDate;
import utilities.DateAdapter;
import utilities.serialised.Compilation;

/**
 * controller for patient specific functionality
 * @author Anthony
 */
public class PatientController {    
    Patient authorisingPatient = null;   
    private static PatientController instance = null;
    
    private PatientController()
    {        
    }
    
    /**
     * controller kept as a singleton to preserve the authorising patient
     * @return - returns the active instance of controller
     */
    public static PatientController getOrCreate()
    {
        if (instance == null)
            instance = new PatientController();
        return instance;
    }

    /**
     * standard accessor
     * @return - the logged in patient
     */
    public Patient getAuthorisingPatient() {
        return authorisingPatient;
    }

    /**
     * standard mutator
     * @param authorisingPatient - the new patient to set as logged in
     */
    public void setAuthorisingPatient(Patient authorisingPatient) {
        this.authorisingPatient = authorisingPatient;
    }
    
    /**
     * patients need to put in a request for a new account 
     * @param first - first name
     * @param last - surname
     * @param address - address
     * @param sex - sex of patient
     * @param age - age of patient
     * @param arrPassword - password as an array, created as such by password box
     */
    public void requestCreation(String first, String last, String address, String sex, int age, char[] arrPassword)
    {        
        Compilation c= new Compilation();
        c.deconstruct();
        Patient p = new Patient(first, last, address);
        p.assignPatientInfo(sex, age, arrPassword);
    }
    
    /**
     * puts forward a request to terminate own account
     */
    public void requestDeletion()
    {
        authorisingPatient.createDeleteRequest();
    }
    
    /**
     * returns a list of doctors and their ratings for patients to request appointments
     * @return - the list of doctor information
     */
    public String[] viewDoctors()
    {
        return authorisingPatient.viewAccounts(AccountType.DOCTOR);
    }
    
    /**
     * patients can submit feedback on a doctor and provide a rating
     * @param rating - the rating out of 5 provided
     * @param comments - any comments the patient wants to submit
     * @param account - the doctor to provide feedback to
     */
    public void provideFeedback(int rating, String comments, String account)
    {
        authorisingPatient.provideFeedback(rating, comments, account);
    }
    
    /**
     * returns a list of information regarding a doctors free dates
     * @param strDoctor - the doctor requested
     * @return - returns an array of strings for use by jlist
     */
    public String[] viewDoctorAvailability(String strDoctor)
    {
        AccountAdapter adapter = new AccountAdapter(strDoctor);
        Doctor doctor = (Doctor)adapter.convert();
        
        return doctor.viewFreeDates();
    }
    
    /**
     * patients can request appointment by selecting a doctor and a date
     * @param strDoctor - the selected doctor's account information
     * @param strDate - the selected patient's account information
     */
    public void requestAppointment(String strDoctor, String strDate)
    {       
        DateAdapter datAdapter = new DateAdapter(strDate);
        LocalDate date = datAdapter.convert();
        
        authorisingPatient.createAppointmentRequest(strDoctor, date);
    }
    
    /**
     * when a patient has an active appointment, certain functionalities are
     * limited to them
     * @return - returns information abt the patients appointment to display
     */
    public String viewNextAppointment()
    {
        Appointment app = authorisingPatient.getAppointment();
        
        if (app != null)
        {
            //System.out.println("Returning that patient has appt:PCONTROLLER");
            return app.getDoctor().getFirstName() + " " + app.getDoctor().getSurname() + " on " + app.getDate();
        }
        else
        {
            //System.out.println("Returning null:PCONTROLLER");
            return "";
            
        }
    }
    
    /**
     * method to view the patients own history
     * @return - an array of the patients history
     */
    public String[] viewHistory()
    {
        return authorisingPatient.viewHistory();
    }
    
    /**
     * when viewing a prescription, certain information is required to be displayed
     * @return - returns a compilation of information about the patient
     */
    public String viewPrescriptionPatient()
    {
        return authorisingPatient.viewPatient();
    }
    
    /**
     * when viewing a prescription, certain information is required to be displayed
     * @return - returns a compilation of information about the doctor
     */
    public String viewPrescriptionDoctor()
    {
        return authorisingPatient.viewDoctor();
    }
    
    /**
     * when viewing a prescription, certain information is required to be displayed
     * @return - returns the notes made during the consultation
     */
    public String viewPrescriptionNotes()
    {
        return authorisingPatient.viewNotes();
    }
    
    /**
     * when viewing a prescription, certain information is required to be displayed
     * @return - returns a summary of the prescription made
     */
    public String viewPrescriptionMedicine()
    {
        return authorisingPatient.viewMedicine();
    }
    
    /**
     * used for checking if a patient has an active prescription
     * @return - returns a boolean based on the patients active prescription status
     */
    public Boolean isActivePrescription()
    {
        return authorisingPatient.getPrescription() != null;
    }
}
