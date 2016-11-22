package com.Engine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mitchell.olson.1
 */
public class StandardAppState implements AppState{

    private List<Venue> venues = new ArrayList();
    private List<MenuItem> menuItems = new ArrayList();
    private List<Recommendation> recommendationsList = new ArrayList();
    private UserProfile userProfile = new StandardUserProfile();


    public StandardAppState() {



    }


    @Override
    public List<MenuItem> getListMenuItems() {
        return menuItems;
    }

    @Override
    public void setListOfMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    @Override
    public UserProfile getUserProfile() {
        return userProfile;
    }

    @Override
    public void setUserProfile(UserProfile profile) {
       userProfile = profile;
    }

    @Override
    public List<Venue> getListOfVenues() {
        return venues;
    }

    @Override
    public void setListVenues(List<Venue> venues) {
         this.venues = venues;
    }

    @Override
    public List<Recommendation> getRecommendationsList() {
        return recommendationsList;
    }

    @Override
    public void setRecommendationsList(List<Recommendation> list) {
        recommendationsList = list;
    }

    @Override
    public Date getSystemTime() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sortMenuItems() {
        //
    }

    @Override
    public void sortVenues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void sortMeals() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void exportUserProfileTo(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
