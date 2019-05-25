/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Patient;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.ProvideFeedback;

/**
 *
 * @author Anthony
 */
public class ProvideFeedbackController {

    private final ProvideFeedback gui;
    private final Patient authorisingPatient;
    private final String strDoctor;

    public ProvideFeedbackController(Patient patient, String strDoctor) {
        this.gui = new ProvideFeedback();
        this.authorisingPatient = patient;
        this.strDoctor = strDoctor;

        initialiseEventHandlers();

        gui.setVisible(true);
    }

    private void initialiseEventHandlers() {
        gui.addBackEventHandler(new btnBackListener());
        gui.addSubmitEventHandler(new btnSubmitListener());
    }

    private class btnBackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
        }

    }

    private class btnSubmitListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int rating = gui.getSldRating().getValue();
            String comments = gui.getTxtComments().getText();

            JOptionPane.showMessageDialog(null, "Thank you for your feedback, this has been processed", "Thank you for your feedback", JOptionPane.INFORMATION_MESSAGE);

            authorisingPatient.provideFeedback(rating, comments, strDoctor);
            gui.dispose();
        }

    }
}
