/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import accounts.accountfactory.AbstractAccountFactory;
import accounts.accountfactory.ConcreteAccountFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import utilities.accounts.AccountType;
import utilities.serialised.AccountSingleton;
import utilities.serialised.AppointmentSingleton;
import utilities.serialised.IdGenerator;
import utilities.serialised.RequestSingleton;
import utilities.serialised.StockSingleton;
import utilities.view.PlaceHolderTextListener;
import view.Login;

/**
 *
 * @author Anthony
 */
public class LoginController implements IController {

    private final Login gui;

    private final AccountSingleton accounts = AccountSingleton.getOrCreate();

    public LoginController() {
        this.gui = new Login();

//        AppointmentSingleton.getOrCreate();        
//        RequestSingleton.getOrCreate();
//        StockSingleton.getOrCreate();
//        new IdGenerator();
//        AbstractAccountFactory accountFactory = new ConcreteAccountFactory();
//        String newId = accountFactory.createAccount("Anthony", "Davies", "Discworld", "admin", AccountType.ADMIN);

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
        gui.getLblErrorInvalidLogin().setVisible(false);
    }

    private class btnLoginListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //retrieve info from gui
            String username = gui.getTxtUsername().getText();
            String strPassword = String.valueOf(gui.getTxtPassword().getPassword());

            //loop through accts
            for (Account a : (ArrayList<Account>)accounts.getData()) {
                //if password and login match, login - assign currently logged in, etc, return account type
                if ((a.getUniqueId().contentEquals(username)) && (a.getPassword().contentEquals(strPassword))) {
                    gui.dispose();

                    switch (a.getAccountType()) {
                        case ADMIN:
                            new AdminController(a);
                            return;
                        case SECRETARY:
                            new SecretaryController(a);
                            return;
                        case PATIENT:
                            new PatientController(a);
                            return;
                        case DOCTOR:
                            new DoctorController(a);
                            return;
                    }

                } else {
                    gui.getLblErrorInvalidLogin().setVisible(true);
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
