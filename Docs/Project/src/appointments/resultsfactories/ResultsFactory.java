/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appointments.resultsfactories;

import accounts.Doctor;
import accounts.Patient;
import appointments.Prescription;
import java.time.LocalDate;
import java.util.HashMap;
import utilities.accounts.HistoryItem;

/**
 *
 * @author Anthony
 */
public class ResultsFactory extends AbstractResultsFactory {

    public ResultsFactory(HashMap<String, Boolean> actions, String notes, Patient patient, Doctor doctor, LocalDate appointmentDate, String prescriptionName, String prescriptionDosage, Integer prescriptionQuantity) {
        super(actions, notes, patient, doctor, appointmentDate, prescriptionName, prescriptionDosage, prescriptionQuantity);
    }

    @Override
    public void createActions() {
        if (actions.get("Appointment")) {
            patient.createAppointmentRequest(doctor.getUniqueId(), appointmentDate);
        }
        if (actions.get("Prescription")) {
            prescription = new Prescription(prescriptionName, prescriptionQuantity, prescriptionDosage, notes, patient, doctor);
            patient.createPrescriptionRequest(prescription);
        }
    }

    @Override
    public void addHistory(Patient patient, Doctor doctor) {
        HistoryItem h;
        if (isPrescription) {
            h = new HistoryItem(notes, prescription, doctor, isAppointment);
        }
        else {
            h = new HistoryItem(notes, null, doctor, isAppointment);
        }
      
        patient.addHistoryItem(h);
        patient.addNotification("Your appointment has been processed");
    }

    

}
