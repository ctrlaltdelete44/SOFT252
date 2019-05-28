/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

import accounts.Account;
import java.io.Serializable;
import medicinecabinet.StockItem;
import utilities.serialised.StockSingleton;

/**
 *
 * @author davie
 */
public class StockRequest extends Request implements Serializable {

    private String requestedMedicine;

    /**
     * all requests start with basic information assigned
     *
     * @param a - the account making the request
     * @param rt - the type of request
     */
    public StockRequest(Account a, RequestType rt) {
        super(a, rt);
    }

    /**
     * after creation, a medicine is associated with the request. this is when
     * the request is considered complete, and when it is tracked
     *
     * @param strMedicine - the medicine requested
     */
    public void assignMedicine(String strMedicine) {
        requestedMedicine = strMedicine;
        track();
    }

    /**
     * returns request type for identification purposes
     *
     * @return - returns STOCK
     */
    @Override
    public RequestType getRequestType() {
        return RequestType.STOCK;
    }

    /**
     * STOCK template for viewing request
     *
     * @return - returns a summary of the request
     */
    @Override
    public String toString() {
        return account.getFirstName() + " " + account.getSurname() + " (" + account.getUniqueId() + "): " + RequestType.STOCK + ": " + requestedMedicine;
    }

    /**
     * in processing, just adds 20 of the requested stock to the medicine
     * cabinet
     *
     * @return - returns a confirmation message
     */
    @Override
    public String process() {
        StockItem item = new StockItem(requestedMedicine, 20);
        StockSingleton.getOrCreate().addObject(item);

        return "Added 20 " + requestedMedicine + " to stock";
    }

}
