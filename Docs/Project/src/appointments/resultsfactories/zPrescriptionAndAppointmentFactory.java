///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package appointments.resultsfactories;
//
//import accounts.Doctor;
//import accounts.Patient;
//import appointments.results.*;
////import utilities.accounts.HistoryItem;
//
///**
// * concrete factory for when both actions are needed
// *
// * @author davie
// */
//public class zPrescriptionAndAppointmentFactory extends zAbstractResultsFactory {
//
//    private AssignedPrescription assignedPrescription;
//    private FurtherAppointment furtherAppointment;
//
//    /**
//     * the notes made during consultation
//     *
//     * @param strNotes - notes made by doctor during consultation
//     */
//    public zPrescriptionAndAppointmentFactory(String strNotes) {
//        super(strNotes);
//    }
//
//    /**
//     * used twice to add the outcomes of the consultation, with a switch
//     * statement to determine which they are
//     *
//     * @param a - which action is being added
//     */
//    @Override
//    public void addAction(Action a) {
//        switch (a.getActionType()) {
//            case PRESCRIPTION:
//                // System.out.println("Adding prescription:PRESCRIPTIONANDAPPOINTMENT");
//                assignedPrescription = (AssignedPrescription) a;
//                assignedPrescription.processRequest();
//                break;
//            case APPOINTMENT:
//                //System.out.println("Adding appointment:PRESCRIPTIONANDAPPOINTMENT");
//                furtherAppointment = (FurtherAppointment) a;
//                furtherAppointment.processRequest();
//                break;
//        }
//    }
//
//    /**
//     * adds a record of this appointment to the patient's history
//     *
//     * @param p - the patient to add history to
//     * @param d - doctor who hosted consultation
//     */
//    @Override
//    public void addHistory(Patient p, Doctor d) {
//      //  HistoryItem h = new HistoryItem(this.notes, this.assignedPrescription.getPrescription(), d, true);
//   //    p.addHistoryItem(h);
//        p.addNotification("Your appointment has been processed with a prescription and further appointment assigned");
//    }
//
//}
