/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.accounts;

/**
 * an interface for viewing accounts. used by all accounts bar doctors, so
 * must be separate from the account superclass
 * @author davie
 */
public interface IViewAccounts {

    /**
     * the method to view accounts of a given type
     * @param accountType - the account type to search for
     * @return - returns a report on accounts in a string array for use by a Jlist
     */
    public String[] viewAccounts(AccountType accountType);
}
