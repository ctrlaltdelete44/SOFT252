///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package appointments.resultsfactories;
//
//import accounts.Doctor;
//import accounts.Patient;
//import appointments.results.Action;
////import appointments.results.Notes;
//import java.io.Serializable;
//
///**
// * the abstract factory that specifies the information and methods required by
// * the concrete implementations
// *
// * @author davie
// */
//public abstract class zAbstractResultsFactory implements Serializable {
//
//    /**
//     * despite the outcome of the appointment, there will always be notes
//     */
//    //protected Notes notes;
//
//    /**
//     * on creation, notes are required
//     *
//     * @param strNotes - notes made by doctor during consultation
//     */
//    public zAbstractResultsFactory(String strNotes) {
//        //this.notes = new Notes(strNotes);
//    }
//
//    /**
//     * method that associates an action with the factory
//     *
//     * @param a - action to add
//     */
//    public abstract void addAction(Action a);
//
//    /**
//     * abstract method implemented by all concrete factories to add a history
//     * item to the patient
//     *
//     * @param p - the patient to add history to
//     * @param d - the doctor who hosted the appointment
//     */
//    public abstract void addHistory(Patient p, Doctor d);
//}
