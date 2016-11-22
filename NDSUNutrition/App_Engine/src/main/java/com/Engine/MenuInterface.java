/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrition.app;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author mitchell.olson.1
 */
public interface MenuInterface extends Serializable{
    public String getName();
    public void serName(String name);
    public double getServingSize();
    public void setServingSize(double serving);
    public String getServingUnit();
    public void setServingUnit(String servingUnit);
    public List<Nutrient> getNutrients();
    public void setNutrients(List<Nutrient> list);
    public String getCategory();
    public void setCategory(String category);
    public String getInfoSource();
    public void setInfoSource(String source);
    public String getVenue();
    public void setVenue(String venue);
    
    @Override
    public String toString();
    
    @Override
    public boolean equals(Object o);
    
}
