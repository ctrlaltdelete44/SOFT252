/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.ArrayList;

/**
 *
 * @author Anthony
 */
public class ListToArrayAdapter {
    public static String[] convert(ArrayList<Object> list) {
        String[] array = new String[list.size()];
        
        for (int i = 0; i < list.size(); i++)
        {
            array[i] = list.get(i).toString();
        }
        
        return array;
    }
}
