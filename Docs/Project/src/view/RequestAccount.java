/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Anthony
 */
public class RequestAccount extends javax.swing.JFrame {

    /**
     * Creates new form RequestAccount
     */
    public RequestAccount() {
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

        txtFirst = new javax.swing.JTextField();
        txtSurname = new javax.swing.JTextField();
        lblSex = new javax.swing.JLabel();
        rdoMale = new javax.swing.JRadioButton();
        rdoFemale = new javax.swing.JRadioButton();
        lblAge = new javax.swing.JLabel();
        spnAge = new javax.swing.JSpinner();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jScrollPane23 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lblAddress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Request Account | PAA");
        setPreferredSize(new java.awt.Dimension(612, 680));
        setSize(new java.awt.Dimension(612, 680));

        txtFirst.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFirst.setForeground(java.awt.Color.gray);
        txtFirst.setText("First Name");

        txtSurname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtSurname.setForeground(java.awt.Color.gray);
        txtSurname.setText("Surname");

        lblSex.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblSex.setText("Sex");

        rdoMale.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdoMale.setSelected(true);
        rdoMale.setText("Male");

        rdoFemale.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdoFemale.setText("Female");

        lblAge.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAge.setText("Age");

        spnAge.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        spnAge.setModel(new javax.swing.SpinnerNumberModel(18, 1, 100, 1));

        btnSubmit.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnSubmit.setText("Request Account");

        btnCancel.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnCancel.setText("Cancel");

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPassword.setText("Password");

        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPassword.setForeground(java.awt.Color.gray);
        txtPassword.setText("Password");

        txtAddress.setColumns(20);
        txtAddress.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtAddress.setForeground(java.awt.Color.gray);
        txtAddress.setLineWrap(true);
        txtAddress.setRows(5);
        jScrollPane23.setViewportView(txtAddress);

        lblAddress.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAddress.setText("Address");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(164, 164, 164)
                                .addComponent(btnSubmit))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(spnAge, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtFirst)
                                    .addComponent(txtSurname)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblAge)
                                .addGap(284, 284, 284))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(rdoMale)
                                        .addGap(31, 31, 31)
                                        .addComponent(rdoFemale))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(69, 69, 69)
                                        .addComponent(lblSex)))
                                .addGap(208, 208, 208))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lblPassword)
                                .addGap(263, 263, 263))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(286, 286, 286)
                .addComponent(lblAddress)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnCancel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(txtFirst, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(txtSurname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblAddress)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblSex)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoMale)
                            .addComponent(rdoFemale))
                        .addGap(18, 18, 18)
                        .addComponent(lblAge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spnAge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSubmit)))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public JButton getBtnCancel() {
        return btnCancel;
    }

    public JButton getBtnSubmit() {
        return btnSubmit;
    }

    public JRadioButton getRdoFemale() {
        return rdoFemale;
    }

    public JRadioButton getRdoMale() {
        return rdoMale;
    }

    public JSpinner getSpnAge() {
        return spnAge;
    }

    public JTextArea getTxtAddress() {
        return txtAddress;
    }

    public JTextField getTxtFirst() {
        return txtFirst;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtSurname() {
        return txtSurname;
    }

    public void addConfirmEventHandler(ActionListener listener) {
        btnSubmit.addActionListener(listener);
    }

    public void addCancelEventHandler(ActionListener listener) {
        btnCancel.addActionListener(listener);
    }

    public void addFirstPlaceholder(FocusListener listener) {
        txtFirst.addFocusListener(listener);
    }

    public void addLastPlaceholder(FocusListener listener) {
        txtSurname.addFocusListener(listener);
    }

    public void addPasswordPlaceholder(FocusListener listener) {
        txtPassword.addFocusListener(listener);
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAge;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSex;
    private javax.swing.JRadioButton rdoFemale;
    private javax.swing.JRadioButton rdoMale;
    private javax.swing.JSpinner spnAge;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextField txtFirst;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSurname;
    // End of variables declaration//GEN-END:variables
}
