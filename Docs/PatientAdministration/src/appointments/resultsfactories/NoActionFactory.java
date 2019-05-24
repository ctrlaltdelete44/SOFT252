/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.resultsfactories;

import accounts.Doctor;
import accounts.Patient;
import appointments.results.Action;
import utilities.accounts.HistoryItem;

/**
 * concrete implementation for when no appointment or prescription needed
 * @author davie
 */
public class NoActionFactory extends AbstractResultsFactory{

    /**
     * regardless of further actions, notes are still required
     * @param strNotes - notes made by doctor during consultation
     */
    public NoActionFactory(String strNotes) {
        super(strNotes);
    }
    
    /**
     * this is not used, as no actions needed
     * @param a - unused
     */
    @Override
    public void addAction(Action a)
    {
    }
    
    /**
     * a record of this is still added to the patient history to keep track of
     * the doctors notes
     * @param p - the patient to add the history to
     * @param d - doctor who hosted consultation
     */
    @Override
    public void addHistory(Patient p, Doctor d)
    {
        HistoryItem h = new HistoryItem(this.notes, null, d, false);
        p.addHistoryItem(h);
        p.addNotification("Your appointment has been processed with no further action needed");
    }
}
