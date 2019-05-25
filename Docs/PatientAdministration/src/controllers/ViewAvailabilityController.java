/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Doctor;
import accounts.Secretary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utilities.AccountAdapter;
import utilities.accounts.AccountType;
import view.ViewAvailability;

/**
 *
 * @author Anthony
 */
public class ViewAvailabilityController {

    private final ViewAvailability gui;
    private final String request;
    private final Secretary authorisingSecretary;

    public ViewAvailabilityController(String request, Secretary authorisingSecretary) {
        this.gui = new ViewAvailability();
        this.request = request;
        this.authorisingSecretary = authorisingSecretary;
        
        initialiseUi();
        initialiseEventHandlers();

        gui.setVisible(true);
    }
    
    private void initialiseUi() {
        gui.getLblRequest().setText(request);
        gui.getLstDoctors().setListData(authorisingSecretary.viewAccounts(AccountType.DOCTOR));
    }
    
    private void initialiseEventHandlers() {
        gui.addSubmitEventHandler(new btnSubmitListener());
        gui.addDoctorsChangedListener(new lstDoctorsValueListener());
    }

    public String[] viewDoctorFreeDays(String strDoctor) {
        AccountAdapter adapter = new AccountAdapter(strDoctor);
        Doctor doctor = (Doctor) adapter.convert();

        return doctor.viewFreeDates();
    }

    private class btnSubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String assignedDoctor = gui.getLstDoctors().getSelectedValue();
            String assignedDate = gui.getLstSchedule().getSelectedValue();

            if (assignedDoctor == null) {
                JOptionPane.showMessageDialog(null, "Please select a doctor", "No doctor selected", JOptionPane.OK_OPTION);
            } else if (assignedDate == null) {
                JOptionPane.showMessageDialog(null, "Please select a date", "No date selected", JOptionPane.OK_OPTION);
            } else {
                String output = authorisingSecretary.authoriseRequest(request, assignedDoctor, assignedDate);
                JOptionPane.showMessageDialog(null, output, "Appointment made", JOptionPane.OK_OPTION);
                gui.dispose();
            }
        }

    }

    private class lstDoctorsValueListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            String selected = gui.getLstDoctors().getSelectedValue();
            if (selected != null) {
                gui.getLstSchedule().setListData(viewDoctorFreeDays(selected));
            } else {
                gui.getLstSchedule().setListData(new String[0]);
            }
        }

    }
}
