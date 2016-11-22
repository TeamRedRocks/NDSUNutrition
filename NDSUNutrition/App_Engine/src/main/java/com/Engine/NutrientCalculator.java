/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nutrition.app;

import java.util.ArrayList;
import java.util.List;
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
import java.util.Arrays;

/**
 *
 * @author mitchell.olson.1
 * 
 */
public class NutrientCalculator implements CalculatorInterface {

    

    
    @Override
    public List<Recommendation> getRecommendations(int num, AppState as) {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Date> getListDates(int numDaysPriorToToday) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getPDV(NutrientTotal nutrientTotal) {
        return nutrientTotal.getAmount();
    }

    @Override
    public List<NutrientTotal> getNutrientTotals(Date fromDate, Date toDate, UserProfile userProfile) {
        try {
            //private static final String sURL = "http//rin.cs.ndsu.nodak.edu:4567/venues/1/meals/";
            Gson gson = new Gson();

            URL url = new URL("http://rin.cs.ndsu.nodak.edu:4567/venues/1/meals");

            //String sURL = readUrl("http//rin.cs.ndsu.nodak.edu:4567/venues/1/meals");
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
        } catch (MalformedURLException mfe) {
            System.out.println(mfe.getMessage());
        }
        catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ArrayList<NutrientTotal> getRDANutrientTotals(int numDays) {
        ArrayList list = new ArrayList<NutrientTotal>(numDays);
        try {
            //private static final String sURL = "http//rin.cs.ndsu.nodak.edu:4567/venues/1/meals/";
            
            JsonParser jp = new JsonParser();

            URL url = new URL("http://rin.cs.ndsu.nodak.edu:4567/venues/1/meals");

            //String sURL = readUrl("http//rin.cs.ndsu.nodak.edu:4567/venues/1/meals");
            HttpURLConnection request = (HttpURLConnection) url.openConnection();
            request.connect();
            
            System.out.println(request.getErrorStream());
            //Throws IOException?
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.

            String zipcode = rootobj.get("count").getAsString();
            //String test = rootobj.get("protein").getAsString();
            
            
            //test of the addition of a nutrient Total
            //NutrientTotal na = new NutrientTotal(new Nutrient("Protein", "grams"), 3.0);
            //list.add(na);

            list.add(zipcode);
            //list.add(test);
           
            //zipcode = rootobj.get(“count”).getAsString();
        } catch (MalformedURLException mfe) {
            System.out.println(mfe.getMessage() + "This is an error");
        }
        catch(IOException ioe){
            
            System.out.println(ioe.getMessage() + "This is another error");
            System.out.println(Arrays.toString(ioe.getStackTrace()));
        }
       return list;
    }

    public ArrayList<Nutrient> lowestNutrients(int numLowest) {
        ArrayList list = new ArrayList<Nutrient>(numLowest);
        //test of the addition of a nutrient
        Nutrient na = new Nutrient("Protein", "grams");
        list.add(na);

        return list;
    }

    public ArrayList<MealEntry> getAllMealEntries(Date date) {
        ArrayList list = new ArrayList<MealEntry>();
        //test of the addition of a nutrient\
        //(String name, double servingSize, String servingUnit, Nutrient nutrient, String category, String infoSource, String venue) 

        MealEntry na = new MealEntry(new MenuItem(), 5.0);
        list.add(na);

        return list;
    }

}