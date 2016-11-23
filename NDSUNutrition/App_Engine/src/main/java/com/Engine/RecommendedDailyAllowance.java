/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Engine;

import java.util.List;

/**
 * @author mitchell.olson.1
 */
public interface RecommendedDailyAllowance{
    
    public List<NutrientTotal> getAdjustedRDA(int calories);

    public int getProteinLevel();
    public int getCalciumLevel();
    public int getPotassiumLevel();
    public int getFatLevel();
    public int getCholesterolLevel();
    public int getSaturatedFatLevel();
    public int getSugarLevel();
    public int getCaloriesLevel();
    public int getCarbohydrateLevel();
    public int getSodiumLevel();
    
    
    
    @Override
    public String toString();

    @Override
    public boolean equals(Object o);
    
}
