/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.resultsfactories;

import accounts.Doctor;
import accounts.Patient;
import appointments.results.AssignedPrescription;
import appointments.results.FurtherAppointment;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author Anthony
 */
public abstract class AbstractResultsFactory implements Serializable {

    protected final HashMap<String, Object> actions;
    
    protected String notes = null;
    protected FurtherAppointment appointment = null;
    protected AssignedPrescription prescription = null;

    public AbstractResultsFactory(HashMap<String, Object> actions) {
        this.actions = actions;
        createActions();
    }
    
    public abstract void createActions(); 
    
    public abstract void addHistory(Patient patient, Doctor doctor);
}
