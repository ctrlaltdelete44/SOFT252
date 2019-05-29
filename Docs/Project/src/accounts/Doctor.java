/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import utilities.availability.IViewAvailability;
import utilities.availability.Availability;
import utilities.availability.AvailableDate;
import appointments.Appointment;
import appointments.resultsfactories.AbstractResultsFactory;
import appointments.resultsfactories.ResultsFactory;
//import appointments.resultsfactories.zAbstractResultsFactory;
//import appointments.resultsfactories.zJustAppointmentFactory;
//import appointments.resultsfactories.zJustPrescriptionFactory;
//import appointments.resultsfactories.zNoActionFactory;
//import appointments.resultsfactories.zPrescriptionAndAppointmentFactory;
import utilities.accounts.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import requests.RequestType;
import requests.StockRequest;
import requests.requestfactory.AbstractRequestFactory;
import requests.requestfactory.ConcreteRequestFactory;
import utilities.AccountAdapter;
import utilities.ListToArrayAdapter;
import utilities.serialised.AppointmentSingleton;

/**
 * doctor specific functionalities and information
 *
 * @author aedavies1
 */
public class Doctor extends Account implements Serializable, IViewAvailability {

    private double rating;
    private final ArrayList<Object> feedback = new ArrayList<>();

    private final Availability availability = new Availability();
    private final AppointmentSingleton appointments = AppointmentSingleton.getOrCreate();

//    private zAbstractResultsFactory resultsFactory;
    /**
     * on creation, account is assigned basic information
     *
     * @param first - first name
     * @param last - surname
     * @param address - address
     */
    public Doctor(String first, String last, String address) {
        super(first, last, address);
        availability.scheduleWeek();
    }

    /**
     * returns account type
     *
     * @return - returns DOCTOR
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.DOCTOR;
    }

    /**
     * doctor can receive newFeedback from a patient. this method processes it
     * by adding it to the list of newFeedback with the doctor and calculating a
     * new mean for their rating
     *
     * @param newFeedback - the newFeedback from patients, with an associated
     * message and rating
     * @return returns rating for testing purposes
     */
    public double provideFeedback(Feedback newFeedback) {
        feedback.add(newFeedback);

        int total = 0;
        for (Object o : feedback) {
            Feedback f = (Feedback) o;
            total += f.getRating();
        }

        this.rating = (double) total / this.feedback.size();

        accounts.saveChanges();

        return this.rating;
    }

    /**
     * returns feedback contents as an array for an admin to view
     *
     * @return - the array of feedback
     */
    public String[] viewFeedback() {
        String[] listContents = ListToArrayAdapter.convert((ArrayList<Object>) feedback);//new String[feedback.size()];
        return listContents;
    }

    public double getRating() {
        return rating;
    }

    /**
     * if the date selected is available to the doctor, links it to the given
     * appointment
     *
     * @param a - the appointment to book
     * @param d - the date to book it to
     */
    public void bookDate(Appointment a, LocalDate d) {
        for (int i = 0; i < availability.getNumberOfAvailableDays(); i++) {
            AvailableDate ad = availability.getAvailability().get(i);
            if (ad.getDate().equals(d) && ad.getAppointment() == null) {
                ad.setAppointment(a);

                this.addNotification("You have a new booking on " + ad.getDate());
            }

        }
        System.out.println("Doctor booked date");
    }

    /**
     * method for viewing both free dates and booked dates for this doctor. has
     * to be seperate from both other methods as this returns them in order of
     * date
     *
     * @return - a list of the date schedule
     */
    @Override
    public String[] viewEntireSchedule() {
        ArrayList<AvailableDate> availableDates = availability.getAvailability();
        String[] listContents = new String[availableDates.size()];

        for (int i = 0; i < availableDates.size(); i++) {
            AvailableDate ad = availableDates.get(i);
            LocalDate ld = ad.getDate();

            listContents[i] = ld.getDayOfWeek() + " " + ld + ": ";

            Appointment a = getAppointment(ld);

            if (a != null) {
                listContents[i] += a.getPatient().getFirstName() + " " + a.getPatient().getSurname() + ", " + a.getPatient().getUniqueId();
            } else {
                listContents[i] += "No booking";
            }
        }

        return listContents;
    }

    private Appointment getAppointment(LocalDate date) {
        ArrayList<Appointment> ownAppointments = appointments.getAppointments(uniqueId);
        for (Appointment a : ownAppointments) {
            if (a.getDate().equals(date)) {
                return a;
            }
        }

        return null;
    }

    /**
     * method for viewing only free dates for the doctor. used by patients and
     * secretaries in booking dates as well
     *
     * @return - the array of free date information
     */
    @Override
    public String[] viewFreeDates() {
        ArrayList<Object> listContents = new ArrayList<>();

        for (int i = 0; i < availability.getNumberOfAvailableDays(); i++) {
            AvailableDate ad = availability.getAvailability().get(i);
            LocalDate ld = ad.getDate();

            if (!appointments.isActiveBooking(uniqueId, ld)) {
                listContents.add(ld.getDayOfWeek() + " " + ld);
            }
        }

        String[] array = ListToArrayAdapter.convert(listContents);

        return array;
    }

    /**
     * method for viewing only booked dates. used by the doctor
     *
     * @return - array of booked dates
     */
    @Override
    public String[] viewBookings() {
        ArrayList<Appointment> ownAppointments = appointments.getAppointments(uniqueId);
        String[] listContents = new String[ownAppointments.size()];

        for (int i = 0; i < ownAppointments.size(); i++) {
            Appointment a = ownAppointments.get(i);
            LocalDate ld = a.getDate();

            Patient patient = (Patient) AccountAdapter.convert(a.getPatient().getUniqueId());
            listContents[i] = (ld.getDayOfWeek() + " " + ld + ": " + patient.toString());
        }

        return listContents;
    }

