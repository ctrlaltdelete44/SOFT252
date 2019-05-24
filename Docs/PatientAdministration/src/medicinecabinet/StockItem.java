/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package medicinecabinet;

import java.io.Serializable;

/**
 * a class containing information about a given medicine in stock
 * @author davie
 */
public class StockItem implements Serializable{
    private final String name;
    private int quantity;

    /**
     * 
     * @param name - name of the medicine
     * @param quantity - how much of said medicine is in stock
     */
    public StockItem(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    /**
     * standard accessor
     * @return - name of the medicine
     */
    public String getName() {
        return name;
    }

    /**
     * standard accessor
     * @return - quantity in stock
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * standard mutator
     * @param quantity - setting the new quantity of an item
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
