/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.accountfactory;

import utilities.accounts.AccountType;
import accounts.*;
import java.io.Serializable;

/**
 * concrete implementation of abstract factory
 *
 * @author Anthony
 */
public class ConcreteAccountFactory extends AbstractAccountFactory implements Serializable {

    /**
     * the concrete factory used by the admin to create accounts
     *
     * @param first - first name
     * @param last - surname
     * @param address - address
     * @param password - password
     * @param accType - account type to create
     * @return - returns the generated id so the admin can inform the new user
     */
    @Override
    public String createAccount(String first, String last, String address, String password, AccountType accType) {
        switch (accType) {
            case SECRETARY:
                account = new Secretary(first, last, address);
                account.authorise(accType, password);
                break;
            case DOCTOR:
                account = new Doctor(first, last, address);
                account.authorise(accType, password);
                break;
            case ADMIN:
                account = new Admin(first, last, address);
                account.authorise(accType, password);
                break;
        }

        return account.getUniqueId();
    }
}
