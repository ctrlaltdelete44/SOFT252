/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import appointments.Appointment;

/**
 * a list of all active appointments
 * @author davie
 */
public class AppointmentSingleton implements Serializable {
    private ArrayList<Appointment> appointments;
    private static AppointmentSingleton instance = null;
    
    private final Compilation c = new Compilation();
    
    private AppointmentSingleton()
    {
        appointments = new ArrayList<>();
    }
    
    /**
     * this is a singleton, this method returns the active instance
     * @return - returns active instance
     */
    public static AppointmentSingleton getOrCreate()
    {
        if (instance == null)
            instance = new AppointmentSingleton();
        return instance;
    }
    
    /**
     * removes a given appointment from the singleton
     * @param appRemove - the appointment to remove
     * @return - returns the removed appointment for testing purposes
     */
    public Appointment removeAppointment(Appointment appRemove)
    {        
        for (Appointment appointment : appointments)
        {
            if (appointment.getDoctor().getUniqueId().contentEquals(appRemove.getDoctor().getUniqueId()) && appointment.getDate().equals(appRemove.getDate()))
            {
                //System.out.println("Removed appointment");
                appointments.remove(appointment);
                return appointment;
            }
        }
        c.construct();
        return null;
    }
    
    /**
     * adds an appointment to the tracker
     * @param a - the appointment to add
     */
    public void addAppointment(Appointment a)
    {
        appointments.add(a);
        //System.out.println("Added appointment");
        c.construct();
    }
    
    /**
     * standard accessor
     * @return - returns the list of appointments
     */
    public ArrayList<Appointment> getAppointments()
    {
        return appointments;
    }
    
    /**
     * alternate accessor. retrieves only appointments from a given doctor
     * @param doctorId - the doctor to search for
     * @return - the list of appointments associated with this doctor
     */
    public ArrayList<Appointment> getAppointments(String doctorId)
    {
        //c.deconstruct();
        ArrayList<Appointment> listReturn = new ArrayList<>();
        
        for (Appointment a : appointments)
        {           
            if (!a.getDoctor().getUniqueId().contentEquals(doctorId)) {
            } else {
                listReturn.add(a);
                //System.out.println(a.getDoctor().getFirstName() + " and " + a.getPatient().getFirstName() + " on " + a.getDate() + ":APPOINTMENTSINGLETON");
            }
        }
        
        return listReturn;
    }
    
    /**
     * retrieves an appointment for a given doctor on a given date
     * @param doctorId - the doctor to search for
     * @param date - the date to search for
     * @return - the appointment, if found
     */
    public Appointment getAppointment(String doctorId, LocalDate date)
    {
        for (Appointment a : getAppointments(doctorId))
        {
            if (a.getDate().equals(date))
                return a;
        }
        return null;
    }

    /**
     * mutator. breaks singleton principle, but is only ever used on deserialisation
     * and overwrites previous instance
     * @param appointments - the new appointments to set
     */
    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }
    
    /**
     * returns a boolean on whether a doctor has an appointment on a given date
     * @param docId - the doctor to search for
     * @param date - the date to search for
     * @return - a boolean confirmation
     */
    public boolean isActiveBooking(String docId, LocalDate date)
    {
        for (Appointment a : getAppointments(docId))
        {
            if (a.getDate().equals(date))
                return true;
        }
        return false;
    }

}
