/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import accounts.Account;
import accounts.Admin;
import java.io.*;
import utilities.accounts.AccountType;

/**
 * a standard serialiser
 * @author Anthony
 */
public class Serialiser implements Serializable {
    private static String docTitle;
    
    /**
     *
     * @param fileName - the document to save data to (data.paa by default)
     */
    public Serialiser(String fileName)
    {
        docTitle = fileName;
    }
    
    /**
     * serialises the given object (a compilation object) to the file
     * @param object - the object to serialise. in this, a compilation
     * @return - returns a boolean on whether the serialisation was successful
     */
    public boolean serialise(Serializable object)
    {
        try
        {
            try (FileOutputStream fileOutput = new FileOutputStream(docTitle))
            {
                try (ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput))
                {        
                    objectOutput.writeObject(object);
        
                    System.out.println("Writing to " + docTitle);       
                }
            }
        
        return true;
        }
        catch (IOException ex)
        {
            //System.out.println("IO Exception - WRITE");
            return false;
        }
    }
    
    /**
     * reads the given file and returns the object. one exception is that
     * if the file could not be found, will initialise the program with the prime
     * admin account
     * @return - returns the object retrieved from the document
     */
    public Serializable deserialise()
    {
        Serializable object = null;
        try
        {
            try (FileInputStream fileInput = new FileInputStream(docTitle)) 
            {
                try (ObjectInputStream objectInput = new ObjectInputStream(fileInput))
                {           
                object = (Serializable) objectInput.readObject();
                System.out.println("Reading from " + docTitle);
                }
            }
        }
        catch (IOException io)
        {
            //System.out.println("IO exception - READ");
            Account prime = new Admin("Anthony", "Davies", "Discworld");
            prime.authorise(AccountType.ADMIN, "admin");
        }
        catch (ClassNotFoundException cl)
        {
            //System.out.println("Class not found exception caught - READ");
        }
        
        return object;
    }
}
