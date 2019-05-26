/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Admin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.AddAccount;

/**
 *
 * @author Anthony
 */
public class AddAccountController implements IController {

    private final AddAccount gui;
    private final AdminController parentController;

    public AddAccountController(AdminController controller) {
        this.gui = new AddAccount();
        this.parentController = controller;

        initialiseEventHandlers();
        
        gui.setVisible(true);
    }
    
    @Override
    public void initialiseEventHandlers() {
        gui.addBackEventHandler(new btnBackListener());
        gui.addSubmitEventHandler(new btnSubmitListener());
    }

    @Override
    public void cleanUi() {
        gui.getTxtFirst().setText("");
        gui.getTxtLast().setText("");
        gui.getTxtAddress().setText("");
        gui.getTxtPassword().setText("");
        gui.getCmbAccountType().setSelectedIndex(0);
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
            String first;
            String last;
            String address;
            char[] password;
            String accountType;

            first = gui.getTxtFirst().getText();
            last = gui.getTxtLast().getText();
            address = gui.getTxtAddress().getText();

            password = gui.getTxtPassword().getPassword();
            accountType = gui.getCmbAccountType().getSelectedItem().toString();

            String id = parentController.getAuthorisingAdmin().createAccount(first, last, address, password, accountType);

            JOptionPane.showMessageDialog(null, "Their id is: " + id, "Unique ID", JOptionPane.INFORMATION_MESSAGE);
            gui.dispose();
            parentController.cleanUi();
        }

    }
}
