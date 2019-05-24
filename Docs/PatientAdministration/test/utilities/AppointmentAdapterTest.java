/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

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
public class AppointmentAdapterTest {
    
    public AppointmentAdapterTest() {
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

    private AppointmentAdapter noDoctor;
    private AppointmentAdapter noAppointmentString;
    private AppointmentAdapter invalidDoctor;
    private AppointmentAdapter invalidAppointmentDate;
    private AppointmentAdapter invalidPatient;
    private AppointmentAdapter valid;
    
    
    @Test
    public void testConvert() {
        noDoctor = new AppointmentAdapter("2018-12-21, P0003", "");
        noAppointmentString = new AppointmentAdapter("", "D0002");
        invalidDoctor = new AppointmentAdapter("2018-12-21, P0003", "P0003");
        invalidAppointmentDate = new AppointmentAdapter("12-12-12, P0003", "D0002");
        invalidPatient = new AppointmentAdapter("2018-12-21, Egg", "D0002");
        valid = new AppointmentAdapter("2018-12-21, P0003", "D0002");
        
        assertEquals(null, noDoctor.convert());
        assertEquals(null, noAppointmentString.convert());
        assertEquals(null, invalidDoctor.convert());
        assertEquals(null, invalidAppointmentDate.convert());
        assertEquals(null, invalidPatient.convert());
        assertNotEquals(null, valid.convert());
    }
    
}
