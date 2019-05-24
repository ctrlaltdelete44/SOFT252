/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import accounts.Doctor;
import accounts.Patient;
import appointments.Appointment;
import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author davie
 */
public class AppointmentSingletonTest {
    
    public AppointmentSingletonTest() {
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
    public void testGetOrCreate() {
    }

    private AppointmentSingleton appointments = AppointmentSingleton.getOrCreate();
    
    
    @Test
    public void testRemoveAppointment() {       
        Appointment valid = appointments.getAppointment("D0002", LocalDate.of(2018, Month.DECEMBER, 25));
        
        assertEquals(valid, appointments.removeAppointment(valid));
    }

    @Test
    public void testAddAppointment() {
    }

    @Test
    public void testGetAppointments_0args() {
    }

    @Test
    public void testGetAppointments_String() {
    }

    @Test
    public void testConstruct() {
    }

    @Test
    public void testSetAppointments() {
    }

    @Test
    public void testIsActiveBooking() {
    }

    
    
    @Test
    public void testGetAppointment() {
        LocalDate validDate = LocalDate.of(2018, Month.DECEMBER, 25);
        LocalDate invalidDate = LocalDate.now();
        
        String validId = "D0002";
        String invalidId = "X0202";
        
        assertEquals(null, appointments.getAppointment(invalidId, invalidDate));
        assertEquals(null, appointments.getAppointment(validId, invalidDate));
        assertEquals(null, appointments.getAppointment(invalidId, validDate));
        assertNotEquals(null, appointments.getAppointment(validId, validDate));
    }
    
}
