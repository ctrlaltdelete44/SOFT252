///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package appointments.results;
//
//import accounts.Doctor;
//import accounts.Patient;
//import java.io.Serializable;
//import java.time.LocalDate;
//
///**
// * used when an additional appointment is scheduled following an appointment
// *
// * @author davie
// */
//public class FurtherAppointment extends Action implements Serializable {
//
//    private final LocalDate date;
//    private final Patient p;
//    private final Doctor d;
//
//    /**
//     * the date of the future appointment : the doctor and patient are assumed
//     * to be the same as current appointment
//     *
//     * @param date - date of appointment
//     * @param p - patient making request
//     * @param d - doctor being requested
//     */
//    public FurtherAppointment(LocalDate date, Patient p, Doctor d) {
//        this.date = date;
//        this.p = p;
//        this.d = d;
//    }
//
//    /**
//     * standard accessor
//     *
//     * @return returns date associated with this request
//     */
//    public LocalDate getDate() {
//        return date;
//    }
//
//    /**
//     * creates a request for a new appointment
//     */
//    @Override
//    public void processRequest() {
//        p.createAppointmentRequest(d.getUniqueId(), date);
//    }
//
//    /**
//     * returns appointment enum
//     *
//     * @return - returns APPOINTMENT
//     */
//    @Override
//    public ActionType getActionType() {
//        return ActionType.APPOINTMENT;
//    }
//}
