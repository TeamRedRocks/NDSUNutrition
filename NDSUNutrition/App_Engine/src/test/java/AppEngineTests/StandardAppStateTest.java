package AppEngineTests;

import com.Engine.Date;
import com.Engine.Meal;
import com.Engine.MealDate;
import com.Engine.MealEntry;
import com.Engine.MenuItem;
import com.Engine.Nutrient;
import com.Engine.NutrientTotal;
import com.Engine.Recommendation;
import com.Engine.StandardAppState;
import com.Engine.StandardUserProfile;
import com.Engine.UserProfile;
import com.Engine.Venue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ryan on 11/19/16.
 */
public class StandardAppStateTest {

    StandardAppState testState; //object

    @Before
    public void setUp()
    {
        testState = new StandardAppState();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testGetListMenuItems()
    {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");
        List<MenuItem> testList = new ArrayList<>();
        testList.add(m1);

        testState.setListOfMenuItems(testList);

        int expected = 1;
        int actual = testState.getListMenuItems().size();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetListOfMenuItems()
    {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");
        List<MenuItem> testList = new ArrayList<>();
        testList.add(m1);

        testState.setListOfMenuItems(testList);
    }



    @Test
    public void testConstructListOfMenuItems_PandaExpress()
    {
        testState.constructListOfMenuItems("Panda Express");


        int expected = 46;
        int actual = testState.getListMenuItems().size();

        assertEquals(expected, actual);

    }

    @Test
    public void testConstructListOfMenuItems_PizzaHut()
    {
        testState.constructListOfMenuItems("Pizza Hut");


        int expected = 0;
        int actual = testState.getListMenuItems().size();

        assertEquals(expected, actual);

    }



    @Test(expected=IllegalArgumentException.class)
    public void constructListOfMenuItems_Nonexisting()
    {
        testState.constructListOfMenuItems("Test 1");

    }

    @Test
    public void testGetUserProfile()
    {
        //set profile
        UserProfile testProfile = new StandardUserProfile();
        testProfile.setRecommendedCalories(2500);
        testState.setUserProfile(testProfile);

        //get profile
        UserProfile expected = new StandardUserProfile();
        expected.setRecommendedCalories(2500);
        UserProfile actual = testState.getUserProfile();

        assertEquals(expected.getRecommendedCalories(), actual.getRecommendedCalories());
    }

    @Test
    public void testSetUserProfile()
    {
        UserProfile testProfile = new StandardUserProfile();
        testProfile.setRecommendedCalories(2500);

        testState.setUserProfile(testProfile);
    }

    @Test
    public void testConstructUserProfile()
    {
        testState.constructUserProfile();

    }

    @Test
    public void testGetListOfVenues()
    {
        Venue venue1 = new Venue("Panda Express");
        Venue venue2 = new Venue("Pizza Hut");


        List<Venue> expected = new ArrayList<>();
        expected.add(venue1);
        expected.add(venue2);
        testState.setListVenues(expected);

        List<Venue> actual = testState.getListOfVenues();

        assertEquals(expected, actual);

    }

    @Test
    public void testSetListVenues()
    {
        Venue venue1 = new Venue("Panda Express");
        Venue venue2 = new Venue("Pizza Hut");


        List<Venue> expected = new ArrayList<>();

        testState.setListVenues(expected);
    }

    @Test
    public void testConstructListVenues()
    {
        testState.constructListVenues();
        Venue expected = new Venue("Panda Express");
        Venue actual = testState.getListOfVenues().get(0);

        assertEquals(expected, actual);
    }

    @Test
    public void testGetRecommendationsList()
    {
        Nutrient protein = new Nutrient("Protein", "grams");
        Recommendation r1 = new Recommendation("Low in sodium", "Eat food with salt in it.", "Test", protein);
        List<Recommendation> expected = new ArrayList<>();

        testState.setRecommendationsList(expected);

        List<Recommendation> actual = testState.getRecommendationsList();

        assertEquals(expected, actual);
    }

    @Test
    public void testSetRecommendationsList()
    {
        Nutrient protein = new Nutrient("Protein", "grams");
        Recommendation r1 = new Recommendation("Low in sodium", "Eat food with salt in it.", "Test", protein);
        List<Recommendation> expected = new ArrayList<>();
        expected.add(r1);

        testState.setRecommendationsList(expected);

    }


    @Test
    public void testConstructRecommendationsList()
    {
        testState.constructRecommendationsList();

    }

    @Test
    public void testGetSystemTime()
    {
        int dayExpected = Calendar.DAY_OF_MONTH;
        int dayActual = testState.getSystemTime().getDay();

        assertEquals(dayExpected, dayActual);
    }

    @Test
    public void testSortMenuItems()
    {
        //StandardMenuItem expected = new StandardMenuItem(“Chicken Egg Roll”, 2.75, “ounces”, new List<Nutrient> (), “Appetizer”, “Panda Express website”, “Panda Express”);

        //appState.setListOfMenuItems(“Panda Express”);
       // StandardMenuItem actual = appState.getListOfMenuItems().SortMenuItems().First();

        MenuItem expected = new MenuItem("Chicken Egg Roll", 2.75, "ounces",
                new ArrayList<NutrientTotal>(), "Appetizer", "Panda Express website", "Panda Express");

        testState.constructListOfMenuItems("Panda Express");


        List<MenuItem> testList = testState.getListMenuItems();
        testState.sortMenuItems();
        MenuItem actual = testList.get(0);

        assertEquals(expected.getName(), actual.getName());

    }

    @Test
    public void testSortVenues()
    {
        Venue expected = new Venue("McDonalds");
        testState.constructListVenues();


        testState.sortVenues();
        Venue actual = testState.getListOfVenues().get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testSortMeals()
    {

        List<MealEntry> l1 = new ArrayList<>();
        Venue v1 = new Venue("Panda Express");
        Venue v2 = new Venue("Carino's");
        MealDate d1 = new MealDate(2016,10,8,5,45);
        MealDate d2 = new MealDate(2016,11,14,6,30);
        Meal meal1 = new Meal(v1,d1,l1);
        Meal meal2 = new Meal(v2,d2,l1);


        StandardUserProfile testProfile = new StandardUserProfile();
        testProfile.addMeal(meal1);
        testProfile.addMeal(meal2);

        testState.sortMeals();
        Meal expected = meal1;
        Meal actual = testState.getUserProfile().getMeals().get(0);

        assertEquals(expected, actual);


    }

    @Test
    public void testExportUserProfileTo()
    {
        testState.exportUserProfileTo("TestExport");

    }

}