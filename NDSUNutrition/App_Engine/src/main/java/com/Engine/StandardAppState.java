/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Engine;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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

    @Override
    public void constructUserProfile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        ArrayList list = new ArrayList<Venue>(3);
        try {
            //private static final String sURL = "http//rin.cs.ndsu.nodak.edu:4567/venues/1/meals/";

            JsonParser jp = new JsonParser();

            URL url = new URL("http://rin.cs.ndsu.nodak.edu:4567/venues");

            //String sURL = readUrl("http//rin.cs.ndsu.nodak.edu:4567/venues/1/meals");
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();

            System.out.println(request.getErrorStream());
            Gson gs = new Gson();
            //Throws IOException?
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.

            //How to do this?
            String zipcode = rootobj.get("venues").getAsString();
            //String test = rootobj.get("protein").getAsString();

            list.add(zipcode);

        } catch (MalformedURLException mfe) {
            System.out.println(mfe.getMessage() + "This is an error");
        }
        catch(IOException ioe){

            System.out.println(ioe.getMessage() + "This is another error");
            System.out.println(Arrays.toString(ioe.getStackTrace()));
        }
        return list;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
