package com.redteam.ndsunutrition;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.Engine.AppState;
import com.Engine.StandardAppState;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;

public class MainActivity extends AppCompatActivity
{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    public final static String EXTRA_MESSAGE = "com.redteam.viewpagerdemo.MESSAGE";
    private SectionsPagerAdapter mSectionsPagerAdapter;
    public static AppStateThread contentRetriever;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        contentRetriever = new AppStateThread(getApplicationContext());
        contentRetriever.execute();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    }

    // FAB onClick method that starts the restaurant meal addition process
    public void addItem(View view)
    {
        // Send intent to PickRestaurantActivity and start it
        Intent intent = new Intent(this, PickRestaurantActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.user_profile:
                Toast.makeText(this, "User Profile Button Pressed", Toast.LENGTH_LONG).show();
                return true;
            case R.id.dashboard:
                Toast.makeText(this, "Dashboard Button Pressed", Toast.LENGTH_LONG).show();
                return true;
            case R.id.recommendations:
                Toast.makeText(this, "Recommendations Button Pressed", Toast.LENGTH_LONG).show();
                return true;
            case R.id.custom_recipes:
                Toast.makeText(this, "Custom Recipes Button Pressed", Toast.LENGTH_LONG).show();
                return true;
            case R.id.export_data:
                Toast.makeText(this, "Exported Data Button Pressed", Toast.LENGTH_LONG).show();
                return true;
            case R.id.about:
                Toast.makeText(this, "About Button Pressed", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_main, popup.getMenu());
        popup.show();
    }
}
