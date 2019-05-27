/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.availability;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import utilities.serialised.AccountSingleton;
//import utilities.serialised.Compilation;

/**
 * a list of dates that a doctor has scheduled
 * @author davie
 */
public class Availability implements Serializable{
    private final ArrayList<AvailableDate> availability;
    private AccountSingleton accounts = AccountSingleton.getOrCreate();
   // private final Compilation c = new Compilation();
    
    private LocalDate lastDate = LocalDate.now();

    /**
     * on creation, will create an empty array list for the dates scheduled by the doctor
     */
    public Availability() {
        availability = new ArrayList<>();
    }

    /**
     * @return - returns the list of dates 
     */
    public ArrayList<AvailableDate> getAvailability() {
        return availability;
    }
    
    /**
     *
     * @return - returns the number of scheduled days the doctor has
     */
    public int getNumberOfAvailableDays()
    {
        return availability.size();
    }
    
    /**
     * removes a given date from the availability
     * @param date - the date to clear
     */
    public void removeDate(LocalDate date)
    {        
        for (AvailableDate ad : availability)
        {
            if (ad.getDate().equals(date))
            {
                availability.remove(ad);
                //System.out.("Removed from availability:AVAILABILITY");
                break;
            }
        }
        accounts.saveChanges();
    }
    
    /**
     * schedules a new week for the doctor. starts from either today's date or
     * the last used date, and will skip weekends
     */
    public void scheduleWeek()
    {
        LocalDate newDay = LocalDate.now();        
        
        for (int i = 0; i < 7; i++)
        {
            //Stops doctors working weekends
            if ((lastDate.plusDays(i).getDayOfWeek() != DayOfWeek.SATURDAY) && (lastDate.plusDays(i).getDayOfWeek() != DayOfWeek.SUNDAY))
            {
                newDay = lastDate.plusDays(i);
                availability.add(new AvailableDate(newDay));
                //System.out.println("Added " + newDay + " to schedule:AVAILABILITY");
            }
        }
        
        lastDate = newDay.plusDays(1);
        
        accounts.saveChanges();
    }
}
