package com.Engine;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author mitchell.olson.1
 */
public class StandardAppState implements AppState, Serializable{

    private List<Venue> venues = new ArrayList();
    private List<MenuItem> menuItems = new ArrayList();
    private List<Recommendation> recommendationsList = new ArrayList();
    private UserProfile userProfile = new StandardUserProfile();


    public StandardAppState() {



    }

    private List<MealEntry> mealEntries = new ArrayList();
    @Override
    public void sortMenuItems() {

        //java.util.Collections.sort(menuItems, Collator.getInstance());
        if (!menuItems.isEmpty()) {
            Collections.sort(menuItems, new Comparator<MenuItem>() {

                public int compare(MenuItem item1, MenuItem item2) {

                    return item1.getName().compareTo(item2.getName());
                }

            });
        }
    }

    @Override
    public void sortVenues() {
        if (!venues.isEmpty()) {
            Collections.sort(venues, new Comparator<Venue>() {

                public int compare(Venue venue1, Venue venue2) {

                    return venue1.getName().compareTo(venue2.getName());
                }

            });
        }
    }

    @Override
    public void sortMeals() {
        if (!mealEntries.isEmpty()) {
            Collections.sort(mealEntries, new Comparator<MealEntry>() {

                public int compare(MealEntry mealEntry1, MealEntry mealEntry2) {
                    return mealEntry1.getMenuItem().getName().compareTo(mealEntry2.getMenuItem().getName());
                }

            });
        }

    }

    //@Override
    public int compare(Object o, Object t1) {
        return 0;
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
    public void setListVenues(List<Venue> venues) {this.venues = venues;}

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
    public void exportUserProfileTo(String filename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void constructUserProfile() {
         StandardUserProfile stp = new StandardUserProfile();
    }

    @Override
    public List<MenuItem> constructListOfMenuItems(String venue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Recommendation> constructRecommendationsList() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Venue> constructListVenues() {
        List<Venue> venueList = new ArrayList<>();
        try {
            String sURL = "http://rin.cs.ndsu.nodak.edu:4567/venues"; //just a string (grab all meals from pex)

            // Connect to the URL using java's native library
            URL url = new URL(sURL);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            // Convert to a JSON object to print data
            JsonParser jp = new JsonParser(); //from gson
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent())); //Convert the input stream to a json element
            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.

            // lets print how many meals we got
            int c = rootobj.get("count").getAsInt(); //just grab the count of meals from pex
            System.out.println("Total venues: " + c);

            // lets get and print a list of meals
            JsonArray mealsJson = rootobj.getAsJsonArray("venues");
            String[] names = new String[mealsJson.size()];

            for (int i = 0; i < mealsJson.size(); i++) {
                names[i] = mealsJson.get(i).getAsJsonObject().get("name").getAsString();
            }

            for (int i = 0; i < names.length; i++){
                venueList.add(i, new Venue(names[i].toString()));
            }

        }
        catch(MalformedURLException mue){
            System.out.println("MalfromedURLException");
            System.out.println("Exception:" + mue.getMessage());
        }
        catch(IOException ioe){
            System.out.println("IOException");
            System.out.println("Exception:" + ioe.getMessage());
        }
        return venueList;
    }

}
