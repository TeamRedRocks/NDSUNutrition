package com.redteam.ndsunutrition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * NOTE: This is currently unused as custom meals have not been implemented yet so there's
 * no point in making the user make a choice here.
 * To include this screen, make the floating action button in MainActivity.java send an intent to
 * this activity instead of PickRestaurantActivity
 */
public class AddItemActivity extends AppCompatActivity
{
    private Button restaurantButton;
    private Button customMealButton;
    private TextView pickMealTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);

        // Receive intent
        Intent intent = getIntent();

        // Set up buttons and textview
        restaurantButton = (Button) findViewById(R.id.buttonRestaurant);
        customMealButton = (Button) findViewById(R.id.buttonCustomMeal);
        pickMealTextView = (TextView) findViewById(R.id.textViewPickMeal);
    }

    // Sends an intent to PickRestaurantActivity
    public void goToRestaurants(View view)
    {
        Intent intent = new Intent(this, PickRestaurantActivity.class);
        startActivity(intent);
    }

    // Will be used to create a custom meal when/if implemented
    public void createCustomMeal(View view)
    {
        // Send intent to custom meal creation class here
    }
}
