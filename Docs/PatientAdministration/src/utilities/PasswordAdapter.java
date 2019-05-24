/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 * a password field returns the password as an array of characters,
 * whereas most of my program stores them as strings. this converts from the
 * array to the string
 * @author Anthony
 */
public class PasswordAdapter implements IConvert {
    private final char[] arrPassword;
    
    /**
     *
     * @param password - the character array as defined by the password field
     */
    public PasswordAdapter(char[] password)
    {
        arrPassword = password;
    }
    
    /**
     * loops through the given array and adds each character to an empty string
     * @return - returns the password as a string
     */
    @Override
    public String convert()
    {
        String strPassword = "";
        for (char c : arrPassword)
            strPassword += c;
        
        
        return strPassword;
    }
    
}
