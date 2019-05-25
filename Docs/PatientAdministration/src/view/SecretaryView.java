/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Anthony
 */
public class SecretaryView extends javax.swing.JFrame {

    /**
     * Creates new form Secretary
     */
    public SecretaryView() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lstRequests = new javax.swing.JList<>();
        lblRequests = new javax.swing.JLabel();
        btnDeleteRequest = new javax.swing.JButton();
        btnConfirmRequest = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        lstStock = new javax.swing.JList<>();
        lblStock = new javax.swing.JLabel();
        txtStockName = new javax.swing.JTextField();
        lblStockItemName = new javax.swing.JLabel();
        lblQuantity = new javax.swing.JLabel();
        spnQuantity = new javax.swing.JSpinner();
        btnAddStock = new javax.swing.JButton();
        lblPatients = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstPatients = new javax.swing.JList<>();
        btnDeleteAccount = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Secretary Dashboard | PAA");

        lblWelcome.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblWelcome.setText("Welcome");

        btnLogout.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnLogout.setText("Log Out");

        lstRequests.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lstRequests.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(lstRequests);

        lblRequests.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblRequests.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRequests.setText("Active Requests");

        btnDeleteRequest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDeleteRequest.setText("Delete Request");

        btnConfirmRequest.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnConfirmRequest.setText("Confirm Request");

        lstStock.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lstStock.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane5.setViewportView(lstStock);

        lblStock.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblStock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStock.setText("Stock");

        txtStockName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        lblStockItemName.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblStockItemName.setText("Item Name");

        lblQuantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblQuantity.setText("Quantity");

        spnQuantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        btnAddStock.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnAddStock.setText("Replenish Stock");

        lblPatients.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPatients.setText("Patient Accounts");

        lstPatients.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lstPatients.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane6.setViewportView(lstPatients);

        btnDeleteAccount.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnDeleteAccount.setText("Delete Selected Account");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblWelcome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnLogout)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane6)
                            .addComponent(lblPatients)
                            .addComponent(btnDeleteAccount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblStockItemName)
                                        .addGap(0, 990, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtStockName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblQuantity)
                                        .addGap(152, 152, 152))
                                    .addComponent(spnQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnDeleteRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnConfirmRequest, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(lblStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblRequests, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAddStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblWelcome)
                    .addComponent(btnLogout))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPatients)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblRequests)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDeleteRequest)
                            .addComponent(btnConfirmRequest))
                        .addGap(25, 25, 25)
                        .addComponent(lblStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStockItemName)
                            .addComponent(lblQuantity))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtStockName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddStock)
                    .addComponent(btnDeleteAccount))
                .addGap(100, 100, 100))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnAddStock() {
        return btnAddStock;
    }

    public JButton getBtnConfirmRequest() {
        return btnConfirmRequest;
    }

    public JButton getBtnDeleteAccount() {
        return btnDeleteAccount;
    }

    public JButton getBtnDeleteRequest() {
        return btnDeleteRequest;
    }

    public JList<String> getLstPatients() {
        return lstPatients;
    }

    public JList<String> getLstRequests() {
        return lstRequests;
    }

    public JList<String> getLstStock() {
        return lstStock;
    }

    public JSpinner getSpnQuantity() {
        return spnQuantity;
    }

    public JTextField getTxtStockName() {
        return txtStockName;
    }

    public JLabel getLblWelcome() {
        return lblWelcome;
    }

    public void addLogoutEventHandler(ActionListener listener) {
        btnLogout.addActionListener(listener);
    }
    
    public void addDeleteRequestEventHandler(ActionListener listener) {
        btnDeleteRequest.addActionListener(listener);
    }
    
    public void addDeleteAccountEventHandler(ActionListener listener) {
        btnDeleteAccount.addActionListener(listener);
    }
    
    public void addConfirmRequestEventHandler(ActionListener listener) {
        btnConfirmRequest.addActionListener(listener);
    }
    
    public void addAddStockListener(ActionListener listener) {
        btnAddStock.addActionListener(listener);
    }
//        
    public void addRequestsChangedListener(ListSelectionListener listener) {
        lstRequests.addListSelectionListener(listener);
    }
    
    public void addStockChangedListener(ListSelectionListener listener) {
        lstStock.addListSelectionListener(listener);
    }
    
    public void addPatientsChangedListener(ListSelectionListener listener) {
        lstPatients.addListSelectionListener(listener);
    }
   
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStock;
    private javax.swing.JButton btnConfirmRequest;
    private javax.swing.JButton btnDeleteAccount;
    private javax.swing.JButton btnDeleteRequest;
    private javax.swing.JButton btnLogout;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lblPatients;
    private javax.swing.JLabel lblQuantity;
    private javax.swing.JLabel lblRequests;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblStockItemName;
    private javax.swing.JLabel lblWelcome;
    private javax.swing.JList<String> lstPatients;
    private javax.swing.JList<String> lstRequests;
    private javax.swing.JList<String> lstStock;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTextField txtStockName;
    // End of variables declaration//GEN-END:variables
}