    /**
     * beginning of methods involved with processing the outcomes of an
     * appointment if a prescription is assigned AND a further appointment
     * needed, this method called
     *
     * @param notes - doctors notes during consultation
     * @param prescriptionName - type of medicine prescribed
     * @param dosage - dosage guidelines from doctor
     * @param prescriptionQuantity - amount of medicine prescribed
     * @param timeQuantity - number of days/months/years in the future that the
     * next appointmnt is booked for
     * @param timeFrame - days/weeks/months
     * @param p - the patient the consultation was with
     */
//    public void bothActionsRequired(String notes, String prescriptionName, String dosage, Integer prescriptionQuantity, Integer timeQuantity, String timeFrame, Patient p) {
////        Prescription prescription = new Prescription(prescriptionName, prescriptionQuantity, dosage, notes, p, this);
////
////        LocalDate appointmentDate = getDate(timeQuantity, timeFrame);
////
////        resultsFactory = (zPrescriptionAndAppointmentFactory) new zPrescriptionAndAppointmentFactory(notes);
////
////        resultsFactory.addAction(new AssignedPrescription(prescription, p));
////        resultsFactory.addAction(new FurtherAppointment(appointmentDate, p, this));
////
////        resultsFactory.addHistory(p, this);
//    }
    public void processAppointment(HashMap<String, Boolean> map, String notes, Patient p, LocalDate date, String prescriptionName, String dosage, int prescriptionQuantity) {
        AbstractResultsFactory factory = new ResultsFactory(map, notes, p, this, date, prescriptionName, dosage, prescriptionQuantity);
        factory.addHistory(p, this);
    }

    /**
     * if just a prescription is required, this method called
     *
     * @param notes - doctors notes during consultation
     * @param name - medicine type prescribed
     * @param quantity - quantity of medicine prescribed
     * @param dosage - dosage guidelines
     * @param p - patient the consultation was with
     */
//    public void justPrescriptionRequired(String notes, String name, Integer quantity, String dosage, Patient p) {
////        Prescription prescription = new Prescription(name, quantity, dosage, notes, p, this);
////
////        resultsFactory = (zJustPrescriptionFactory) new zJustPrescriptionFactory(notes);
////
////        resultsFactory.addAction(new AssignedPrescription(prescription, p));
////
////        resultsFactory.addHistory(p, this);
//    }
    /**
     * if just a further appointment required, this method called
     *
     * @param notes - doctors notes during consultation
     * @param timeQuantity - how far into the future the appointment is needed
     * @param timeFrame - units for above
     * @param p - patient consultation was with
     */
//    public void justAppointmentRequired(String notes, Integer timeQuantity, String timeFrame, Patient p) {
////        LocalDate appointmentDate = getDate(timeQuantity, timeFrame);
////
////        resultsFactory = (zJustAppointmentFactory) new zJustAppointmentFactory(notes);
////        resultsFactory.addAction(new FurtherAppointment(appointmentDate, p, this));
////
////        resultsFactory.addHistory(p, this);
//    }
    /**
     * if no further action is required following a consultation, this method
     * called
     *
     * @param notes - the notes made during consultation
     * @param p - the patient consultation was with
     */
//    public void noActionRequired(String notes, Patient p) {
////        resultsFactory = (zNoActionFactory) new zNoActionFactory(notes);
////
////        resultsFactory.addHistory(p, this);
//    }
//    private LocalDate getDate(Integer timeQuantity, String timeFrame) {
//        LocalDate current = LocalDate.now();
//        LocalDate appointmentDate;
//        switch (timeFrame) {
//            case "DAYS":
//                appointmentDate = current.plusDays(timeQuantity);
//                break;
//            case "MONTHS":
//                appointmentDate = current.plusMonths(timeQuantity);
//                break;
//            case "YEARS":
//                appointmentDate = current.plusYears(timeQuantity);
//                break;
//            default:
//                appointmentDate = current;
//                break;
//        }
//        return appointmentDate;
//    }
    /**
     * method for clearing a date from a doctor. this is used after an
     * appointment is completed, and it clears any appontments as well as
     * clearing the date from the doctors availability
     *
     * @param date - the date to removeObject
     */
    public void clearDate(LocalDate date) {
        removeAppointment(date);
        availability.removeDate(date);
    }

    /**
     * this is used on deletion of a patient account with active appointments
     * just clears any appointment from the given date
     *
     * @param date - the date to clear
     */
    public void removeAppointment(LocalDate date) {
        appointments.removeObject(appointments.getAppointment(uniqueId, date));
    }

    /**
     * doctors are in control of their schedule - this creates a new week of
     * availability, starting from either today or their last scheduled day
     */
    public void scheduleWeek() {
        availability.scheduleWeek();
    }

    /**
     * doctor's method for viewing account - includes their rating
     *
     * @return - returns summary of account
     */
    @Override
    public String toString() {
        return firstName + " " + surname + ": " + uniqueId + ", " + rating + "/5";
    }

    /**
     * doctors can request additional stock. this method creates a request and
     * puts it forward to secretary accounts
     *
     * @param requested - the name of the medicine requested
     */
    public void createStockRequest(String requested) {
        AbstractRequestFactory factory = new ConcreteRequestFactory();
        StockRequest request = (StockRequest) factory.createRequest(this, RequestType.STOCK);

        request.assignMedicine(requested);
    }
}
