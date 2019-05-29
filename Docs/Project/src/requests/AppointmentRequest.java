/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

import accounts.Account;
import accounts.Doctor;
import accounts.Patient;
import appointments.Appointment;
import java.io.Serializable;
import java.time.LocalDate;
import utilities.AccountAdapter;

/**
 * concrete request for an appointment
 *
 * @author davie
 */
public class AppointmentRequest extends Request implements Serializable {

    private Doctor doctor = null;
    private LocalDate date = null;

    /**
     * all requests start with basic information assigned
     *
     * @param a - the account making the request
     * @param rt - the type of request
     */
    public AppointmentRequest(Account a, RequestType rt) {
        super(a, rt);
    }

    /**
     * assigns the doctor and date requested by the patient - this is when the
     * request is considered complete, so is when it is tracked
     *
     * @param doctor - requested doctor
     * @param date - requested date
     */
    public void assignRequestedTarget(Doctor doctor, LocalDate date) {
        System.out.println("Assigning new appt argets");
        this.doctor = doctor;
        this.date = date;

        track();
    }

    /**
     * returns request type for identification purposes
     *
     * @return - returns APPOINTMENT
     */
    @Override
    public RequestType getRequestType() {
        return RequestType.APPOINTMENT;
    }

    /**
     * before processing, this is assigned it's actual doctor and date therefore
     * this method simply needs to create a new appointment and link it to the
     * doctor and then the patient via the connect method
     *
     * @return - returns an output message for the secretary
     */
    @Override
    public String process() {
        Patient p = (Patient) AccountAdapter.convert(account.getUniqueId());

        if (p.getAppointment() != null) {
            return "This patient already has an active appointment, please delete any other appointments requests from them";
        }

        //make new appointment, link to all relevant
        Appointment appointment = new Appointment(p, doctor, date);

        //book date through doctor
        doctor.bookDate(appointment, date);

        appointment.connect();

        return appointment.getPatient().getFirstName() + " " + appointment.getPatient().getSurname()
                + " now has an appointment with " + appointment.getDoctor().getFirstName() + " "
                + appointment.getDoctor().getSurname() + " on " + appointment.getDate();
    }

    /**
     * the appointment-specific template for viewing a request
     *
     * @return - returns summary of request
     */
    @Override
    public String toString() {
        return account.getFirstName() + " " + account.getSurname() + ": " + RequestType.APPOINTMENT + " with " + doctor.getFirstName() + " " + doctor.getSurname() + " (" + doctor.getUniqueId() + ") on " + date;
    }

    /**
     * standard accessor
     *
     * @return - doctor linked to request (either requested by patient or
     * assigned by secretary based on the lifecycle of the request)
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * standard accessor
     *
     * @return - date linked to request (either requested by patient or assigned
     * by secretary based on the lifecycle of the request)
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * standard mutator
     *
     * @param doctor - doctor to assign to appointment. used by secretary
     */
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    /**
     * standard mutator
     *
     * @param date - date secretary assigns to request
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }

}
