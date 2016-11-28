/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Engine;

import java.util.Objects;
import java.io.Serializable;

/**
 *
 * @author mitchell.olson.1
 */
public class MealEntry implements Serializable{

    /**
     * @param args the command line arguments
     */
    //Declare Variables
    MenuItem menuItem = new MenuItem();
    double amount;

    public MealEntry(MenuItem item, double amount) {
        if(item != null)
            menuItem = item;

        if(amount >= 0)
            this.amount = amount;

    }

    public MenuItem getMenuItem(){
        return menuItem;
    }

    public void setMenuItem(MenuItem item){
        this.menuItem = item;
    }
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "MealEntry{" + "menuItem=" + menuItem + ", amount=" + amount + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.menuItem);
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.amount) ^ (Double.doubleToLongBits(this.amount) >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        //
        if(!(obj instanceof MenuItem))
        {
            return false;
        }
        else
        {
            MenuItem o = (MenuItem) obj;

            double compVal = (menuItem.getServingSize()) - (o.getServingSize());
            boolean b1 = Math.abs(compVal) <= 0.000001;
            boolean b2 = menuItem.getCategory().equals(o.getCategory());
            boolean b3 = menuItem.getInfoSource().equals(o.getInfoSource());
            boolean b4 = menuItem.getName().equals(o.getName());
            boolean b5 = menuItem.getServingUnit().equals(o.getServingUnit());
            boolean b6 = menuItem.getVenue().equals(o.getVenue());

            return (b1 && b2 && b3 && b4 && b5 && b6);


        }
    }
}
