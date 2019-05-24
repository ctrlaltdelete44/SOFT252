/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import java.io.Serializable;
import java.util.ArrayList;
import medicinecabinet.StockItem;

/**
 * a singleton to track the stock in the medicine cabinet
 * @author davie
 */
public class StockSingleton implements Serializable {
    private ArrayList<StockItem> stock;
    private static StockSingleton instance = null;
    
    private final Compilation c = new Compilation();
    
    private StockSingleton()
    {
        stock = new ArrayList<>();
    }
    
    /**
     * returns the active instance of the singleton
     * @return - returns active instance
     */
    public static StockSingleton getOrCreate()
    {
        if (instance == null)
            instance = new StockSingleton();
        return instance;
    }
    
    /**
     * adds a new item to the medicine cabinet. if the item already exists,
     * will increase it's quantity. else will create a new item
     * @param stockItem - item to add
     */
    public void addStock(StockItem stockItem)
    {
        Boolean isAdded = false;
        for (StockItem s : stock)
        {
            if (s.getName().contentEquals(stockItem.getName()))
            {
                s.setQuantity(s.getQuantity() + stockItem.getQuantity());
                isAdded = true;
                break;
            }
        }
        if (!isAdded)
            stock.add(stockItem);
        
        c.construct();
    }
    
    /**
     * will remove stock from the cupboard. will check if the item exists,
     * and also if there is enough of it to remove
     * @param name - item to remove
     * @param quantity - how much is needed
     * @return - returns the item
     */
    public StockItem requestStock(String name, int quantity)
    {      
        //loop through stock
        for (StockItem s : stock)
        {
        //if names =
            if (s.getName().contentEquals(name))
            {
            //if qunatity in stock > quantity requested
                if (s.getQuantity() >= quantity)
                {
                //subtract quantity in stock
                    s.setQuantity(s.getQuantity() - quantity);
                    if (s.getQuantity() == 0)
                        stock.remove(s);
                    c.construct();
                    return new StockItem(name, quantity);
                //return new stockItem(name, qunatity)
                }
            }
        }
        return null;
    }
    
    /**
     * mutator used in serialisation. breaks singleton principle, but necessary
     * @param newStock - the new list
     */
    public void setStock(ArrayList<StockItem> newStock)
    {
        stock = newStock;
    }
    
    /**
     * prints a report on the stock, used for debugging
     */
    public void printStock()
    {
        //System.out.println("Stock:");
        //for (StockItem s : stock)
            //System.out.println(s.getName() + ":" + s.getQuantity());
    }

    /**
     * standard accessor
     * @return - returns the list of stock
     */
    public ArrayList<StockItem> getStock() {
        return stock;
    }
    
    
}
