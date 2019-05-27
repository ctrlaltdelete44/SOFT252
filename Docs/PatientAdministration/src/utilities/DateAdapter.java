/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.time.LocalDate;

/**
 * retrieves a localdate from a given string of a set format
 *
 * @author davie
 */
public class DateAdapter implements IConvert {

    private final String strDate;

    /**
     *
     * @param strDate the string to adapt
     */
    public DateAdapter(String strDate) {
        this.strDate = strDate;
    }

    /**
     * the input string is always of a set format, and the convert method
     * gradually breaks it down until it can retrieve the date, month, and year.
     * it then converts this into a local date
     *
     * @return - the localdate retrieved
     */
    @Override
    public LocalDate convert() {
        LocalDate date;

        //strDate format = "DAYOFWEEK, YYYY-MM-DD: BOOKING STATUS"
        String[] splitOne = strDate.split(" ");
        //splitOne format: "DAYOFWEEK," "YYYY-MM-DD:" "BOOKING STATUS"
        String[] splitTwo = splitOne[1].split("-");
        //splitTwo format: "YYYY" "MM" "DD:"

        int year = Integer.parseInt(splitTwo[0]);
        if (year < 2000) {
            return null;
        }

        int month = Integer.parseInt(splitTwo[1]);
        if (month > 12 || month < 0) {
            return null;
        }

        String tens = "" + splitTwo[2].charAt(0);
        String units = "" + splitTwo[2].charAt(1);

        int day = Integer.parseInt(tens + units);
        if (day > 31) {
            return null;
        }

        date = LocalDate.of(year, month, day);
        return date;
    }
}
