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
public class RequestAdapterTest {
    
    public RequestAdapterTest() {
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

    private RequestAdapter invalidPatient;
    private RequestAdapter invalidRequestType;
    private RequestAdapter valid;
    
    @Test
    public void testConvert() {
        invalidPatient = new RequestAdapter("Captain Morgan DELETE");
        invalidRequestType = new RequestAdapter("Thomas Estover EGG");
        valid = new RequestAdapter("Thomas Estover DELETE");
        
        assertEquals(null, invalidPatient.convert());
        assertEquals(null, invalidRequestType.convert());
        assertNotEquals(null, valid.convert());
    }
    
}
