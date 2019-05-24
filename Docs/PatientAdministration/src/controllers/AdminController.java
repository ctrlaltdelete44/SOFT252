/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import accounts.Admin;
import view.AdminView;

/**
 *
 * @author Anthony
 */
public class AdminController {
    private final AdminView gui;
    private final Admin authorisingAdmin;

    public AdminController(Account authorisingAdmin) {
        this.gui = new AdminView();
        this.authorisingAdmin = (Admin)authorisingAdmin;
        
        gui.setVisible(true);
    }
    
    
}


//private void admin_btnAddAccountActionPerformed(java.awt.event.ActionEvent evt) {                                                    
//        cleanUI(panelAdmin, panelAddAccount);
//    }                                                   
//
//    private void admin_btnDeleteDoctorActionPerformed(java.awt.event.ActionEvent evt) {                                                      
//        int input = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete this doctor account?", "Confirm delete", JOptionPane.YES_NO_OPTION);
//        //0=yes, 1=no
//        if (input == 0)
//            adminController.deleteSelected(admin_lstDoctors.getSelectedValue());
//        cleanAdmin();
//    }           
//private void admin_btnDeleteSecretaryActionPerformed(java.awt.event.ActionEvent evt) {                                                         
//        int input = JOptionPane.showConfirmDialog(null, "Are you sure you wish to delete this secretary account?", "Confirm delete", JOptionPane.YES_NO_OPTION);
//        //0=yes, 1=no
//        if (input == 0)
//            adminController.deleteSelected(admin_lstSecretaries.getSelectedValue());
//        cleanAdmin();
//    }                                                        
//
//    private void admin_lstDoctorsValueChanged(javax.swing.event.ListSelectionEvent evt) {                                              
//        if (admin_lstDoctors.getSelectedValue() != null)
//        {
//            admin_btnDeleteDoctor.setEnabled(true);
//            admin_lstComments.setListData(adminController.viewFeedback(admin_lstDoctors.getSelectedValue()));
//        }
//        else
//            admin_btnDeleteDoctor.setEnabled(false);
//    }                                             
//
//    private void admin_lstSecretariesValueChanged(javax.swing.event.ListSelectionEvent evt) {                                                  
//        if (admin_lstSecretaries.getSelectedValue() != null)
//            admin_btnDeleteSecretary.setEnabled(true);
//        else
//            admin_btnDeleteSecretary.setEnabled(false);
//private void admin_btnProvideFeedbackActionPerformed(java.awt.event.ActionEvent evt) {                                                         
//        String account = admin_lstDoctors.getSelectedValue();
//        String message = admin_txtFeedbackMessage.getText();
//        
//        if (account == null || message.contentEquals(""))
//            JOptionPane.showMessageDialog(null, "Please enter a valid message for a doctor account", "Invalid selection", JOptionPane.OK_OPTION);
//        else
//        {
//            adminController.giveFeedback(account, message);
//            JOptionPane.showMessageDialog(null, "Feedback sent", "Feedback sent", JOptionPane.OK_OPTION);
//        }
//    }        

//    private void cleanAdmin()
//    {
//        admin_lstDoctors.setListData(adminController.viewDoctors());
//        admin_lstSecretaries.setListData(adminController.viewSecretaries());
//        admin_btnDeleteDoctor.setEnabled(false);
//        admin_btnDeleteSecretary.setEnabled(false);
//        admin_lblWelcome.setText("Logged in as: " + controller.getLoggedIn().getFirstName() + " " + controller.getLoggedIn().getSurname());
//        admin_txtFeedbackMessage.setText("");
//        admin_lstComments.setListData(new String[0]);
//    }