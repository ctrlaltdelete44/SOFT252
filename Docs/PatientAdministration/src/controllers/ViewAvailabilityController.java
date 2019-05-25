/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Secretary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
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
        
        gui.getLblRequest().setText(request);
        gui.addSubmitEventHandler(new btnSubmitListener());

        gui.setVisible(true);
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

            }
        }

    }
}
