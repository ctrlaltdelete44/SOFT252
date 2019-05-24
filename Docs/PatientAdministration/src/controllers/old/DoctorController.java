/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.old;

import accounts.Doctor;
import accounts.Patient;
import appointments.Appointment;
import utilities.AppointmentAdapter;

/**
 *
 * @author davie
 */
public class DoctorController {
    private Doctor authorisingDoctor = null;
    private Appointment activeAppointment = null;
    private static DoctorController instance = null;
    
    private DoctorController()
    {
        
    }
    
    /**
     * doctor controller is a singleton to preserve authorisingdoctor. this 
     * returns active instance
     * @return - instance of controller
     */
    public static DoctorController getOrCreate()
    {
        if (instance == null)
            instance = new DoctorController();
        return instance;
    }

    /**
     * standard accessor
     * @return - active doctor
     */
    public Doctor getAuthorisingDoctor() {
        return authorisingDoctor;
    }

    /**
     * standard mutator
     * @param authorisingDoctor - the doctor logging in
     */
    public void setAuthorisingDoctor(Doctor authorisingDoctor) {
        this.authorisingDoctor = authorisingDoctor;
    }
    
    /**
     * standard accessor
     * @return - the doctors rating
     */
    public double getRating()
    {
        return authorisingDoctor.getRating();
    }
    
    /**
     * returns the doctors schedule as a string array for use by jlist
     * @return - the array of the schedule
     */
    public String[] viewSchedule()
    {
        return authorisingDoctor.viewEntireSchedule();
    }
    
    /**
     * returns only the doctors free days as a string array
     * @return - the list of free days
     */
    public String[] viewFreeDays()
    {
        return authorisingDoctor.viewFreeDates();
    }
    
    /**
     * returns only booked days as a string array
     * @return - the list of bookings
     */
    public String[] viewBookings()
    {
        return authorisingDoctor.viewBookings();
    }
    
    /**
     * when an appointment is taken, it is set as the "active appointment". 
     * this allows access to the appointments fields
     * @param strAppointment - the summary of appointment information
     */
    public void setActiveAppointment(String strAppointment)
    {
        //System.out.println("Set active appointment, format of: " + strAppointment);
        AppointmentAdapter adapter = new AppointmentAdapter(strAppointment, authorisingDoctor.getUniqueId());
        activeAppointment = adapter.convert();
    }
    
    /**
     * accessor for the active appointment
     * @return - the reference to active appointment
     */
    public Appointment getActiveAppointment()
    {
        return activeAppointment;
    }
    
    /**
     * accessor for the active appointment's patient
     * @return - returns a summary of patient account
     */
    public String getActiveAppointmentPatient()
    {
        Patient p = activeAppointment.getPatient();
        return p.viewAccount();
    }
    
    /**
     * accessor for the active appointment's doctor
     * @return - returns a summary of account
     */
    public String getActiveAppointmentDoctor()
    {
        return authorisingDoctor.viewAccount();
    }
    
    /**
     * once an appointment is held, it is processed with a number of possible outcomes and
     * results thereof. this uses an abstract factory to decide what the outcomes are
     * however, it needs a lot of parameters as all of this information is potentially needed
     * @param notes - notes made during consultation
     * @param prescriptionName - the name of any prescription made
     * @param prescriptionQuantity - the quantity of any prescription made
     * @param dosage - the dosage rules of any prescription made
     * @param timeQuantity - the quantity of "time units" that dictates when a future appointment should be made
     * @param timeFrame - the time units selected
     */
    public void processAppointment(String notes, String prescriptionName, Integer prescriptionQuantity, String dosage, Integer timeQuantity, String timeFrame)
    {
        Patient p = activeAppointment.getPatient();
        
        //notes is not null, others can be
        if (prescriptionName == null && timeQuantity == null)
            authorisingDoctor.noActionRequired(notes, p);
        else if (prescriptionName == null && timeQuantity != null)
            authorisingDoctor.justAppointmentRequired(notes, timeQuantity, timeFrame, p);
        else if (prescriptionName != null && timeQuantity == null)
            authorisingDoctor.justPrescriptionRequired(notes, prescriptionName, prescriptionQuantity, dosage, p);
        else
            authorisingDoctor.bothActionsRequired(notes, prescriptionName, dosage, prescriptionQuantity, timeQuantity, timeFrame, p);
        
        activeAppointment.getPatient().clearAppointment();
        authorisingDoctor.clearDate(activeAppointment.getDate());

        activeAppointment = null;
        
    }
    
    /**
     * debugging. prints a report on the doctors availability
     */
    public void printAvailability()
    {
        authorisingDoctor.getAvailabilityData();
    }
    
    /**
     * doctors have the ability to schedule a new week of availability
     */
    public void scheduleWeek()
    {
        authorisingDoctor.scheduleWeek();
    }
    
    /**
     * returns the history of the active appointment's patient to view
     * @return - returns patients history as a string array
     */
    public String[] viewActivePatientHistory()
    {
        return activeAppointment.getPatient().viewHistory();
    }
    
    /**
     * doctors can request stock, and this processes that request
     * @param requested - the stock requested
     */
    public void requestMedicine(String requested)
    {
        authorisingDoctor.createStockRequest(requested);
    }
}
