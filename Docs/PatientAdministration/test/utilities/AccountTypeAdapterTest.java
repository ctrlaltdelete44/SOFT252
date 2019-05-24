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
import utilities.accounts.AccountType;

/**
 *
 * @author davie
 */
public class AccountTypeAdapterTest {
    
    public AccountTypeAdapterTest() {
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

    private AccountTypeAdapter empty;
    private AccountTypeAdapter valid;
    private AccountTypeAdapter invalid;
    
    @Test
    public void testConvert() {
        empty = new AccountTypeAdapter("");
        valid = new AccountTypeAdapter("Secretary");
        invalid = new AccountTypeAdapter("Egg");
        
        assertEquals(null, empty.convert());
        assertEquals(AccountType.SECRETARY, valid.convert());
        assertEquals(null, invalid.convert());
    }
    
}
