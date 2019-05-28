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
import java.util.Iterator;
import utilities.Serialiser;

/**
 * a list of all active appointments
 *
 * @author davie
 */
public class AppointmentSingleton implements Serializable, ISerialise {

    private ArrayList<Appointment> appointments;
    private static AppointmentSingleton instance = null;

    private AppointmentSingleton() {
        loadData();
        //appointments = new ArrayList<Appointment>();
        //saveChanges();

    }

    /**
     * this is a singleton, this method returns the active instance
     *
     * @return - returns active instance
     */
    public static AppointmentSingleton getOrCreate() {
        if (instance == null) {
            instance = new AppointmentSingleton();
        }
        return instance;
    }

    @Override
    public void addObject(Object o) {
        Appointment a = (Appointment) o;
        appointments.add(a);
        saveChanges();
    }

    @Override
    public void removeObject(Object o) {
        Appointment appRemove = (Appointment) o;
        Iterator it = appointments.iterator();
        while (it.hasNext()) {
            Appointment appointment = (Appointment)it.next();
            if (appointment.getDoctor().getUniqueId().contentEquals(appRemove.getDoctor().getUniqueId()) && appointment.getDate().equals(appRemove.getDate())) {
                appointments.remove(appointment);
                saveChanges();
                return;
            }

        }

    }

    @Override
    public void saveChanges() {
        new Serialiser("data/appointments.paa").serialise(appointments);
    }

    @Override
    public void loadData() {
        appointments = (ArrayList<Appointment>) new Serialiser("data/appointments.paa").deserialise();
    }

    @Override
    public ArrayList getData() {
        return appointments;
    }

    /**
     * alternate accessor. retrieves only appointments from a given doctor
     *
     * @param doctorId - the doctor to search for
     * @return - the list of appointments associated with this doctor
     */
    public ArrayList<Appointment> getAppointments(String doctorId) {

        ArrayList<Appointment> listReturn = new ArrayList<>();

        for (Appointment a : appointments) {
            if (!a.getDoctor().getUniqueId().contentEquals(doctorId)) {
            } else {
                listReturn.add(a);
            }
        }

        return listReturn;
    }

    /**
     * retrieves an appointment for a given doctor on a given date
     *
     * @param doctorId - the doctor to search for
     * @param date - the date to search for
     * @return - the appointment, if found
     */
    public Appointment getAppointment(String doctorId, LocalDate date) {
        for (Appointment a : getAppointments(doctorId)) {
            if (a.getDate().equals(date)) {
                return a;
            }
        }
        return null;
    }

    /**
     * returns a boolean on whether a doctor has an appointment on a given date
     *
     * @param docId - the doctor to search for
     * @param date - the date to search for
     * @return - a boolean confirmation
     */
    public boolean isActiveBooking(String docId, LocalDate date) {
        for (Appointment a : getAppointments(docId)) {
            if (a.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

}
