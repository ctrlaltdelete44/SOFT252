/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts;

import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import utilities.accounts.Feedback;

/**
 *
 * @author davie
 */
public class DoctorTest {
    
    public DoctorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testGetAccountType() {
    }
    
    private Doctor zero = new Doctor("Doctor", "Test One", "Discworld");
    private Doctor twoFive = new Doctor("Doctor", "Test Two", "Discworld");
    private Doctor five = new Doctor("Doctor", "Test Three", "Discworld");

    @Test
    public void testProvideFeedback() {
        Feedback fbZero = new Feedback(0, "String");
        Feedback fbFive = new Feedback(5, "String");
        
        assertEquals(0.0, zero.provideFeedback(fbZero), 0.1);
        assertEquals(5.0, five.provideFeedback(fbFive), 0.1);
        
        twoFive.provideFeedback(fbZero);
        
        assertEquals(2.5, twoFive.provideFeedback(fbFive), 0.1);
    }

    @Test
    public void testViewFeedback() {
    }

    @Test
    public void testGetRating() {
    }

    @Test
    public void testBookDate() {
    }

    @Test
    public void testViewEntireSchedule() {
    }

    @Test
    public void testViewFreeDates() {
    }

    @Test
    public void testViewBookings() {
    }

    @Test
    public void testBothActionsRequired() {
    }

    @Test
    public void testJustPrescriptionRequired() {
    }

    @Test
    public void testJustAppointmentRequired() {
    }

    @Test
    public void testNoActionRequired() {
    }

    @Test
    public void testClearDate() {
    }

    @Test
    public void testRemoveAppointment() {
    }

    @Test
    public void testGetAvailabilityData() {
    }

    @Test
    public void testScheduleWeek() {
    }

    @Test
    public void testViewAccount() {
    }

    @Test
    public void testCreateStockRequest() {
    }
    
}
