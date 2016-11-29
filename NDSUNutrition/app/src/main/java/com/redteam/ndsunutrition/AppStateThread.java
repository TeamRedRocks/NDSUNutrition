package com.redteam.ndsunutrition;

import android.content.Context;
import android.os.AsyncTask;

import com.Engine.AppState;
import com.Engine.StandardAppState;


/**
 * Created by Jaron on 11/28/2016.
 */

public class AppStateThread extends AsyncTask <Void,Void,Void> {

    public static AppState STATE;

    public AppStateThread(Context context)
    {
        STATE = new StandardAppState();
    }

    @Override
    protected Void doInBackground(Void... params) {

        STATE.constructListVenues();

        return null;
    }

}
