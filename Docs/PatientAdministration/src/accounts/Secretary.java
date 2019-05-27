/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import utilities.accounts.AccountType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import medicinecabinet.StockItem;
import requests.AppointmentRequest;
import requests.Request;
import utilities.serialised.AccountSingleton;
import utilities.serialised.RequestSingleton;
import utilities.serialised.StockSingleton;
import utilities.AccountAdapter;
import utilities.DateAdapter;
import utilities.RequestAdapter;
import utilities.accounts.IViewAccounts;

/**
 * secretary specific functionalities and information
 *
 * @author Anthony
 */
public class Secretary extends Account implements Serializable, IViewAccounts {

    /**
     * on creation, account is assigned basic information
     *
     * @param first - first name
     * @param last - surname
     * @param address - address
     */
    public Secretary(String first, String last, String address) {
        super(first, last, address);
    }

    /**
     * returns account type as enum for identification
     *
     * @return - returns SECRETARY
     */
    @Override
    public AccountType getAccountType() {
        return AccountType.SECRETARY;
    }

    /**
     * secretary can view doctor and patient accounts at different times, so
     * this method allows for the different requirements
     *
     * @param accountType - the account type to view at this time
     * @return - returns the list of accounts as an array of strings
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
     * secretary can only removeObject patient accounts, so will always cleanly delete
 them
     *
     * @param strAccount - the account information of that to be deleted
     */
    public void removeAccount(String strAccount) {
        AccountAdapter adapter = new AccountAdapter(strAccount);
        Patient account = (Patient) adapter.convert();

        account.cleanDelete();

        AccountSingleton.getOrCreate().removeObject(account);
    }

    //METHODS TO HANDLE REQUESTS
    /**
     * views all floating requests
     *
     * @return - returns as an array of strings for viewing
     */
    public String[] viewRequests() {
        ArrayList<Request> list = RequestSingleton.getOrCreate().getData();

        String[] listData = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            Request r = list.get(i);
            listData[i] = r.viewRequest();
        }
        return listData;
    }

    /**
     * deleting a given request - for example if a patient tries to make
     * multiple appointments, secretary has the option to clear spam ones
     *
     * @param strRequest - the request information of that to delete
     */
    public void deleteRequest(String strRequest) {
        RequestAdapter adapter = new RequestAdapter(strRequest);
        Request r = adapter.convert();

        RequestSingleton.getOrCreate().removeObject(r);
    }

    /**
     * an alternative to the above for when the request reference is already
     * known
     *
     * @param r - the request to be deleted
     */
    public void deleteRequest(Request r) {
        RequestSingleton.getOrCreate().removeObject(r);
    }

    /**
     * each request type is authorised differently and this is handled by the
     * request. this method: - unregisters the request if associated with a
     * patient - processes the request - notifies the request creator that the
     * request was confirmed - returns an output message for the secretary
     *
     * @param strRequest - the request being processed
     * @return - the output message for the secretary
     */
    public String authoriseRequest(String strRequest) {
        RequestAdapter adapter = new RequestAdapter(strRequest);
        Request r = adapter.convert();

        if (r.getAccount().getAccountType() == AccountType.PATIENT) {
            Patient p = (Patient) r.getAccount();
            p.unregisterObserver(r);
        }

        switch (r.getRequestType()) {
            case CREATE:
            case DELETE:
            case STOCK:
                r.getAccount().addNotification("Your " + r.getRequestType() + " request has been authorised");
                deleteRequest(r);
                return r.process();
            case PRESCRIPTION:
                String strReturn = r.process();
                if (!strReturn.contains("not in stock")) {
                    r.getAccount().addNotification("Your " + r.getRequestType() + " request has been authorised");
                    deleteRequest(r);
                }
                return strReturn;
            default:
                return null;
        }

    }

    /**
     * appointment requests are authorised in a different way and have more
     * information associated with them
     *
     * @param request - the request information that is being authorised
     * @param assignedDoctor - the doctor chosen by the secretary
     * @param assignedDate - the date chosen by the secretary
     * @return - returns an information message for the secretary
     */
    public String authoriseRequest(String request, String assignedDoctor, String assignedDate) {
        //get references from inputted data
        RequestAdapter rAdapter = new RequestAdapter(request);
        AccountAdapter doctorAdapter = new AccountAdapter(assignedDoctor);
        DateAdapter dAdapter = new DateAdapter(assignedDate);

        AppointmentRequest ar = (AppointmentRequest) rAdapter.convert();
        Doctor d = (Doctor) doctorAdapter.convert();
        LocalDate date = dAdapter.convert();

        ar.setDate(date);
        ar.setDoctor(d);

        //delete request
        String strReturn = ar.process();
        if (!strReturn.contains("already has an active appointment")) {
            deleteRequest(ar);
            ar.getAccount().addNotification("You have a new appointment on " + date + " with " + d.getFirstName() + " " + d.getSurname());
        }
        return strReturn;
    }

    //METHODS TO HANDLE STOCK
    /**
     * returns the stock as an array of strings for viewing
     *
     * @return - an array of strings to use with a jlist
     */
    public String[] viewStock() {
        ArrayList<StockItem> list = StockSingleton.getOrCreate().getData();

        String[] listData = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            listData[i] = list.get(i).viewItem();
        }

        return listData;
    }

    /**
     * a secretary can replenish stock where necessary
     *
     * @param name - the item of stock to addObject
     * @param quantity - the quantity
     */
    public void addToStock(String name, int quantity) {
        StockItem item = new StockItem(name, quantity);
        StockSingleton.getOrCreate().addObject(item);
    }

    /**
     * when a patient comes to collect a prescription, this method called
     *
     * @param name - the name of the prescription
     * @param quantity - the quantity needed
     * @return - returns the stock item to symbolise it being given to the
     * patient
     */
    public StockItem requestStock(String name, int quantity) {
        return StockSingleton.getOrCreate().requestStock(name, quantity);
    }

    /**
     * secretaries method for viewing account info
     *
     * @return - returns summary of account info
     */
    @Override
    public String viewAccount() {
        return firstName + " " + surname + ": " + uniqueId;
    }
}
