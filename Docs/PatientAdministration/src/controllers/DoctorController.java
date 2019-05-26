/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import accounts.Doctor;
import view.DoctorView;

/**
 *
 * @author Anthony
 */
public class DoctorController extends DashboardController {
    private final DoctorView gui;
    private final Doctor authorisingDoctor;

    public DoctorController(Account authorisingDoctor) {
        this.gui = new DoctorView();
        this.authorisingDoctor = (Doctor)authorisingDoctor;
        
        cleanUi();
        gui.setVisible(true);
    }

    @Override
    public void initialiseEventHandlers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cleanUi() {
        gui.getLstSchedule().setListData(authorisingDoctor.viewEntireSchedule());
        gui.getLblWelcome().setText("Logged in as: " + authorisingDoctor.getFirstName() + " " + authorisingDoctor.getSurname());
        gui.getLblRating().setText("Your rating is: " + authorisingDoctor.getRating());
        gui.getBtnSchedule().setSelected(true);
        gui.getTxtStock().setText("");
        
        authorisingDoctor.getAvailabilityData();
    }
}
