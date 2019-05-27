/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import java.util.ArrayList;

/**
 *
 * @author Anthony
 */
public interface ISerialise {
    public void addObject(Object o);
    public void removeObject(Object o);
    public ArrayList getData();
    public void saveChanges();
    public void loadData();
}
