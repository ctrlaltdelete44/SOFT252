/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import utilities.accounts.AccountType;

/**
 *
 * @author davie
 */
public class IdGeneratorTest {
    
    public IdGeneratorTest() {
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
    public void testSetIdNumber() {
    }

    @Test
    public void testGetIdNumber() {
    }
    
    @Test
    public void testGenerateNextId() {
        String pComparison = "P0000";
        String dComparison = "D0001";
        String aComparison = "A0002";
        String sComparison = "S0003";
        
        String pResult = IdGenerator.generateNextId(AccountType.PATIENT);
        String dResult = IdGenerator.generateNextId(AccountType.DOCTOR);
        String aResult = IdGenerator.generateNextId(AccountType.ADMIN);
        String sResult = IdGenerator.generateNextId(AccountType.SECRETARY);
        
        assertEquals(pComparison, pResult);
        assertEquals(dComparison, dResult);
        assertEquals(aComparison, aResult);
        assertEquals(sComparison, sResult);
    }
    
}
