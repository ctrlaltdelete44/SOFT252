/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import accounts.Patient;
import view.PatientView;

/**
 *
 * @author Anthony
 */
public class PatientController {
    private final PatientView gui;
    private final Patient authorisingPatient;

    public PatientController(Account authorisingPatient) {
        this.gui = new PatientView();
        this.authorisingPatient = (Patient)authorisingPatient;
        
        gui.setVisible(true);
    }
    
    
    
//     private void patient_btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {                                                  
//        logout();
//    }                                                 
//
//    private void patient_btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {                                                  
//        patientController.requestDeletion();
//      
//        JOptionPane.showMessageDialog(null, "Your request has been processed, and must be approved by a secretary", "Request approved", JOptionPane.INFORMATION_MESSAGE);
//    }                                                 
//
//    
//    private String strDoctor;
//    private void patient_btnProvideFeedbackActionPerformed(java.awt.event.ActionEvent evt) {                                                           
//        strDoctor = patient_lstDoctors.getSelectedValue();
//        cleanUI(panelPatient, panelFeedback);
//    }                   
//    private void patient_lstDoctorsValueChanged(javax.swing.event.ListSelectionEvent evt) {                                                
//        if (patient_lstDoctors.getSelectedValue() != null)
//        {
//            patient_btnProvideFeedback.setEnabled(true);
//            patient_lstAvailability.setListData(patientController.viewDoctorAvailability(patient_lstDoctors.getSelectedValue()));
//        }
//        else
//        {
//            patient_btnProvideFeedback.setEnabled(false);
//            patient_lstAvailability.setListData(new String[0]);
//        }       
//    }   
//     private void patient_btnRequestAppointmentActionPerformed(java.awt.event.ActionEvent evt) {                                                              
//        String strRequestedDoctor = patient_lstDoctors.getSelectedValue();
//        String strRequestedDate = patient_lstAvailability.getSelectedValue();
//       
//        if (strRequestedDoctor == null)
//            JOptionPane.showMessageDialog(null, "Please select a doctor", "No doctor selected", JOptionPane.OK_OPTION);
//        else if (strRequestedDate == null)
//            JOptionPane.showMessageDialog(null, "Please select a date", "No date selected", JOptionPane.OK_OPTION);
//        else
//        {
//            patientController.requestAppointment(strRequestedDoctor, strRequestedDate);
//            JOptionPane.showMessageDialog(null, "Your request has been submitted", "Action processed", JOptionPane.OK_OPTION);
//        }
//        
//        System.out.println("Selected doctor: " + strRequestedDoctor);
//        //System.out.println("Selected date: " + strRequestedDate);
//        
//        
//    }     
//     private void patient_btnViewPrescriptionActionPerformed(java.awt.event.ActionEvent evt) {                                                            
//        cleanUI(panelPatient, panelPrescription);
//    }      
}
