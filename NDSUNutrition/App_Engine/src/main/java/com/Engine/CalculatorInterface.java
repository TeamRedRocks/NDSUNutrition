package com.Engine;

import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mitchell.olson.1
 */
public interface CalculatorInterface {
    
    
    public List<Recommendation> getRecommendations(int num, AppState as);
    public List<Date> getListDates(int numDaysPriorToToday);
    public double getPDV(NutrientTotal nutrientTotal, RecommendedDailyAllowance rda);
    public List<NutrientTotal> getNutrientTotals(Date fromDate, Date toDate, UserProfile userProfile);
    
}
