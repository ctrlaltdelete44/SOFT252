/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

import accounts.Account;
import accounts.Patient;
import java.io.Serializable;
import utilities.AccountAdapter;
import utilities.serialised.AccountSingleton;

/**
 *
 * @author davie
 */
public class DeleteRequest extends Request implements Serializable {

    /**
     * all requests start with basic information assigned
     *
     * @param a - the account making the request
     * @param rt - the type of request
     */
    public DeleteRequest(Account a, RequestType rt) {
        super(a, rt);
    }

    /**
     * gets request type for identification purposes
     *
     * @return - returns DELETE
     */
    @Override
    public RequestType getRequestType() {
        return RequestType.DELETE;
    }

    /**
     * in processing, will removeObject the patient from the account tracker and
 cleanly delete the patient (clearing any appointments and floating
 requests)
     *
     * @return - returns an authorisation message
     */
    @Override
    public String process() {
        Patient p = (Patient) AccountAdapter.convert(account.getUniqueId());

        p.cleanDelete();
        AccountSingleton.getOrCreate().removeObject(p);
        return "Account of " + account.getFirstName() + " " + account.getSurname() + " deleted";
    }

    /**
     * delete template for viewing request
     *
     * @return - returns summary of request
     */
    @Override
    public String viewRequest() {
        return account.getFirstName() + " " + account.getSurname() + ": " + RequestType.DELETE;
    }
}
