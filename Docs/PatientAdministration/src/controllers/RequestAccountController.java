/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import utilities.view.PlaceHolderTextListener;
import view.RequestAccount;

/**
 *
 * @author Anthony
 */
public class RequestAccountController {

    private final RequestAccount gui;

    public RequestAccountController() {
        this.gui = new RequestAccount();
        
        gui.addConfirmEventHandler(new btnConfirmListener());
        gui.addCancelEventHandler(new btnCancelListener());
        
        gui.addFirstPlaceholder(new PlaceHolderTextListener("First Name"));
        gui.addLastPlaceholder(new PlaceHolderTextListener("Surname"));
        gui.addPasswordPlaceholder(new PlaceHolderTextListener("Password"));

        gui.setVisible(true);
    }

    private class btnConfirmListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String first = gui.getTxtFirst().getText();
            String last = gui.getTxtSurname().getText();
            String address = gui.getTxtAddress().getText();
            String sex;
            int age = Integer.valueOf(gui.getSpnAge().getValue().toString());
            char[] password = gui.getTxtPassword().getPassword();

            if (gui.getRdoMale().isEnabled()) {
                sex = "M";
            } else {
                sex = "F";
            }
            
            JOptionPane.showMessageDialog(null, "We have received your request. Once it has been approved, you will be able to log in", "Request processed", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    
    private class btnCancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
            new LoginController();
        }
        
    }
}

