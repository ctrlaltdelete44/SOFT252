/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author Anthony
 */
public abstract class DashboardController implements IController {
    
    protected class btnLogoutListener implements ActionListener {
        private final JFrame gui;

        public btnLogoutListener(JFrame gui) {
            this.gui = gui;
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            gui.dispose();
            new LoginController();
        }

    }
}
