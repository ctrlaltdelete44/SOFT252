/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.resultsfactories;

import accounts.Doctor;
import accounts.Patient;
import appointments.results.Action;
import appointments.results.FurtherAppointment;
import utilities.accounts.HistoryItem;

/**
 * the concrete implementation used when only a further appointment is needed
 *
 * @author davie
 */
public class JustAppointmentFactory extends AbstractResultsFactory {

    private FurtherAppointment appointment;

    /**
     * the notes made during consultation
     *
     * @param strNotes - notes made by doctor during consultation
     */
    public JustAppointmentFactory(String strNotes) {
        super(strNotes);
    }

    /**
     * creates a new history item and associates it with the patient
     *
     * @param p - patient to add to
     * @param d - the doctor who hosted the appointment
     */
    @Override
    public void addHistory(Patient p, Doctor d) {
        HistoryItem h = new HistoryItem(this.notes, null, d, true);
        p.addHistoryItem(h);
        p.addNotification("Your appointment was processed with a further appointment scheduled");
    }

    /**
     * method for adding an action. contains additional validation to ensure
     * that only appointments are added to this
     *
     * @param a - action to add
     */
    @Override
    public void addAction(Action a) {
        switch (a.getActionType()) {
            case APPOINTMENT:
                //System.out.println("Adding appointment:JUSTAPPOINTMENT");
                appointment = (FurtherAppointment) a;
                appointment.processRequest();
                break;
        }
    }
}
