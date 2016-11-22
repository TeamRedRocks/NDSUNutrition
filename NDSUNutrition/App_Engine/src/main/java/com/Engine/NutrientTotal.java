package com.Engine;



import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author donovan.beckmann
 */
public class NutrientTotal implements Serializable {
    private Nutrient nutrient;
    private double amount;


    public NutrientTotal(Nutrient nutrient, double amount) {
        this.nutrient = nutrient;
        this.amount = amount;
    }

    public Nutrient getNutrient() {
        return nutrient;
    }
    public void setNutrient(Nutrient n) {
        this.nutrient = n;
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double d) {
        this.amount = d;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (!(o instanceof NutrientTotal)) return false;

        NutrientTotal that = (NutrientTotal) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        return nutrient != null ? nutrient.equals(that.nutrient) : that.nutrient == null;

    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "NutrientTotal{" + "nutrient=" + nutrient + ", amount=" + amount + '}';
    }


}