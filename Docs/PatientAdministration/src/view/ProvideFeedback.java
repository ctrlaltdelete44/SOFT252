/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JTextArea;

/**
 *
 * @author Anthony
 */
public class ProvideFeedback extends javax.swing.JFrame {

    /**
     * Creates new form Feedback
     */
    public ProvideFeedback() {
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

        sldRating = new javax.swing.JSlider();
        lblRating = new javax.swing.JLabel();
        lblComments = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComments = new javax.swing.JTextArea();
        btnSubmit = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Feedback | PAA");

        sldRating.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        sldRating.setMajorTickSpacing(1);
        sldRating.setMaximum(5);
        sldRating.setMinorTickSpacing(1);
        sldRating.setPaintLabels(true);
        sldRating.setPaintTicks(true);
        sldRating.setSnapToTicks(true);
        sldRating.setValue(0);

        lblRating.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblRating.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRating.setText("Rating /5");

        lblComments.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblComments.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblComments.setText("Additional Comments");

        txtComments.setColumns(20);
        txtComments.setFont(new java.awt.Font("Monospaced", 0, 17)); // NOI18N
        txtComments.setLineWrap(true);
        txtComments.setRows(5);
        jScrollPane3.setViewportView(txtComments);

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSubmit.setText("Submit Feedback");

        btnBack.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnBack.setText("Back");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addContainerGap(632, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblComments, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(sldRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblRating, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addComponent(btnSubmit)))
                        .addGap(146, 146, 146))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBack)
                .addGap(57, 57, 57)
                .addComponent(lblRating)
                .addGap(18, 18, 18)
                .addComponent(sldRating, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(lblComments)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSubmit)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnBack() {
        return btnBack;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public JSlider getSldRating() {
        return sldRating;
    }

    public JTextArea getTxtComments() {
        return txtComments;
    }

    public void addBackEventHandler(ActionListener listener) {
        btnBack.addActionListener(listener);
    }

    public void addSubmitEventHandler(ActionListener listener) {
        btnSubmit.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblComments;
    private javax.swing.JLabel lblRating;
    private javax.swing.JSlider sldRating;
    private javax.swing.JTextArea txtComments;
    // End of variables declaration//GEN-END:variables
}
