/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Anthony
 */
public class ViewAvailability extends javax.swing.JFrame {

    /**
     * Creates new form ViewAvailability
     */
    public ViewAvailability() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane9 = new javax.swing.JScrollPane();
        lstSchedule = new javax.swing.JList<>();
        btnAssign = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        lstDoctors = new javax.swing.JList<>();
        lblTitle = new javax.swing.JLabel();
        lblRequest = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View Availability | PAA");

        lstSchedule.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lstSchedule.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane9.setViewportView(lstSchedule);

        btnAssign.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAssign.setText("Assign Appointment");

        lstDoctors.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lstDoctors.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstDoctors.setToolTipText("");
        jScrollPane10.setViewportView(lstDoctors);

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Request");

        lblRequest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblRequest.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRequest.setText("Request");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 462, Short.MAX_VALUE)
                    .addComponent(jScrollPane9)
                    .addComponent(lblRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAssign, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(lblRequest)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAssign)
                .addGap(51, 51, 51))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnAssign() {
        return btnAssign;
    }

    public JLabel getLblRequest() {
        return lblRequest;
    }

    public JList<String> getLstDoctors() {
        return lstDoctors;
    }

    public JList<String> getLstSchedule() {
        return lstSchedule;
    }

    public void addSubmitEventHandler(ActionListener listener) {
        btnAssign.addActionListener(listener);
    }

    public void addDoctorsChangedListener(ListSelectionListener listener) {
        lstDoctors.addListSelectionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAssign;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lblRequest;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JList<String> lstDoctors;
    private javax.swing.JList<String> lstSchedule;
    // End of variables declaration//GEN-END:variables
}
