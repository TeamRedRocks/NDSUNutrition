package AppEngineTests;

import com.Engine.MenuItem;
import com.Engine.Nutrient;
import com.Engine.NutrientTotal;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ryan on 11/19/16.
 */
public class MenuItemTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }



    @Test
    public void equals() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");
        MenuItem m2 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        boolean testBool =  m1.equals(m2);
        assertEquals(testBool, true);

    }


    @Test
    public void getName() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        assertEquals(m1.getName(), "Spaghetti");

    }

    @Test
    public void setName() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        m1.setName("Pasta");

        assertEquals(m1.getName(), "Pasta");
    }

    @Test
    public void getServingSize() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        assertEquals(m1.getServingSize(), 50.0);
    }

    @Test
    public void setServingSize() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        m1.setServingSize(200.0);

        assertEquals(m1.getServingSize(), 200.0);


    }

    @Test
    public void getServingUnit() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        assertEquals(m1.getServingUnit(), "ounces");
    }

    @Test
    public void setServingUnit() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        m1.setServingUnit("pounds");

        assertEquals(m1.getServingSize(), "pounds");
    }

    @Test
    public void getNutrients() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        List<NutrientTotal> nutrientList2 = new ArrayList<>();

        assertEquals(m1.getNutrients(), nutrientList2);

    }

    @Test
    public void setNutrients() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        List<NutrientTotal> nutrientListToBeSet = new ArrayList<>();

        Nutrient newNutrient = new Nutrient("B12", "Miligrams" );

        NutrientTotal newTotal = new NutrientTotal(newNutrient, 1);

        nutrientListToBeSet.add(newTotal);

        m1.setNutrients(nutrientListToBeSet);

        assertEquals(m1.getNutrients(), nutrientListToBeSet);
    }

    @Test
    public void getCategory() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        assertEquals(m1.getCategory(), "Entree");

    }

    @Test
    public void setCategory() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        m1.setCategory("Dessert");

        assertEquals(m1.getCategory(), "Dessert");
    }

    @Test
    public void getInfoSource() throws Exception {

        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        assertEquals(m1.getInfoSource(), "Google.com");

    }

    @Test
    public void setInfoSource() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        m1.setInfoSource("Bing.com");

        assertEquals(m1.getInfoSource(), "Bing.com");

    }

    @Test
    public void getVenue() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        assertEquals(m1.getVenue(), "Johnny Carinos");
    }

    @Test
    public void setVenue() throws Exception {
        List<NutrientTotal> nutrientList = new ArrayList<>();
        MenuItem m1 = new MenuItem("Spaghetti", 50.0, "ounces", nutrientList, "Entree", "Google.com", "Johnny Carinos");

        m1.setVenue("Olive Garden");

        assertEquals(m1.getVenue(), "Olive Garden");
    }

}