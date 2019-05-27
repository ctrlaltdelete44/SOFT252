/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import appointments.Appointment;
import utilities.serialised.AppointmentSingleton;

/**
 * a class to retrieve an appointment given a doctor and a summary of
 * appointment information
 *
 * @author davie
 */
public class AppointmentAdapter implements IConvert {

    private final String strAppointment;
    private final String doctorId;

    /**
     * on creation, needs both the doctors id and the summary of information
     *
     * @param strAppointment - a collection of information abt the appointment
     * @param doctorId - the doctor's unique id
     */
    public AppointmentAdapter(String strAppointment, String doctorId) {
        this.strAppointment = strAppointment;
        this.doctorId = doctorId;
    }

    /**
     * searches through a list of that doctors appointments, with validation to
     * ensure that the patient and date are both accurate before returning a
     * reference to the appointment
     *
     * @return - returns a reference to the appointment found or null if not
     */
    @Override
    public Appointment convert() {
        AppointmentSingleton appointments = AppointmentSingleton.getOrCreate();
        for (Appointment a : appointments.getAppointments(doctorId)) {
            if (strAppointment.contains(a.getPatient().getUniqueId()) && strAppointment.contains(a.getDate().toString())) {
                return a;
            }
        }
        return null;
    }
}
