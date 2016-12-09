package com.redteam.ndsunutrition;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.Engine.AppState;
import com.Engine.NutrientCalculator;
import com.Engine.StandardAppState;


/**
 * Created by Jaron on 11/28/2016.
 */

public class AppStateThread extends AsyncTask <Void,Integer,Void> {

    public AppState STATE;
    public NutrientCalculator CALC;
    private Context context;


    public AppStateThread(Context context)
    {
        STATE = new StandardAppState();
        CALC = new NutrientCalculator();
        this.context = context;
    }


    @Override
    protected Void doInBackground(Void... params) {


        //The commented out methods are currently not implemented.
        STATE.setListVenues(STATE.constructListVenues());
        publishProgress(25);
        //CALC.someMethod();
        publishProgress(50);
        //STATE.setListOfMenuItems(STATE.constructListOfMenuItems());
        publishProgress(75);
        //STATE.setRecommendationsList(STATE.constructRecommendationsList());
        publishProgress(100);

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(context.getApplicationContext(),"Database Loaded",Toast.LENGTH_LONG);
    }

    @Override
    protected void onProgressUpdate(Integer... values)
    {
        super.onProgressUpdate(values);
        //Update progress bar here
        //pb.setProgress(values[0]);

    }

}
