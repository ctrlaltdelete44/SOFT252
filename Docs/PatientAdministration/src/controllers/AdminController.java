/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import accounts.Admin;
import accounts.Doctor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utilities.AccountAdapter;
import utilities.accounts.AccountType;
import view.AdminView;

/**
 *
 * @author Anthony
 */
public class AdminController extends DashboardController{

    private final AdminView gui;
    private final Admin authorisingAdmin;

    public AdminController(Account authorisingAdmin) {
        this.gui = new AdminView();
        this.authorisingAdmin = (Admin) authorisingAdmin;
        
        initialiseEventHandlers();
        cleanUi();
        viewNotifications();
        
        gui.setVisible(true);
        
        
    }

    @Override
    public void initialiseEventHandlers() {
        gui.addLogoutEventHandler(new btnLogoutListener(gui));
        gui.addAddAccountEventHandler(new btnAddAccountListener(this));
        gui.addDeleteDoctorEventHandler(new btnDeleteDoctorListener());
        gui.addDeleteSecretaryEventHandler(new btnDeleteSecretaryListener());
        gui.addProvideFeedbackEventHandler(new btnProvideFeedbackListener());
        
        gui.addDoctorsChangedListener(new lstDoctorsValueListener());
        gui.addSecretariesChangedListener(new lstSecretariesValueListener());
        
        gui.addUpdatePageEventHandler(new refreshPageListener()); 
    }

    @Override
    public void cleanUi() {
        gui.getLstDoctors().setListData(authorisingAdmin.viewAccounts(AccountType.DOCTOR));
        gui.getLstSecretaries().setListData(authorisingAdmin.viewAccounts(AccountType.SECRETARY));
        gui.getBtnDeleteDoctor().setEnabled(false);
        gui.getBtnDeleteSecretary().setEnabled(false);
        gui.getLblWelcome().setText("Logged in as: " + authorisingAdmin.getFirstName() + " " + authorisingAdmin.getSurname());
        gui.getTxtFeedbackMessage().setText("");
        gui.getLstComments().setListData(new String[0]);
    }
    
    @Override
    public String[] viewNotifications() {
        return authorisingAdmin.getNotifications();        
    }

    public String[] viewFeedback(String strDoctor) {
        AccountAdapter adapter = new AccountAdapter(strDoctor);
        Doctor d = (Doctor) adapter.convert();
        return d.viewFeedback();
    }

    public Admin getAuthorisingAdmin() {
        return authorisingAdmin;
    }
    
    private class btnAddAccountListener implements ActionListener {
        private final AdminController controller;

        public btnAddAccountListener(AdminController controller) {
            this.controller = controller;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddAccountController(controller);
        }
    }

    private class btnDeleteDoctorListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete this doctor account?", "Confirm delete", JOptionPane.YES_NO_OPTION);
            //0=yes, 1=no
            if (input == 0) {
                authorisingAdmin.deleteAccount(gui.getLstDoctors().getSelectedValue());
            }
            cleanUi();
        }

    }

    private class btnDeleteSecretaryListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete this secretary account?", "Confirm delete", JOptionPane.YES_NO_OPTION);
            //0=yes, 1=no
            if (input == 0) {
                authorisingAdmin.deleteAccount(gui.getLstSecretaries().getSelectedValue());
            }
            cleanUi();
        }
    }

    private class btnProvideFeedbackListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String account = gui.getLstDoctors().getSelectedValue();
            String message = gui.getTxtFeedbackMessage().getText();

            if (account == null || message.contentEquals("")) {
                JOptionPane.showMessageDialog(null, "Please enter a valid message for a doctor account", "Invalid selection", JOptionPane.OK_OPTION);
            } else {
                authorisingAdmin.provideFeedback(account, message);
                JOptionPane.showMessageDialog(null, "Feedback sent", "Feedback sent", JOptionPane.OK_OPTION);
            }
        }
    }

    private class lstDoctorsValueListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (gui.getLstDoctors().getSelectedValue() != null) {
                gui.getBtnDeleteDoctor().setEnabled(true);
                gui.getLstComments().setListData(viewFeedback(gui.getLstDoctors().getSelectedValue()));
            } else {
                gui.getBtnDeleteDoctor().setEnabled(false);
            }
        }

    }

    private class lstSecretariesValueListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (gui.getLstSecretaries().getSelectedValue() != null) {
                gui.getBtnDeleteSecretary().setEnabled(true);
            } else {
                gui.getBtnDeleteSecretary().setEnabled(false);
            }
        }
    }
}
