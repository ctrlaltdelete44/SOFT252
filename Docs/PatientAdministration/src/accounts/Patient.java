/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import utilities.accounts.AccountType;
import utilities.accounts.Feedback;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import requests.AppointmentRequest;
import requests.RequestType;
import requests.requestfactory.AbstractRequestFactory;
import requests.requestfactory.ConcreteRequestFactory;
import utilities.serialised.AccountSingleton;
import utilities.serialised.IdGenerator;
import utilities.AccountAdapter;
import appointments.Appointment;
import appointments.Prescription;
import requests.PrescriptionRequest;
import requests.Request;
import utilities.Observing.IObservable;
import utilities.accounts.HistoryItem;
import utilities.accounts.IViewAccounts;
import utilities.accounts.IViewPrescription;

/**
 * patient specific information and functionalities
 *
 * @author Anthony
 */
public class Patient extends Account implements Serializable, IViewAccounts, IViewPrescription, IObservable {

    private String sex;
    private int age;

    private final AbstractRequestFactory requestFactory = new ConcreteRequestFactory();

    private Appointment appointment;
    private Prescription prescription;

    private final ArrayList<HistoryItem> patientHistory;
    private final ArrayList<Request> myRequests;

    //on creation, take information on all of these. assign patient info immediately, as this will call create request
    /**
     * on creation, account is assigned basic information
     *
     * @param first - first name
     * @param last - surname
     * @param address - address
     */
    public Patient(String first, String last, String address) {
        super(first, last, address);

        patientHistory = new ArrayList<>();
        myRequests = new ArrayList<>();
        appointment = null;
        prescription = null;
        sex = "N/A";
        age = 18;
    }

    /**
     * patient accounts have additional information associated with them.
     * therefore a request is not processed until all of this information is
     * assigned
     *
     * @param sex - sex of patient
     * @param age - age of patient
     * @param arrPassword - password as an array of characters, as it is given
     * by password box
     */
    public void assignPatientInfo(String sex, int age, char[] arrPassword) {
        String strPassword = String.valueOf(arrPassword);

        this.sex = sex;
        this.age = age;
        this.password = strPassword;

        requestFactory.createRequest(this, RequestType.CREATE);
    }

    /**
     * patients can request deletion of account. this creates that request
     */
    public void createDeleteRequest() {
        Request request = requestFactory.createRequest(this, RequestType.DELETE);
        registerObserver(request);
    }

    /**
     * patients can request an appointment with a selected doctor on a selected
     * date it is down to secretary to assign appointments where appropriate
     * given patient requests
     *
     * @param strDoctor - the account information of the doctor requested
     * @param date - the date requested
     */
    public void createAppointmentRequest(String strDoctor, LocalDate date) {
        AccountAdapter acctAdapter = new AccountAdapter(strDoctor);
        Doctor doctor = (Doctor) acctAdapter.convert();

        AppointmentRequest request = (AppointmentRequest) requestFactory.createRequest(this, RequestType.APPOINTMENT);
        request.assignRequestedTarget(doctor, date);

        registerObserver(request);
    }

    /**
     * method for requesting a prescription
     *
     * @param p - class with all information required for prescription
     */
    public void createPrescriptionRequest(Prescription p) {
        PrescriptionRequest request = (PrescriptionRequest) requestFactory.createRequest(this, RequestType.PRESCRIPTION);
        request.assignPrescription(p);

        registerObserver(request);
    }

    /**
     * patients can submit feedback for a doctor
     *
     * @param rating - the rating out of 5 given to doctor
     * @param comments - the patients comments
     * @param strDoctor - the account information of the doctor
     */
    public void provideFeedback(int rating, String comments, String strDoctor) {
        Feedback feedback = new Feedback(rating, comments);

        AccountAdapter adapter = new AccountAdapter(strDoctor);
        Doctor doctor = (Doctor) adapter.convert();

        doctor.provideFeedback(feedback);
    }

    /**
     * patients can view doctor accounts in order to book an appointment
     *
     * @param accountType - the account type to be viewed. for patients, this
     * will only be doctors
     * @return - returns the doctor accounts as an array of strings to be
     * displayed
     */
    @Override
    public String[] viewAccounts(AccountType accountType) {
        ArrayList<Account> list = AccountSingleton.getOrCreate().getData();
        ArrayList<String> accountList = new ArrayList<>();

        for (Account a : list) {
            if (a.getAccountType() == accountType) {
                accountList.add(a.viewAccount());
            }
        }

        String[] listData = new String[accountList.size()];
        for (int i = 0; i < accountList.size(); i++) {
            listData[i] = accountList.get(i);
        }
        return listData;
    }

