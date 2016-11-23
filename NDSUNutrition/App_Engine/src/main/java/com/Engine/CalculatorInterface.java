package com.Engine;

import java.util.List;

/*
`*
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
