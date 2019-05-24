/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import accounts.Account;
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
public class AccountAdapterTest {
    
    public AccountAdapterTest() {
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

    private AccountAdapter empty;
    private AccountAdapter invalid;
    private AccountAdapter valid;
    
    
    @Test
    public void testConvert() {
        
        valid = new AccountAdapter("A0000");
        empty = new AccountAdapter("");
        invalid = new AccountAdapter("Egg");
        
        
        assertNotEquals(null, valid.convert());
        assertEquals(null, empty.convert());
        assertEquals(null, invalid.convert());
    }
    
}
