/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import accounts.Secretary;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import utilities.accounts.AccountType;
import view.SecretaryView;

/**
 *
 * @author Anthony
 */
public class SecretaryController extends DashboardController {

    private final SecretaryView gui;
    private final Secretary authorisingSecretary;

    public SecretaryController(Account s) {
        this.gui = new SecretaryView();
        this.authorisingSecretary = (Secretary) s;

        initialiseEventHandlers();
        cleanUi();
        gui.setVisible(true);
        
        viewNotifications();
    }

    @Override
    public void initialiseEventHandlers() {
        gui.addLogoutEventHandler(new btnLogoutListener());
        gui.addDeleteRequestEventHandler(new btnDeleteRequestListener());
        gui.addDeleteAccountEventHandler(new btnDeleteAccountListener());
        gui.addConfirmRequestEventHandler(new btnConfirmRequestListener());
        gui.addAddStockListener(new btnAddStockListener());

        gui.addRequestsChangedListener(new lstRequestsValueListener());
        gui.addStockChangedListener(new lstStockValueListener());
        gui.addPatientsChangedListener(new lstPatientsValueListener());
        
        gui.addUpdatePageEventHandler(new refreshPageListener()); 
    }
    
    @Override
    public void cleanUi() {
        gui.getLstRequests().setListData(authorisingSecretary.viewRequests());
        gui.getLstStock().setListData(authorisingSecretary.viewStock());
        gui.getLstPatients().setListData(authorisingSecretary.viewAccounts(AccountType.PATIENT));

        gui.getBtnConfirmRequest().setEnabled(false);
        gui.getBtnDeleteRequest().setEnabled(false);
        gui.getBtnDeleteAccount().setEnabled(false);

        gui.getTxtStockName().setText("");
        gui.getSpnQuantity().setValue(0);
        gui.getLblWelcome().setText("Logged in as: " + authorisingSecretary.getFirstName() + " " + authorisingSecretary.getSurname());
    }

    @Override
    public String[] viewNotifications() {
        return authorisingSecretary.getNotifications();        
    }
    
    private String getStockName(String strStock) {
        String[] splitString = strStock.split(":");
        return splitString[0];
    }

    private class btnLogoutListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
            new LoginController();
        }
    }

    private class btnDeleteRequestListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int input = JOptionPane.showConfirmDialog(null, "This will permanently delete this request. Do you want to continue?", "Confirm delete", JOptionPane.YES_NO_OPTION);
            //0=yes, 1=no
            if (input == 0) {
                authorisingSecretary.deleteRequest(gui.getLstRequests().getSelectedValue());
            }
            cleanUi();
        }

    }

    private class btnDeleteAccountListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int input = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete this patient account?", "Confirm delete", JOptionPane.YES_NO_OPTION);
            //0=yes, 1=no
            if (input == 0) {
                authorisingSecretary.removeAccount(gui.getLstPatients().getSelectedValue());
            }
            cleanUi();
        }

    }

    private class btnConfirmRequestListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String request = gui.getLstRequests().getSelectedValue();
            String output = authorisingSecretary.authoriseRequest(request);

            if (!request.contains("APPOINTMENT")) {
                JOptionPane.showMessageDialog(null, output, "Request approved", JOptionPane.INFORMATION_MESSAGE);
                cleanUi();
            } else {
                new ViewAvailabilityController(request, authorisingSecretary);
            }
        }

    }

    private class btnAddStockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = gui.getTxtStockName().getText();
            int quantity = (int) gui.getSpnQuantity().getValue();

            if (!name.equals("")) {
                authorisingSecretary.addToStock(name, quantity);
            }
            cleanUi();
        }

    }

    private class lstRequestsValueListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (gui.getLstRequests().getSelectedValue() != null) {
                gui.getBtnConfirmRequest().setEnabled(true);
                gui.getBtnDeleteRequest().setEnabled(true);
            } else {
                gui.getBtnConfirmRequest().setEnabled(false);
                gui.getBtnDeleteRequest().setEnabled(false);
            }
        }
    }

    private class lstStockValueListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (gui.getLstStock().getSelectedValue() != null) {
                gui.getTxtStockName().setText(getStockName(gui.getLstStock().getSelectedValue()));
            }
        }

    }

    private class lstPatientsValueListener implements ListSelectionListener {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (gui.getLstPatients().getSelectedValue() != null) {
                gui.getBtnDeleteAccount().setEnabled(true);
            } else {
                gui.getBtnDeleteAccount().setEnabled(false);
            }
        }

    }
}
