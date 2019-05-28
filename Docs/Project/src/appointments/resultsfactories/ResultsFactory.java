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
import java.util.HashMap;
import utilities.accounts.HistoryItem;

/**
 *
 * @author Anthony
 */
public class ResultsFactory extends AbstractResultsFactory {

    public ResultsFactory(HashMap<String, Object> actions) {
        super(actions);
        
    }

    @Override
    public void addHistory(Patient patient, Doctor doctor) {
        HistoryItem h;
        if (prescription != null) {
            h = new HistoryItem(notes, prescription.getPrescription(), doctor, appointment == null);
        }
        else {
            h = new HistoryItem(notes, null, doctor, appointment == null);
        }
      
        patient.addHistoryItem(h);
        patient.addNotification("Your appointment has been processed");
    }

    @Override
    public void createActions() {
        notes = (String)actions.get("Notes");
        
        if (actions.containsKey("Appointment")) {
            appointment = (FurtherAppointment)actions.get("Appointment");
            appointment.processRequest();
        }
        
        if (actions.containsKey("Prescription")) {
            prescription = (AssignedPrescription)actions.get("Prescription");
            prescription.processRequest();
        }
    }

}
