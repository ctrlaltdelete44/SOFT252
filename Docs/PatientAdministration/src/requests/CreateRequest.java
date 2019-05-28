/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package requests;

import accounts.Account;
import java.io.Serializable;
import utilities.accounts.AccountType;

/**
 * requests for account creation
 *
 * @author Anthony
 */
public class CreateRequest extends Request implements Serializable {

    /**
     * all requests start with basic information assigned
     *
     * @param a - the account making the request
     * @param rt - the type of request
     */
    public CreateRequest(Account a, RequestType rt) {
        super(a, rt);
    }

    /**
     * on processing, simply authorises the new account
     *
     * @return - returns a confirmation message for secretary
     */
    @Override
    public String process() {
        account.authorise(AccountType.PATIENT, "");
        return "This patients ID is " + account.getUniqueId() + ".";
    }

    /**
     * create's template for viewing request
     *
     * @return - returns a summary of request
     */
    @Override
    public String toString() {
        return account.getFirstName() + " " + account.getSurname() + ": " + RequestType.CREATE;
    }

    /**
     * identification method for viewing request type
     *
     * @return - returns CREATE
     */
    @Override
    public RequestType getRequestType() {
        return RequestType.CREATE;
    }
}
