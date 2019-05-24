/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.availability;

import appointments.Appointment;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * used by availability, used to store an date and any associated appointment
 * @author davie
 */
public class AvailableDate implements Serializable {
    private final LocalDate date;
    private Appointment appointment;
    
    /**
     * the date associated with this 
     * @param date - date of appointment
     */
    public AvailableDate(LocalDate date) {
        this.date = date;
        appointment = null;
    }
    
    /**
     * standard mutator for the appointment
     * @param appointment - the appointment to assign
     */
    public void setAppointment(Appointment appointment)
    {
        this.appointment = appointment;
    }
    
    /**
     * standard accessor
     * @return - returns the associated date
     */
    public LocalDate getDate()
    {
        return date;
    }

    /**
     * standard accessor
     * @return - returns any appointment stored with this date
     */
    public Appointment getAppointment() {
        return appointment;
    }

    
    
}
