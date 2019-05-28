/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.accounts;

import java.io.Serializable;

/**
 * an item of feedback as made by a patient referring to a doctor
 *
 * @author davie
 */
public class Feedback implements Serializable {

    private final int rating;
    private final String comments;

    /**
     *
     * @param rating - a rating out of five given by the patient
     * @param comments - any comments the patient has made
     */
    public Feedback(int rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    /**
     * standard accessor
     *
     * @return - the rating out of 5 associated with this feedback
     */
    public int getRating() {
        return rating;
    }

    /**
     * standard accessor
     *
     * @return - any comments associated with this feedback
     */
    public String getComments() {
        return comments;
    }
    
    @Override
    public String toString() {
        return rating+ "/5. " + comments;
    }

}
