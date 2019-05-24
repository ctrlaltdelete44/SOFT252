/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

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
public class DateAdapterTest {
    
    public DateAdapterTest() {
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

    DateAdapter invalidDateFormat;
    DateAdapter invalidDate;
    DateAdapter valid;
    
    @Test
    public void testConvert() {
        //strDate format = "DAYOFWEEK, YYYY-MM-DD: BOOKING STATUS"
        invalidDateFormat = new DateAdapter("MONDAY, 17-12-2018: STATUS");
        invalidDate = new DateAdapter("MONDAY, 2018-51-90: STATUS");
        valid = new DateAdapter("MONDAY, 2018-12-17: STATUS");
        
        LocalDate validResult = LocalDate.of(2018, Month.DECEMBER, 17);
        
        assertEquals(null, invalidDateFormat.convert());
        assertEquals(null, invalidDate.convert());
        assertEquals(validResult, valid.convert());
    }
    
}
