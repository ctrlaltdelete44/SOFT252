/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.availability;

/**
 * interface outlining methods for viewing a schedule
 * @author davie
 */
public interface IViewAvailability {

    /**
     *  method for viewing whole schedule
     * @return - the array of strings containing information about dates
     */
    public String[] viewEntireSchedule();

    /**
     * method for viewing only dates with no bookings
     * @return - the array of strings containing information about dates
     */
    public String[] viewFreeDates();

    /**
     * method for viewing only dates with bookings
     * @return - the array of strings containing information about dates
     */
    public String[] viewBookings();
}
