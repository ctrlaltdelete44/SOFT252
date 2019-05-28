/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.accounts;

/**
 * when viewing a report on prescriptions, a compilation of different
 * information needed. kept as an interface in preparation for potential future
 * updates allowing a doctor to view a prescription associated with a historical
 * record
 *
 * @author davie
 */
public interface IViewPrescription {

    /**
     *
     * @return - a report on the patient
     */
    public String viewPatient();

    /**
     *
     * @return - a report on the authorising doctor
     */
    public String viewDoctor();

    /**
     *
     * @return - the notes made during consultation
     */
    public String viewNotes();

    /**
     *
     * @return - a report on what prescription was made
     */
    public String viewMedicine();
}
