package com.redteam.ndsunutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.Engine.Meal;
import com.Engine.MealEntry;
import com.Engine.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuItemActivity extends AppCompatActivity
{

    private TextView menuTextView;
    private TextView invalidTextView;
    private TextView noItemsTextView;
    private Spinner menuItemSpinner;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> menuItems;
    private ArrayList<String> mealItems;
    private List<MealEntry> mealEntries;
    private List<MenuItem> items;
    private Meal meal;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_item);

        Intent intent = getIntent();

        // Get the Meal object from the previous activity
        meal = (Meal) intent.getSerializableExtra(PickRestaurantActivity.EXTRA_MESSAGE);

        // Initialize GUI features
        menuTextView = (TextView) findViewById(R.id.textViewPickMeal);
        invalidTextView = (TextView) findViewById(R.id.textViewInvalidItem);
        invalidTextView.setVisibility(View.INVISIBLE);
        noItemsTextView = (TextView) findViewById(R.id.textViewNoItems);
        noItemsTextView.setVisibility(View.INVISIBLE);
        menuItemSpinner = (Spinner) findViewById(R.id.spinnerMenuItems);

        mealItems = new ArrayList<>();

        // Get the menu items for the selected restaurant
        getMenuItems(meal.getLocation().getName());
        addItemSelectedListenerToSpinner();
    }

    // Checks if the user selected an actual menu item so it can hide the invalidTextView if its shown
    private void addItemSelectedListenerToSpinner()
    {
        menuItemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            // Hide the invalid selection text when the user selects an item
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                if(!menuItemSpinner.getSelectedItem().toString().equals("Select One"))
                {
                    invalidTextView.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent)
            {
                // Don't need to do anything here
            }
        });
    }

    // Gets the menu items for the selected restaurant
    private void getMenuItems(String restaurant)
    {
        // Stub for when getting menu items is implemented
        //items = MainActivity.contentRetriever.STATE.getListMenuItems();

        menuItems = new ArrayList<>();
        menuItems.add("Select One");

        // Stub for when getting menu items is implemented
        /*for (int i = 0; i < items.size(); i++)
        {
            menuItems.add(items.get(i).getName());
        }
        // Adapt the string array to be used by the spinner
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, menuItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Link restaurantSpinner to our adapter
            menuItemSpinner.setAdapter(adapter);
            */

        //We will do this a different way once we have the API and this can all be deleted
        if(restaurant.equals("Panda Express"))
        {
            // Add dummy data
            menuItems.add("Fried Rice");
            menuItems.add("Orange Chicken");
            menuItems.add("General Tsao's Chicken");

            // Adapt the string array to be used by the spinner
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, menuItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Link restaurantSpinner to our adapter
            menuItemSpinner.setAdapter(adapter);
        }
        else
        {
            // Add dummy data
            menuItems.add("Cheese Burger");
            menuItems.add("Cheese Burger Combo");
            menuItems.add("Small French Fries");
            menuItems.add("Medium French Fries");

            // Adapt the string array to be used by the spinner
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, menuItems);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            // Link restaurantSpinner to our adapter
            menuItemSpinner.setAdapter(adapter);
        }
    }

    // Adds a MealEntry to the meanEntries list
    public void addMealItem(View view)
    {
        // Set up the toast for when an item is successfully added
        Toast toast;
        toast = Toast.makeText(getApplicationContext(), "Item Added!", Toast.LENGTH_SHORT);

        // Show the invalid TextView if the user tries to submit the default value
        if(menuItemSpinner.getSelectedItem().toString().equals("Select One"))
        {
            invalidTextView.setVisibility(View.VISIBLE);
        }
        else
        {
            // Uncomment when MealEntries are supported
            //mealEntries.add(new MealEntry(menuItem, 1));

            mealItems.add(menuItemSpinner.getSelectedItem().toString());
            noItemsTextView.setVisibility(View.INVISIBLE);

            // Notify the user they added an item
            toast.show();
        }
    }

    // Sends an intent to the ReviewMealActivity
    public void reviewMeal(View view)
    {
        // Show the invalid TextView if the user tries to submit the default value
        if(mealItems.isEmpty())
        {
            noItemsTextView.setVisibility(View.VISIBLE);
        }
        else // Send an intent to return to mainActivity
        // We will also need to save the meal data here or call another method to do so
        {
            String[] mealItemsArray = new String[mealItems.size()];
            for(int i = 0; i < mealItems.size(); i++)
            {
                mealItemsArray[i] = mealItems.get(i);
            }
            // Uncomment when meal entries supported
            //meal.setMealEntries(mealEntries);

            // Pass the updated Meal object to the next activity
            Intent intent = new Intent(this, ReviewMealActivity.class);
            intent.putExtra("Meal items", meal);
            startActivity(intent);
        }
    }
}
