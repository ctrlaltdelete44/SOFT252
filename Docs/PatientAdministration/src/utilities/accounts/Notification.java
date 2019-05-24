/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.accounts;

import java.io.Serializable;

/**
 * on login, a user is presented with a list of notifications regarding
 * any updates related to their account
 * @author davie
 */
public class Notification implements Serializable {
    private final String contents;
    
    /**
     *
     * @param message - the message to display on login
     */
    public Notification(String message)
    {
        contents = message;
        //System.out.println("New message created:NOTIFICATION");
    }
    
    /**
     * standard accessor
     * @return - returns the contents of this message
     */
    public String getContents()
    {
        return contents;
    }
}
