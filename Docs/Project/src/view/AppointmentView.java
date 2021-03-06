/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Anthony
 */
public class AppointmentView extends javax.swing.JFrame {

    /**
     * Creates new form AppointmentView
     */
    public AppointmentView() {
        initComponents();
    }

    public JLabel getLblDosageTitle() {
        return lblDosageTitle;
    }

    public JLabel getLblAppointmentTitle() {
        return lblAppointmentTitle;
    }

    public JLabel getLblNextAppointmentTitle() {
        return lblNextAppointmentTitle;
    }

    public JLabel getLblPrescriptionTitle() {
        return lblPrescriptionTitle;
    }

    public JButton getBtnProcessAppointment() {
        return btnProcessAppointment;
    }

    public JCheckBox getChkAppointment() {
        return chkAppointment;
    }

    public JCheckBox getChkPrescription() {
        return chkPrescription;
    }

    public JLabel getLblDoctor() {
        return lblDoctor;
    }

    public JLabel getLblPatient() {
        return lblPatient;
    }

    public JList<String> getLstHistory() {
        return lstHistory;
    }

    public JRadioButton getRdoDays() {
        return rdoDays;
    }

    public JRadioButton getRdoMonths() {
        return rdoMonths;
    }

    public JRadioButton getRdoYears() {
        return rdoYears;
    }

    public JSpinner getSpnDate() {
        return spnDate;
    }

    public JSpinner getSpnQuantity() {
        return spnQuantity;
    }

    public JTextField getTxtMedicine() {
        return txtMedicine;
    }

    public JTextArea getTxtNotes() {
        return txtNotes;
    }

    public JTextArea getTxtPrescriptionGuide() {
        return txtPrescriptionGuide;
    }

    public void addAppointmentChangedEventHandler(ActionListener listener) {
        chkAppointment.addActionListener(listener);
    }

    public void addPrescriptionChangedEventHandler(ActionListener listener) {
        chkPrescription.addActionListener(listener);
    }

