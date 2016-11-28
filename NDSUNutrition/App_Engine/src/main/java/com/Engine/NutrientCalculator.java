/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Engine;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
        as.getRecommendationsList();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Date> getListDates(int numDaysPriorToToday)
    {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Date> getListDates(Date fromDate, Date toDate)
    {
        Date from = fromDate;
        Date to = toDate;

        //Currently only works for Dates with the same year and non-leap years
        int size = returnSize(fromDate, toDate);

        List<Date> list = new ArrayList<Date>();
        list.add(fromDate); //doesn't work
        for(int i = 0; i < size -2; i++){
            if(from.getDay() < returnDaysInMonth(from.getMonth())) {
                from.setDay(from.getDay() + 1);
                list.add(from);
            }
            else if(from.getMonth() < 12)
            {
                from.setMonth(from.getMonth() +1);
                list.add(from);
            }
            else
            {
                from.setYear(from.getYear()+1);
                list.add(from);
            }

//            Date md = from;
//            list.add(md);
        }
        list.add((size)-1, toDate);
//        for(Date m : list){
//            MealDate date = new MealDate(m.getYear(),
//                    m.getMonth(), m.getDay(),
//                    m.getHour(), m.getMinute());
//            list.add(date);
//        }
        return list;
    }

    @Override
    public double getPDV(NutrientTotal nutrientTotal, RecommendedDailyAllowance rda) {
        String nutrient = nutrientTotal.getNutrient().getName();
        double pdv = 0.0;
        nutrientTotal.getAmount();

        return pdv;
    }

    @Override
    public List<NutrientTotal> getNutrientTotals(Date fromDate, Date toDate, UserProfile userProfile) {
        List<NutrientTotal> list = new ArrayList<>();
        List<Meal> meals = new ArrayList<>();
        List<Meal> rangeMeals = new ArrayList<>();
        List<Date> dates = new ArrayList<>();
        List<MealEntry> mealEntry = new ArrayList<>();


        NutrientTotal protein = new NutrientTotal(new Nutrient("protein", "g"), 0.0);
        NutrientTotal sugar = new NutrientTotal(new Nutrient("sugar", "g"), 0.0);
        NutrientTotal saturatedFat = new NutrientTotal(new Nutrient("saturatedFat", "g"), 0.0);
        NutrientTotal sodium = new NutrientTotal(new Nutrient("sodium", "mg"), 0.0);
        NutrientTotal cholesterol = new NutrientTotal(new Nutrient("cholesterol", "mg"), 0.0);
        NutrientTotal carbohydrates = new NutrientTotal(new Nutrient("carbohydrates", "g"), 0.0);
        NutrientTotal fiber = new NutrientTotal(new Nutrient("fiber", "g"), 0.0);
        NutrientTotal totalFat = new NutrientTotal(new Nutrient("totalFat", "g"), 0.0);
        //NutrientTotal potassium = new NutrientTotal(new Nutrient("potassium", ""), 0.0);
        NutrientTotal transFat = new NutrientTotal(new Nutrient("transFat", "g"), 0.0);


        dates = getListDates(fromDate, toDate);

        UserProfile up = userProfile;

        meals = up.getMeals();

        for(Meal m : meals)
        {
            //Date current = m.getDate();

            for(Date d : dates)
            {
                if(d.getDay() == m.getDate().getDay())
                {
                    rangeMeals.add(m);
                }

            }
        }

        for(Meal m : rangeMeals)
        {
            for (MealEntry me : m.getMealEntries())
            {
                mealEntry.add(me);
            }

        }

        for(MealEntry me : mealEntry)
        {
            double chosen = me.getAmount();
            double serving = me.getMenuItem().getServingSize();
            double ratio = chosen / serving;

            for(NutrientTotal nt : me.getMenuItem().getNutrients())
            {
                switch(nt.getNutrient().getName()){
                    case "protein":
                        protein.setAmount( protein.getAmount() + nt.getAmount()*ratio);
                        break;
                    case "sugar":
                        sugar.setAmount(sugar.getAmount() + nt.getAmount()*ratio);
                        break;
                    case "saturatedFat":
                        saturatedFat.setAmount(saturatedFat.getAmount() + nt.getAmount()*ratio);
                        break;
                    case "sodium":
                        sodium.setAmount(sodium.getAmount() + nt.getAmount()*ratio);
                        break;
                    case "cholesterol":
                        cholesterol.setAmount(cholesterol.getAmount() + nt.getAmount()*ratio);
                        break;
                    case "carbohydrates":
                        carbohydrates.setAmount(carbohydrates.getAmount() + nt.getAmount()*ratio);
                        break;
                    case "fiber":
                        fiber.setAmount(fiber.getAmount() + nt.getAmount()*ratio);
                        break;
                    case "totalFat":
                        totalFat.setAmount(totalFat.getAmount() + nt.getAmount()*ratio);
                        break;
                    case "transFat":
                        transFat.setAmount(transFat.getAmount() + nt.getAmount()*ratio);
                        break;
                    default:
                        System.out.println("This is probably calories");
                        break;

                }
            }
        }

        list.add(sugar); //1
        list.add(protein); //2
        list.add(sodium); //3
        list.add(totalFat); //4
        list.add(transFat); //5
        list.add(saturatedFat); //6
        list.add(fiber); //7
        list.add(carbohydrates); //8
        list.add(cholesterol); //9

        return list;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    private ArrayList<NutrientTotal> getRDANutrientTotals(int numDays) {
//        ArrayList list = new ArrayList<NutrientTotal>(numDays);
//        try {
//            //private static final String sURL = "http//rin.cs.ndsu.nodak.edu:4567/venues/1/meals/";
//            
//            JsonParser jp = new JsonParser();
//
//            URL url = new URL("http://rin.cs.ndsu.nodak.edu:4567/venues/1/meals");
//
//            //String sURL = readUrl("http//rin.cs.ndsu.nodak.edu:4567/venues/1/meals");
//            HttpURLConnection request = (HttpURLConnection) url.openConnection();
//            request.connect();
//            
//            System.out.println(request.getErrorStream());
//            //Throws IOException?
//            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//
//            JsonObject rootobj = root.getAsJsonObject(); //May be an array, may be an object.
//
//            String zipcode = rootobj.get("count").getAsString();
//            //String test = rootobj.get("protein").getAsString();
//            
//            
//            //test of the addition of a nutrient Total
//            //NutrientTotal na = new NutrientTotal(new Nutrient("Protein", "grams"), 3.0);
//            //list.add(na);
//
//            list.add(zipcode);
//            //list.add(test);
//           
//            //zipcode = rootobj.get(“count”).getAsString();
//        } catch (MalformedURLException mfe) {
//            System.out.println(mfe.getMessage() + "This is an error");
//        }
//        catch(IOException ioe){
//            
//            System.out.println(ioe.getMessage() + "This is another error");
//            System.out.println(Arrays.toString(ioe.getStackTrace()));
//        }
//       return list;
//    }
//
//    public ArrayList<Nutrient> lowestNutrients(int numLowest) {
//        ArrayList list = new ArrayList<Nutrient>(numLowest);
//        //test of the addition of a nutrient
//        Nutrient na = new Nutrient("Protein", "grams");
//        list.add(na);
//
//        return list;
//    }

    public ArrayList<MealEntry> getAllMealEntries(Date date) {
        ArrayList list = new ArrayList<MealEntry>();
        //test of the addition of a nutrient\
        //(String name, double servingSize, String servingUnit, Nutrient nutrient, String category, String infoSource, String venue) 

        //MealEntry na = new MealEntry(new MenuItem(), 5.0);
        list.add(null);

        return list;
    }

    public int returnDaysInMonth(int date){
        int days = 0;
        switch(date) {
            case 1:
                days += 31;
                break;
            case 2:
                days += 28;
                break;
            case 3:
                days += 31;
                break;
            case 4:
                days += 30;
                break;
            case 5:
                days += 31;
                break;
            case 6:
                days += 30;
                break;
            case 7:
                days += 31;
                break;
            case 8:
                days += 31;
                break;
            case 9:
                days += 30;
                break;
            case 10:
                days += 31;
                break;
            case 11:
                days += 30;
                break;
            case 12:
                days += 31;
                break;
        }
        return days;
    }

    public int returnDays(Date toDate, int num){
        int total = 0;
        for (int i = 0; i< num; i++){
            total += returnDaysInMonth(toDate.getMonth() - (i+1));
        }
        return total;
    }

    public int returnSize(Date fromDate, Date toDate){
        int size = 1;
        if(fromDate.getYear() == toDate.getYear()) {
            if (fromDate.getMonth() == toDate.getMonth()){
                size = (Math.abs(toDate.getDay() - fromDate.getDay()));
            }
            else{
                switch(Math.abs(toDate.getMonth()- fromDate.getMonth())){
                    case 1:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay());
                        break;
                    case 2:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 1);
                        break;
                    case 3:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 2);
                        break;
                    case 4:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 3);
                        break;
                    case 5:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 4);;
                        break;
                    case 6:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 5);
                        break;
                    case 7:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 6);
                        break;
                    case 8:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 7);
                        break;
                    case 9:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 8);
                        break;
                    case 10:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 9);
                        break;
                    case 11:
                        size = toDate.getDay() + (returnDaysInMonth(fromDate.getMonth())- fromDate.getDay())
                                + returnDays(toDate, 10);
                        break;
                    default:
                        //Won't work for Leap Year Change this later
                        size = 365- Math.abs(toDate.getDay() - fromDate.getDay());
                        break;
                }
            }
        }
        return size;
    }
}
