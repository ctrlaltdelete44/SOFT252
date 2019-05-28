/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Doctor;
import accounts.Patient;
import appointments.Appointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.AppointmentView;

/**
 *
 * @author Anthony
 */
public class AppointmentController implements IController {

    private final AppointmentView gui;
    private final Doctor authorisingDoctor;
    private final Appointment activeAppointment;

    public AppointmentController(Doctor doctor, Appointment appointment) {
        this.gui = new AppointmentView();
        this.authorisingDoctor = doctor;
        this.activeAppointment = appointment;

        initialiseEventHandlers();
        cleanUi();

        gui.setVisible(true);
    }

    @Override
    public void initialiseEventHandlers() {
        gui.addAppointmentChangedEventHandler(new chkAppointmentListener());
        gui.addPrescriptionChangedEventHandler(new chkPrescriptionListener());
        gui.addSubmitEventHandler(new btnSubmitListener());
    }

    @Override
    public void cleanUi() {
        gui.getLblPatient().setText(activeAppointment.getPatient().toString());
        gui.getLblDoctor().setText(authorisingDoctor.toString());
        gui.getLstHistory().setListData(activeAppointment.getPatient().viewHistory());

        gui.getTxtNotes().setText("");
        gui.getChkPrescription().setSelected(false);
        gui.getChkAppointment().setSelected(false);
        gui.getTxtMedicine().setText("");
        gui.getTxtPrescriptionGuide().setText("");
        gui.getSpnQuantity().setValue(1);
        gui.getSpnDate().setValue(1);
        gui.getRdoDays().setSelected(true);

        gui.getLblPrescriptionTitle().setEnabled(false);
        gui.getTxtMedicine().setEnabled(false);
        gui.getSpnQuantity().setEnabled(false);
        gui.getLblDosageTitle().setEnabled(false);
        gui.getTxtPrescriptionGuide().setEnabled(false);

        gui.getLblAppointmentTitle().setEnabled(false);
        gui.getLblNextAppointmentTitle().setEnabled(false);
        gui.getSpnDate().setEnabled(false);
        gui.getRdoDays().setEnabled(false);
        gui.getRdoMonths().setEnabled(false);
        gui.getRdoYears().setEnabled(false);
    }

    public void processAppointment(String notes, String prescriptionName, Integer prescriptionQuantity, String dosage, Integer timeQuantity, String timeFrame) {
        Patient p = activeAppointment.getPatient();

        //notes is not null, others can be
        if (prescriptionName == null && timeQuantity == null) {
            authorisingDoctor.noActionRequired(notes, p);
        } else if (prescriptionName == null && timeQuantity != null) {
            authorisingDoctor.justAppointmentRequired(notes, timeQuantity, timeFrame, p);
        } else if (prescriptionName != null && timeQuantity == null) {
            authorisingDoctor.justPrescriptionRequired(notes, prescriptionName, prescriptionQuantity, dosage, p);
        } else {
            authorisingDoctor.bothActionsRequired(notes, prescriptionName, dosage, prescriptionQuantity, timeQuantity, timeFrame, p);
        }

        activeAppointment.getPatient().clearAppointment();
        authorisingDoctor.clearDate(activeAppointment.getDate());

        JOptionPane.showMessageDialog(null, "Appointment has been processed", "Appointment completed", JOptionPane.OK_OPTION);
        gui.dispose();
    }

    private class chkPrescriptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Boolean isChecked = gui.getChkPrescription().isSelected();

            gui.getLblPrescriptionTitle().setEnabled(isChecked);
            gui.getTxtMedicine().setEnabled(isChecked);
            gui.getSpnQuantity().setEnabled(isChecked);
            gui.getTxtPrescriptionGuide().setEnabled(isChecked);
            gui.getLblDosageTitle().setEnabled(isChecked);

        }

    }

    private class chkAppointmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Boolean isChecked = gui.getChkAppointment().isSelected();

            gui.getLblAppointmentTitle().setEnabled(isChecked);
            gui.getLblNextAppointmentTitle().setEnabled(isChecked);
            gui.getSpnDate().setEnabled(isChecked);
            gui.getRdoDays().setEnabled(isChecked);
            gui.getRdoMonths().setEnabled(isChecked);
            gui.getRdoYears().setEnabled(isChecked);
        }

    }

    private class btnSubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String notes = null;
            String prescriptionName = null;
            Integer prescriptionQuantity = null;
            String dosage = null;
            Integer timeQuantity = null;
            String timeFrame = null;

            Boolean isAppValid = true;
            Boolean isPresValid = true;

            if (gui.getTxtNotes().getText().contentEquals("")) {
                JOptionPane.showMessageDialog(null, "Please provide a write-up of this appointment", "No notes", JOptionPane.OK_OPTION);
            } else {
                notes = gui.getTxtNotes().getText();

                if (gui.getChkPrescription().isSelected()) {
                    if (gui.getTxtMedicine().getText().contentEquals("") || gui.getTxtPrescriptionGuide().getText().contentEquals("")) {
                        JOptionPane.showMessageDialog(null, "Please complete the prescription you would like to assign", "Prescription incomplete", JOptionPane.OK_OPTION);
                        isPresValid = false;
                    } else {
                        prescriptionName = gui.getTxtMedicine().getText();
                        prescriptionQuantity = (int) gui.getSpnQuantity().getValue();
                        dosage = gui.getTxtPrescriptionGuide().getText();
                    }
                }

                if (gui.getChkAppointment().isSelected()) {
                    timeQuantity = (int) gui.getSpnDate().getValue();
                    if (gui.getRdoDays().isSelected()) {
                        timeFrame = "DAYS";
                    } else if (gui.getRdoMonths().isSelected()) {
                        timeFrame = "MONTHS";
                    } else if (gui.getRdoYears().isSelected()) {
                        timeFrame = "YEARS";
                    }
                }

                if (isAppValid == true && isPresValid == true) {
                    processAppointment(notes, prescriptionName, prescriptionQuantity, dosage, timeQuantity, timeFrame);
                }

            }
        }

    }
}
