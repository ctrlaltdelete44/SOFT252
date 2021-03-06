/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import accounts.Patient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.ViewPrescription;

/**
 *
 * @author Anthony
 */
public class PrescriptionController implements IController {

    private final ViewPrescription gui;
    private final Patient patient;

    public PrescriptionController(Account patient) {
        this.gui = new ViewPrescription();
        this.patient = (Patient) patient;

        initialiseEventHandlers();

        cleanUi();
        gui.setVisible(true);
    }

    @Override
    public void initialiseEventHandlers() {
        gui.addBackEventHandler(new btnBackListener());
    }

    @Override
    public void cleanUi() {
        gui.getTxtPatient().setText(patient.viewPatient());
        gui.getTxtDoctor().setText(patient.viewDoctor());
        gui.getTxtNotes().setText(patient.viewNotes());
        gui.getTxtDosage().setText(patient.viewMedicine());
    }

    private class btnBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
        }

    }
}
