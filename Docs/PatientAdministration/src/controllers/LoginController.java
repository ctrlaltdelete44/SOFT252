/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilities.serialised.AccountSingleton;
import utilities.serialised.Compilation;
import utilities.view.PlaceHolderTextListener;
import view.Login;

/**
 *
 * @author Anthony
 */
public class LoginController implements IController{

    private final Login gui;

    private final AccountSingleton accounts = AccountSingleton.getOrCreate();

    private final Compilation c = new Compilation();

    public LoginController() {
        this.gui = new Login();
        
        initialiseEventHandlers();

        gui.setVisible(true);
    }

    @Override
    public void initialiseEventHandlers() {
        gui.addLoginEventHandler(new btnLoginListener());
        gui.addRequestEventHandler(new btnRequestListener());
        gui.addUsernamePlaceholder(new PlaceHolderTextListener("Username"));
        gui.addPasswordPlaceholder(new PlaceHolderTextListener("Password"));
    }

    @Override
    public void cleanUi() {
        gui.getTxtUsername().setText("");
        gui.getTxtPassword().setText("");
        gui.getLblErrorInvalidUsername().setVisible(false);
    }

    private class btnLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //retrieve info from gui
            String username = gui.getTxtUsername().getText();
            char[] arrPassword = gui.getTxtPassword().getPassword();

            //convert char[] to string
            String strPassword = String.valueOf(arrPassword);

            //retrieve info from docs
            c.deconstruct();

            //loop through accts
            for (Account a : accounts.getAccounts()) {
                //if password and login match, login - assign currently logged in, etc, return account type
                if ((a.getUniqueId().contentEquals(username)) && (a.getPassword().contentEquals(strPassword))) {
                    gui.getLblErrorInvalidUsername().setVisible(false);

                    switch (a.getAccountType()) {
                        case ADMIN:
                            new AdminController(a);
                            gui.dispose();
                            return;
                        case SECRETARY:
                            new SecretaryController(a);
                            gui.dispose();
                            return;
                        case PATIENT:
                            new PatientController(a);
                            gui.dispose();
                            return;
                        case DOCTOR:
                            new DoctorController(a);
                            gui.dispose();
                            return;
                    }
                    
                }
                else {
                    gui.getLblErrorInvalidUsername().setVisible(true);
                }
            }
        }

    }
    
    private class btnRequestListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
            new RequestAccountController();
        }
        
        
    }
}
