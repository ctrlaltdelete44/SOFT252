/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.view;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Anthony
 */
public class PlaceHolderTextListener implements FocusListener {

    private String strPlaceholder;

    public PlaceHolderTextListener(String strPlaceholder) {
        this.strPlaceholder = strPlaceholder;
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField component = (JTextField) e.getComponent();

        if (component.getText().equals(strPlaceholder)) {
            component.setText("");
            component.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField component = (JTextField) e.getComponent();

        if (component.getText().isEmpty()) {
            component.setText(strPlaceholder);
            component.setForeground(Color.GRAY);
        }
    }

}
