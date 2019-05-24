/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

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
public class ControllerTest {
    
    public ControllerTest() {
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

    @Test
    public void testViewAccounts() {
    }

    Controller controller = Controller.getOrCreate();
    
    @Test
    public void testLogin() {
        String validUsername = "A0000";
        String invalidUsername = ":(";
        
        char[] validPassword = new char[5];
        validPassword[0] = 'a'; validPassword[1] = 'd'; validPassword[2] = 'm'; validPassword[3] = 'i'; validPassword[4] = 'n';
        
        char[] invalidPassword = new char[5];
        
        assertEquals(null, controller.login(invalidUsername, invalidPassword));
        assertEquals(null, controller.login(validUsername, invalidPassword));
        assertEquals(null, controller.login(invalidUsername, validPassword));
        assertEquals(AccountType.ADMIN, controller.login(validUsername, validPassword));
        
    }

    @Test
    public void testLogout() {
    }

    @Test
    public void testGetLoggedIn() {
    }

    @Test
    public void testGetNotifications() {
    }
    
}
