/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 * an interface for converting, used by all adapters
 *
 * @author Anthony
 */
public interface IConvert {

    /**
     * the abstract method of convert, implemented by all adapters
     *
     * @return - returns an object based on which adapter is used
     */
    public abstract Object convert();
}