    public void addSubmitEventHandler(ActionListener listener) {
        btnProcessAppointment.addActionListener(listener);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpAppointment = new javax.swing.ButtonGroup();
        lblPatientTitle = new javax.swing.JLabel();
        lblPatient = new javax.swing.JLabel();
        lblDoctorTitle = new javax.swing.JLabel();
        lblDoctor = new javax.swing.JLabel();
        jScrollPane12 = new javax.swing.JScrollPane();
        txtNotes = new javax.swing.JTextArea();
        lblNotesTitle = new javax.swing.JLabel();
        chkPrescription = new javax.swing.JCheckBox();
        chkAppointment = new javax.swing.JCheckBox();
        lblPrescriptionTitle = new javax.swing.JLabel();
        txtMedicine = new javax.swing.JTextField();
        spnQuantity = new javax.swing.JSpinner();
        lblAppointmentTitle = new javax.swing.JLabel();
        spnDate = new javax.swing.JSpinner();
        lblNextAppointmentTitle = new javax.swing.JLabel();
        rdoDays = new javax.swing.JRadioButton();
        rdoMonths = new javax.swing.JRadioButton();
        rdoYears = new javax.swing.JRadioButton();
        btnProcessAppointment = new javax.swing.JButton();
        jScrollPane14 = new javax.swing.JScrollPane();
        lstHistory = new javax.swing.JList<>();
        lblHistoryTitle = new javax.swing.JLabel();
        jScrollPane15 = new javax.swing.JScrollPane();
        txtPrescriptionGuide = new javax.swing.JTextArea();
        lblDosageTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Appointment | PAA");

        lblPatientTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPatientTitle.setText("Patient:");

        lblPatient.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPatient.setText("NAME");

        lblDoctorTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblDoctorTitle.setText("Doctor:");

        lblDoctor.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblDoctor.setText("NAME");

        txtNotes.setColumns(20);
        txtNotes.setFont(new java.awt.Font("Monospaced", 0, 17)); // NOI18N
        txtNotes.setRows(5);
        txtNotes.setWrapStyleWord(true);
        jScrollPane12.setViewportView(txtNotes);
        txtNotes.setLineWrap(true);

        lblNotesTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNotesTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNotesTitle.setText("Notes");

        chkPrescription.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chkPrescription.setText("Prescripton Needed");

        chkAppointment.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        chkAppointment.setText("Further Appointment Needed");

        lblPrescriptionTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblPrescriptionTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPrescriptionTitle.setText("Prescription");
        lblPrescriptionTitle.setEnabled(false);

        txtMedicine.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtMedicine.setEnabled(false);

        spnQuantity.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        spnQuantity.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnQuantity.setEnabled(false);

        lblAppointmentTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblAppointmentTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblAppointmentTitle.setText("Appointment Date");
        lblAppointmentTitle.setEnabled(false);

        spnDate.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        spnDate.setModel(new javax.swing.SpinnerNumberModel(1, 1, null, 1));
        spnDate.setEnabled(false);

        lblNextAppointmentTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblNextAppointmentTitle.setText("Next appointment in");
        lblNextAppointmentTitle.setEnabled(false);

        grpAppointment.add(rdoDays);
        rdoDays.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdoDays.setSelected(true);
        rdoDays.setText("Days");
        rdoDays.setEnabled(false);

        grpAppointment.add(rdoMonths);
        rdoMonths.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdoMonths.setText("Months");
        rdoMonths.setEnabled(false);

        grpAppointment.add(rdoYears);
        rdoYears.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        rdoYears.setText("Years");
        rdoYears.setEnabled(false);

        btnProcessAppointment.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        btnProcessAppointment.setText("Process Appointment");

        lstHistory.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lstHistory.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane14.setViewportView(lstHistory);

        lblHistoryTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblHistoryTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHistoryTitle.setText("Patient History");

        txtPrescriptionGuide.setColumns(20);
        txtPrescriptionGuide.setFont(new java.awt.Font("Monospaced", 0, 17)); // NOI18N
        txtPrescriptionGuide.setLineWrap(true);
        txtPrescriptionGuide.setRows(3);
        txtPrescriptionGuide.setEnabled(false);
        jScrollPane15.setViewportView(txtPrescriptionGuide);

        lblDosageTitle.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        lblDosageTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDosageTitle.setText("Dosage Guidelines");
        lblDosageTitle.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblHistoryTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 732, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(267, 267, 267)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDoctorTitle)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblDoctor))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblPatientTitle)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblPatient))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(296, 296, 296)
                                .addComponent(btnProcessAppointment, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(168, 168, 168))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(132, 132, 132)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                                        .addComponent(lblNotesTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(chkPrescription, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(chkAppointment)
                                            .addGap(129, 129, 129)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(txtMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(lblPrescriptionTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lblDosageTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jScrollPane15, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE))))
                                        .addGap(137, 137, 137)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblNextAppointmentTitle)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(spnDate, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(rdoMonths)
                                                    .addComponent(rdoDays)
                                                    .addComponent(rdoYears)))
                                            .addComponent(lblAppointmentTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addContainerGap(132, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPatientTitle)
                    .addComponent(lblPatient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoctorTitle)
                    .addComponent(lblDoctor))
                .addGap(18, 18, 18)
                .addComponent(lblNotesTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkPrescription)
                    .addComponent(chkAppointment))
                .addGap(28, 28, 28)
                .addComponent(lblPrescriptionTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spnQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMedicine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(lblDosageTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblAppointmentTitle)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rdoDays)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoMonths)
                            .addComponent(spnDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNextAppointmentTitle))
                        .addGap(18, 18, 18)
                        .addComponent(rdoYears)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblHistoryTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnProcessAppointment)
                .addGap(152, 152, 152))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcessAppointment;
    private javax.swing.JCheckBox chkAppointment;
    private javax.swing.JCheckBox chkPrescription;
    private javax.swing.ButtonGroup grpAppointment;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JLabel lblAppointmentTitle;
    private javax.swing.JLabel lblDoctor;
    private javax.swing.JLabel lblDoctorTitle;
    private javax.swing.JLabel lblDosageTitle;
    private javax.swing.JLabel lblHistoryTitle;
    private javax.swing.JLabel lblNextAppointmentTitle;
    private javax.swing.JLabel lblNotesTitle;
    private javax.swing.JLabel lblPatient;
    private javax.swing.JLabel lblPatientTitle;
    private javax.swing.JLabel lblPrescriptionTitle;
    private javax.swing.JList<String> lstHistory;
    private javax.swing.JRadioButton rdoDays;
    private javax.swing.JRadioButton rdoMonths;
    private javax.swing.JRadioButton rdoYears;
    private javax.swing.JSpinner spnDate;
    private javax.swing.JSpinner spnQuantity;
    private javax.swing.JTextField txtMedicine;
    private javax.swing.JTextArea txtNotes;
    private javax.swing.JTextArea txtPrescriptionGuide;
    // End of variables declaration//GEN-END:variables
}
