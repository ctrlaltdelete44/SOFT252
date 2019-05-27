/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import java.io.Serializable;
import java.util.ArrayList;
import medicinecabinet.StockItem;
import utilities.Serialiser;

/**
 * a singleton to track the stock in the medicine cabinet
 *
 * @author davie
 */
public class StockSingleton implements Serializable {

    private ArrayList<StockItem> stock;
    private static StockSingleton instance = null;

    //private final Compilation c = new Compilation();
    //private final Serialiser stockSerialiser = new Serialiser("data/stock.paa");
    private StockSingleton() {
        loadData();
       //     stock = new ArrayList<>();
         //   saveChanges();
        
    }

    /**
     * returns the active instance of the singleton
     *
     * @return - returns active instance
     */
    public static StockSingleton getOrCreate() {
        if (instance == null) {
            instance = new StockSingleton();
        }
        return instance;
    }

    /**
     * adds a new item to the medicine cabinet. if the item already exists, will
     * increase it'item quantity. else will create a new item
     *
     * @param stockItem - item to add
     */
    public void addStock(StockItem stockItem) {
        Boolean isAdded = false;
        for (StockItem s : stock) {
            if (s.getName().contentEquals(stockItem.getName())) {
                s.setQuantity(s.getQuantity() + stockItem.getQuantity());
                isAdded = true;
                break;
            }
        }
        if (!isAdded) {
            stock.add(stockItem);
        }

        saveChanges();
        //c.construct();
    }

    /**
     * will remove stock from the cupboard. will check if the item exists, and
     * also if there is enough of it to remove
     *
     * @param name - item to remove
     * @param quantity - how much is needed
     * @return - returns the item
     */
    public StockItem requestStock(String name, int quantity) {
        //loop through stock
        for (StockItem item : stock) {
            //if names =
            if (item.getName().contentEquals(name)) {
                //if qunatity in stock > quantity requested
                if (item.getQuantity() >= quantity) {
                    //subtract quantity in stock
                    item.setQuantity(item.getQuantity() - quantity);
                    if (item.getQuantity() == 0) {
                        stock.remove(item);
                    }
                    saveChanges();
                    return new StockItem(name, quantity);
                    //return new stockItem(name, qunatity)
                }
            }
        }
        return null;
    }

    public void saveChanges() {
        new Serialiser("data/stock.paa").serialise(stock);
    }

    public void loadData() {
        stock = (ArrayList<StockItem>) new Serialiser("data/stock.paa").deserialise();
    }

    /**
     * mutator used in serialisation. breaks singleton principle, but necessary
     *
     * @param newStock - the new list
     */
    public void setStock(ArrayList<StockItem> newStock) {
        stock = newStock;
    }

    /**
     * prints a report on the stock, used for debugging
     */
    public void printStock() {
        //System.out.println("Stock:");
        //for (StockItem item : stock)
        //System.out.println(item.getName() + ":" + item.getQuantity());
    }

    /**
     * standard accessor
     *
     * @return - returns the list of stock
     */
    public ArrayList<StockItem> getStock() {
        //loadData();
        return stock;
    }

}