    /**
     * behaves differently to other accounts, as patients already have password
     * associated. therefore does not use the super method handler
     *
     * @param accountType - for use in generating the new id
     * @param password - discarded
     */
    @Override
    public void authorise(AccountType accountType, String password) {
        //assign login credentials
        uniqueId = IdGenerator.generateNextId(accountType);

        //track account
        accounts.addObject(this);
    }

    /**
     * used for identifying the account type
     *
     * @return - returns PATIENT
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.PATIENT;
    }

    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }

    public Appointment getAppointment() {
        return appointment;
    }

    public Prescription getPrescription() {
        return prescription;
    }

    /**
     * assigns a prescription and notifies patient of this
     *
     * @param prescription - the prescription to assign
     */
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
        this.addNotification("You have been issued a prescription of " + prescription.getMedicine() + ". Please visit a secretary to collect this");
    }

    /**
     * once appointment is taken, clears it from patient
     */
    public void clearAppointment() {
        this.appointment = null;
    }

    /**
     * patients have an associated list of historical appointments
     *
     * @param h - the history item to addObject
     */
    public void addHistoryItem(HistoryItem h) {
        patientHistory.add(0, h);
        accounts.saveChanges();

    }

    /**
     * returns a patients history as an array of strings for viewing in a list
     *
     * @return - the array of historical records
     */
    public String[] viewHistory() {
        String[] listContents = new String[patientHistory.size()];

        for (int i = 0; i < patientHistory.size(); i++) {
            listContents[i] = patientHistory.get(i).printHistoryItem();
        }

        return listContents;
    }

    /**
     * on deletion of a patient account, will wipe any active appointments and
 removeObject any floating requests linked to the patient
     */
    public void cleanDelete() {
        if (appointment != null) {
            appointment.getDoctor().removeAppointment(appointment.getDate());
        }
        cleanDeleteObservers();
    }

    /**
     * this account types method for viewing the account information
     *
     * @return - returns a summary of account
     */
    @Override
    public String viewAccount() {
        return firstName + " " + surname + ": " + uniqueId;
    }

    /**
     * when a patient views a prescription, they see specific information
     *
     * @return : views all information associated with their account
     */
    @Override
    public String viewPatient() {
        String strReturn = "Name: " + firstName + " " + surname + "\n"
                + "Address: " + address + "\n"
                + "Sex: " + sex + "\n"
                + "Age: " + age;

        return strReturn;
    }

    /**
     * when a patient views a prescription, they see specific information
     *
     * @return : views all information about the doctor
     */
    @Override
    public String viewDoctor() {
        Doctor d = prescription.getDoctor();
        String strReturn = "Name: " + d.getFirstName() + " " + d.getSurname() + "\n"
                + "Address: " + d.getAddress();
        return strReturn;
    }

    /**
     * when a patient views a prescription, they see specific information
     *
     * @return : views the notes from the appointment
     */
    @Override
    public String viewNotes() {
        return prescription.getNotes();
    }

    /**
     * when a patient views a prescription, they see specific information
     *
     * @return : views the medicine, quantity, and dosage instructions
     */
    @Override
    public String viewMedicine() {

        String strReturn = "Medicine: " + prescription.getMedicine() + "\n"
                + "Quantity: " + prescription.getQuantity() + "\n"
                + "Dosage: " + prescription.getDosage();
        return strReturn;
    }

    /**
     * patient observed by their associated requests. this registers a new
     * request
     *
     * @param r = request observing
     */
    @Override
    public void registerObserver(Request r) {
        myRequests.add(r);

        accounts.saveChanges();
    }

    /**
     * this unregisters an observer from the patient
     *
     * @param r - request to unregister
     */
    @Override
    public void unregisterObserver(Request r) {
        myRequests.remove(r);

        accounts.saveChanges();
    }

    /**
     * on patient deletion, all observers are told to removeObject themselves from the
 list of requests
     */
    @Override
    public void cleanDeleteObservers() {
        for (Request r : myRequests) {
            r.untrackRequest();
        }
        myRequests.clear();
        accounts.saveChanges();
    }
}
