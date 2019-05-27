/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import accounts.Account;
import accounts.Doctor;
import appointments.Appointment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import utilities.AppointmentAdapter;
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
        this.authorisingDoctor = (Doctor) authorisingDoctor;

        initialiseEventHandlers();

        cleanUi();
        gui.setVisible(true);

        viewNotifications();
    }

    @Override
    public void initialiseEventHandlers() {
        gui.addLogoutEventHandler(new btnLogoutListener(gui));
        gui.addRequestStockEventHandler(new btnRequestStockListener());
        gui.addScheduleWeekEventHandler(new btnScheduleWeekListener());
        gui.addFilterByEventHandlers(new btnFiltersListener());
        gui.addTakeAppointmentEventHandler(new btnTakeAppointmentListener());

        gui.addUpdatePageEventHandler(new refreshPageListener());
    }

    @Override
    public void cleanUi() {
        gui.getLblWelcome().setText("Logged in as: " + authorisingDoctor.getFirstName() + " " + authorisingDoctor.getSurname());
        gui.getLblRating().setText("Your rating is: " + authorisingDoctor.getRating());
        gui.getTxtStock().setText("");
        viewSchedule();
    }

    @Override
    public String[] viewNotifications() {
        return authorisingDoctor.getNotifications();
    }

    private void viewSchedule() {
        if (gui.getBtnSchedule().isSelected()) {
            gui.getLstSchedule().setListData(authorisingDoctor.viewEntireSchedule());
        } else if (gui.getBtnBookings().isSelected()) {
            gui.getLstSchedule().setListData(authorisingDoctor.viewBookings());
        } else if (gui.getBtnFreeDays().isSelected()) {
            gui.getLstSchedule().setListData(authorisingDoctor.viewFreeDates());
        }
    }

    private class btnRequestStockListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String medicineRequested = gui.getTxtStock().getText();

            if (medicineRequested.contentEquals("")) {
                JOptionPane.showMessageDialog(null, "Please specify what medicine you wish to order", "Invalid request", JOptionPane.OK_OPTION);
            } else {
                authorisingDoctor.createStockRequest(medicineRequested);
                JOptionPane.showMessageDialog(null, "Your request has been submitted", "Request submitted", JOptionPane.OK_OPTION);
            }
        }
    }

    private class btnScheduleWeekListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            authorisingDoctor.scheduleWeek();
            viewSchedule();
        }
    }

    private class btnFiltersListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewSchedule();
        }
    }

    private class btnTakeAppointmentListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String selected = gui.getLstSchedule().getSelectedValue();

            if (selected == null) {
                JOptionPane.showMessageDialog(null, "You have not selected a booking to take", "No appointment", JOptionPane.OK_OPTION);
            } else if (selected.contains("No booking")) {
                JOptionPane.showMessageDialog(null, "You have no booking on this day!", "No appointment", JOptionPane.OK_OPTION);
            } else {
                AppointmentAdapter adapter = new AppointmentAdapter(selected, authorisingDoctor.getUniqueId());
                Appointment activeAppointment = adapter.convert();
                new AppointmentController(authorisingDoctor, activeAppointment);
            }
        }

    }
}
