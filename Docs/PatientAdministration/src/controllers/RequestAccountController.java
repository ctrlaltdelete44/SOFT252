/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import view.RequestAccount;

/**
 *
 * @author Anthony
 */
public class RequestAccountController {
    private final RequestAccount gui;

    public RequestAccountController() {
        this.gui = new RequestAccount();
        
        
        gui.setVisible(true);
    }
    
}


//String first; String last; String address;
//        String sex; int age; char[] password;
//
//        first = txtFirst.getText();
//        last = txtSurname.getText();
//        address = txtAddress.getText();
//
//        if (rdoMale.isEnabled())
//        sex = "M";
//        else
//        sex = "F";
//
//        age = (int)spnAge.getValue();
//        password = txtPassword.getPassword();
//        patientController.requestCreation(first, last, address, sex, age, password);
//
//        JOptionPane.showMessageDialog(null, "We have received your request. Once it has been approved, you will be able to log in", "Request processed", JOptionPane.INFORMATION_MESSAGE);