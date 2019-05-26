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
import javax.swing.JToggleButton;

/**
 *
 * @author Anthony
 */
public class DoctorView extends javax.swing.JFrame {

    /**
     * Creates new form DoctorView
     */
    public DoctorView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public JToggleButton getBtnBookings() {
        return btnBookings;
    }

    public JToggleButton getBtnFreeDays() {
        return btnFreeDays;
    }

    public JButton getBtnLogout() {
        return btnLogout;
    }

    public JButton getBtnRequestStock() {
        return btnRequestStock;
    }

    public JToggleButton getBtnSchedule() {
        return btnSchedule;
    }

    public JButton getBtnScheduleWeek() {
        return btnScheduleWeek;
    }

    public JButton getBtnTakeAppointment() {
        return btnTakeAppointment;
    }

    public JLabel getLblRating() {
        return lblRating;
    }

    public JLabel getLblWelcome() {
        return lblWelcome;
    }

    public JList<String> getLstSchedule() {
        return lstSchedule;
    }

    public JLabel getTxtSchedule() {
        return txtSchedule;
    }

    public JTextField getTxtStock() {
        return txtStock;
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
        lblRating = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        lstSchedule = new javax.swing.JList<>();
        txtSchedule = new javax.swing.JLabel();
        btnBookings = new javax.swing.JToggleButton();
        btnSchedule = new javax.swing.JToggleButton();
        btnFreeDays = new javax.swing.JToggleButton();
        btnTakeAppointment = new javax.swing.JButton();
        btnScheduleWeek = new javax.swing.JButton();
        lblOrderStockTitle = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        btnRequestStock = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Dashboard | PAA");

        lblWelcome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblWelcome.setText("Welcome");

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnLogout.setText("Log Out");

        lblRating.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblRating.setText("Your rating is: ");

        lstSchedule.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lstSchedule.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane7.setViewportView(lstSchedule);

        txtSchedule.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtSchedule.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSchedule.setText("Upcoming Schedule");

        btnBookings.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBookings.setText("Bookings");
        btnBookings.setPreferredSize(new java.awt.Dimension(229, 36));

        btnSchedule.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSchedule.setSelected(true);
        btnSchedule.setText("Entire Schedule");
        btnSchedule.setPreferredSize(new java.awt.Dimension(262, 36));

        btnFreeDays.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnFreeDays.setText("Free Days");

        btnTakeAppointment.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnTakeAppointment.setText("Take Appointment");

        btnScheduleWeek.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnScheduleWeek.setText("Schedule New Week");

        lblOrderStockTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblOrderStockTitle.setText("Order Stock");

        txtStock.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        btnRequestStock.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnRequestStock.setText("Request");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblWelcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 523, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblOrderStockTitle)
                                .addGap(157, 157, 157))
                            .addComponent(txtStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRequestStock, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnBookings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFreeDays, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 701, Short.MAX_VALUE)
                                .addComponent(btnTakeAppointment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnScheduleWeek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(txtSchedule, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRating)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(btnLogout))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRating)
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtSchedule)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSchedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnFreeDays)
                            .addComponent(btnBookings, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblOrderStockTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRequestStock)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTakeAppointment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnScheduleWeek)
                .addGap(58, 58, 58))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnBookings;
    private javax.swing.JToggleButton btnFreeDays;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnRequestStock;
    private javax.swing.JToggleButton btnSchedule;
    private javax.swing.JButton btnScheduleWeek;
    private javax.swing.JButton btnTakeAppointment;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lblOrderStockTitle;
    private javax.swing.JLabel lblRating;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList<String> lstSchedule;
    private javax.swing.JLabel txtSchedule;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}