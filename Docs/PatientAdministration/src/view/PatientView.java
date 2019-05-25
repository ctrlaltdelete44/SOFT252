/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

/**
 *
 * @author Anthony
 */
public class PatientView extends javax.swing.JFrame {

    /**
     * Creates new form PatientView
     */
    public PatientView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public JButton getBtnDelete() {
        return btnDelete;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public JButton getBtnProvideFeedback() {
        return btnProvideFeedback;
    }

    public JButton getBtnRequestAppointment() {
        return btnRequestAppointment;
    }

    public JButton getBtnViewPrescription() {
        return btnViewPrescription;
    }

    public JLabel getLblActiveAppointment() {
        return lblActiveAppointment;
    }

    public JLabel getLblNextAppointment() {
        return lblNextAppointment;
    }

    public JLabel getLblWelcome() {
        return lblWelcome;
    }

    public JList<String> getLstAvailability() {
        return lstAvailability;
    }

    public JList<String> getLstDoctors() {
        return lstDoctors;
    }

    public JList<String> getLstHistory() {
        return lstHistory;
    }

    public JTextField getTxtNextAppointment() {
        return txtNextAppointment;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblWelcome = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDoctors = new javax.swing.JList<>();
        lblDoctors = new javax.swing.JLabel();
        btnProvideFeedback = new javax.swing.JButton();
        btnRequestAppointment = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstAvailability = new javax.swing.JList<>();
        lblAvailability = new javax.swing.JLabel();
        lblNextAppointment = new javax.swing.JLabel();
        lblActiveAppointment = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        lstHistory = new javax.swing.JList<>();
        lblHistoryTitle = new javax.swing.JLabel();
        txtNextAppointment = new javax.swing.JTextField();
        btnViewPrescription = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblWelcome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblWelcome.setText("Welcome");

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnLogout.setText("Log Out");

        btnDelete.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDelete.setText("Delete Account");

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lstDoctors.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lstDoctors.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(lstDoctors);

        lblDoctors.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblDoctors.setText("Doctors");

        btnProvideFeedback.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnProvideFeedback.setText("Rate Doctor");

        btnRequestAppointment.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnRequestAppointment.setText("Request Appointment");

        jScrollPane8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lstAvailability.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lstAvailability.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane8.setViewportView(lstAvailability);

        lblAvailability.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAvailability.setText("Availability");

        lblNextAppointment.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNextAppointment.setText("Your next appointment is...");

        lblActiveAppointment.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblActiveAppointment.setForeground(new java.awt.Color(255, 0, 0));
        lblActiveAppointment.setText("You already have an active appointment");

        jScrollPane13.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jScrollPane13.setPreferredSize(new java.awt.Dimension(630, 397));

        lstHistory.setFont(new java.awt.Font("Tahoma", 0, 17)); // NOI18N
        lstHistory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstHistory.setFixedCellWidth(628);
        lstHistory.setPreferredSize(null);
        jScrollPane13.setViewportView(lstHistory);

        lblHistoryTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblHistoryTitle.setText("Your previous appointments");

        txtNextAppointment.setEditable(false);
        txtNextAppointment.setFont(new java.awt.Font("Courier New", 1, 24)); // NOI18N

        btnViewPrescription.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnViewPrescription.setText("View Prescription");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addComponent(lblActiveAppointment)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnDelete))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblWelcome))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(lblDoctors, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnProvideFeedback, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnRequestAppointment, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 243, Short.MAX_VALUE)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jScrollPane13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 1370, Short.MAX_VALUE)
                                    .addComponent(lblHistoryTitle, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnViewPrescription, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtNextAppointment, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblNextAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLogout)
                .addGap(11, 11, 11)
                .addComponent(lblWelcome, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctors)
                    .addComponent(lblAvailability)
                    .addComponent(lblNextAppointment))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtNextAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblHistoryTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane13, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProvideFeedback)
                    .addComponent(btnRequestAppointment)
                    .addComponent(btnViewPrescription))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblActiveAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnDelete)
                .addGap(20, 20, 20))
        );

        lblActiveAppointment.setVisible(false);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnProvideFeedback;
    private javax.swing.JButton btnRequestAppointment;
    private javax.swing.JButton btnViewPrescription;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lblActiveAppointment;
    private javax.swing.JLabel lblAvailability;
    private javax.swing.JLabel lblDoctors;
    private javax.swing.JLabel lblHistoryTitle;
    private javax.swing.JLabel lblNextAppointment;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList<String> lstAvailability;
    private javax.swing.JList<String> lstDoctors;
    private javax.swing.JList<String> lstHistory;
    private javax.swing.JTextField txtNextAppointment;
    // End of variables declaration//GEN-END:variables
}