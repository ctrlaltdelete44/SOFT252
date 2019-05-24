/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.results;

import java.io.Serializable;

/**
 * a storage place for the notes from the appointment
 * @author davie
 */
public class Notes implements Serializable{
    private final String notes;

    /**
     * @param notes - the notes made by the doctor during consultation
     */
    public Notes(String notes) {
        this.notes = notes;
    }

    /**
     * standard accessor
     * @return - returns the contents
     */
    public String getNotes() {
        return notes;
    }
    
    
}
