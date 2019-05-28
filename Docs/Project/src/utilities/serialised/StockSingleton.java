/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities.serialised;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import medicinecabinet.StockItem;
import utilities.Serialiser;

/**
 * a singleton to track the stock in the medicine cabinet
 *
 * @author davie
 */
public class StockSingleton implements Serializable, ISerialise {

    private ArrayList<StockItem> stock;
    private static StockSingleton instance = null;

    private StockSingleton() {
        //stock = new ArrayList<>();
        //saveChanges();
        loadData();

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
     * will removeObject stock from the cupboard. will check if the item exists,
     * and also if there is enough of it to removeObject
     *
     * @param name - item to removeObject
     * @param quantity - how much is needed
     * @return - returns the item
     */
    public StockItem requestStock(String name, int quantity) {
        //loop through stock
        Iterator it = stock.iterator();
        while (it.hasNext()) {
            StockItem item = (StockItem) it.next();
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
                }
            }

        }
        return null;
    }

    @Override
    public void addObject(Object o) {
        StockItem stockItem = (StockItem) o;
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
    }

    @Override
    public void removeObject(Object o) {
        //unused in placed of dedicated requestStock method
    }

    @Override
    public ArrayList getData() {
        return stock;
    }

    @Override
    public void saveChanges() {
        new Serialiser("data/stock.paa").serialise(stock);
    }

    @Override
    public void loadData() {
        stock = (ArrayList<StockItem>) new Serialiser("data/stock.paa").deserialise();
    }

}
