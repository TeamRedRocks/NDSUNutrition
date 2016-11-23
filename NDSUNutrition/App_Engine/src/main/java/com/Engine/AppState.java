/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Engine;

import java.util.List;

/**
 *
 * @author mitchell.olson.1
 */
public interface AppState {
    List<MenuItem> getListMenuItems();
    void setListOfMenuItems(List<MenuItem> menuItems);
    UserProfile getUserProfile();
    void setUserProfile(UserProfile profile);
    List<Venue> getListOfVenues();
    public void setListVenues(List<Venue> venues);
    public List<Recommendation> getRecommendationsList();
    public void setRecommendationsList(List<Recommendation> list);
    public void constructUserProfile();
    public List<MenuItem> constructListOfMenuItems(String venue);
    public List<Recommendation> constructRecommendationsList();
    public List<Venue> constructListVenues();
    //
    public Date getSystemTime();
    public void sortMenuItems();
    public void sortVenues();
    public void sortMeals();
    public void exportUserProfileTo(String filename);
    
    
}
