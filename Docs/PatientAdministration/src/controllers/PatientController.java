/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import accounts.Doctor;
import accounts.Patient;
import appointments.Appointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utilities.AccountAdapter;
import utilities.DateAdapter;
import utilities.accounts.AccountType;
import view.PatientView;

/**
 *
 * @author Anthony
 */
public class PatientController extends DashboardController {

    private final PatientView gui;
    private final Patient authorisingPatient;

    public PatientController(Account authorisingPatient) {
        this.gui = new PatientView();
        this.authorisingPatient = (Patient) authorisingPatient;
        
        initialiseEventHandlers();

        cleanUi();
        gui.setVisible(true);
    }
    
    @Override
    public void initialiseEventHandlers() {
        gui.addLogoutEventHandler(new btnLogoutListener());
        gui.addDeleteEventHandler(new btnDeleteListener());
        gui.addProvideFeedbackEventHandler(new btnProvideFeedbackListener());
        gui.addRequestAppointmentEventHandler(new btnRequestAppointmentListener());
        gui.addViewPrescriptionEventHandler(new btnViewPrescriptionListener());
        
        gui.addDoctorsChangedListener(new lstDoctorsValueListener());
    }

    @Override
    public void cleanUi() {
        gui.getLblWelcome().setText("Logged in as: " + authorisingPatient.getFirstName() + " " + authorisingPatient.getSurname());
        gui.getBtnProvideFeedback().setEnabled(false);
        gui.getLstDoctors().setListData(authorisingPatient.viewAccounts(AccountType.DOCTOR));
        gui.getLstHistory().setListData(authorisingPatient.viewHistory());
        
        String strAppt = viewNextAppointment();
        gui.getTxtNextAppointment().setText(strAppt);
        
        if (strAppt.contentEquals(""))
        {
            gui.getLblActiveAppointment().setVisible(false);
            gui.getBtnRequestAppointment().setEnabled(true);
        }
        else
        {
            gui.getLblActiveAppointment().setVisible(true);
            gui.getBtnRequestAppointment().setEnabled(false);
        }    
        
        if (authorisingPatient.getPrescription() != null)
            gui.getBtnViewPrescription().setEnabled(true);
        else
            gui.getBtnViewPrescription().setEnabled(false);
    }
    
    private String[] viewDoctorAvailability(String strDoctor) {
        AccountAdapter adapter = new AccountAdapter(strDoctor);
        Doctor doctor = (Doctor) adapter.convert();

        return doctor.viewFreeDates();
    }
    
    private String viewNextAppointment()
    {
        Appointment app = authorisingPatient.getAppointment();
        
        if (app != null)
        {
            //System.out.println("Returning that patient has appt:PCONTROLLER");
            return app.getDoctor().getFirstName() + " " + app.getDoctor().getSurname() + " on " + app.getDate();
        }
        else
        {
            //System.out.println("Returning null:PCONTROLLER");
            return "";
            
        }
    }

    private class btnLogoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
            new LoginController();
        }

    }

    private class btnDeleteListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            authorisingPatient.createDeleteRequest();
            JOptionPane.showMessageDialog(null, "Your request has been processed, and must be approved by a secretary", "Request approved", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private class btnProvideFeedbackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String strDoctor = gui.getLstDoctors().getSelectedValue();
            new ProvideFeedbackController(authorisingPatient, strDoctor);
        }

    }

    private class btnRequestAppointmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String strRequestedDoctor = gui.getLstDoctors().getSelectedValue();
            String strRequestedDate = gui.getLstAvailability().getSelectedValue();

            if (strRequestedDoctor == null) {
                JOptionPane.showMessageDialog(null, "Please select a doctor", "No doctor selected", JOptionPane.OK_OPTION);
            } else if (strRequestedDate == null) {
                JOptionPane.showMessageDialog(null, "Please select a date", "No date selected", JOptionPane.OK_OPTION);
            } else {
                DateAdapter datAdapter = new DateAdapter(strRequestedDate);
                LocalDate date = datAdapter.convert();

                authorisingPatient.createAppointmentRequest(strRequestedDoctor, date);
                JOptionPane.showMessageDialog(null, "Your request has been submitted", "Action processed", JOptionPane.OK_OPTION);
            }
        }

    }

    private class btnViewPrescriptionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            new PrescriptionController(authorisingPatient);
        }

    }

    private class lstDoctorsValueListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (gui.getLstDoctors().getSelectedValue() != null) {
                gui.getBtnProvideFeedback().setEnabled(true);
                gui.getLstAvailability().setListData(viewDoctorAvailability(gui.getLstDoctors().getSelectedValue()));
            } else {
                gui.getBtnProvideFeedback().setEnabled(false);
                gui.getLstAvailability().setListData(new String[0]);
            }
        }

    }
}
