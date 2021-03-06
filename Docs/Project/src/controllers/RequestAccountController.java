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
import utilities.serialised.AccountSingleton;
//import utilities.serialised.Compilation;
import utilities.view.PlaceHolderTextListener;
import view.RequestAccount;

/**
 *
 * @author Anthony
 */
public class RequestAccountController implements IController {

    private final RequestAccount gui;

    public RequestAccountController() {
        this.gui = new RequestAccount();

        initialiseEventHandlers();

        gui.setVisible(true);
    }

    private void requestCreation(String first, String last, String address, String sex, int age, char[] arrPassword) {
//        Compilation c= new Compilation();
//        c.deconstruct();
        AccountSingleton accounts = AccountSingleton.getOrCreate();
        Patient p = new Patient(first, last, address);
        p.assignPatientInfo(sex, age, arrPassword);
    }

    @Override
    public void initialiseEventHandlers() {
        gui.addConfirmEventHandler(new btnConfirmListener());
        gui.addCancelEventHandler(new btnCancelListener());

        gui.addFirstPlaceholder(new PlaceHolderTextListener("First Name"));
        gui.addLastPlaceholder(new PlaceHolderTextListener("Surname"));
        gui.addPasswordPlaceholder(new PlaceHolderTextListener("Password"));
    }

    @Override
    public void cleanUi() {
        gui.getTxtFirst().setText("");
        gui.getTxtSurname().setText("");
        gui.getTxtAddress().setText("");
        gui.getRdoMale().setSelected(true);
        gui.getRdoFemale().setSelected(false);
        gui.getSpnAge().setValue(18);
        gui.getTxtPassword().setText("");
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

            requestCreation(first, last, address, sex, age, password);
            JOptionPane.showMessageDialog(null, "We have received your request. Once it has been approved, you will be able to log in", "Request processed", JOptionPane.INFORMATION_MESSAGE);

            gui.dispose();
            new LoginController();
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
