package com.redteam.ndsunutrition;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * created by Connor Fradenburgh on 10/24/2106
 */
public class NutrientsFragment extends Fragment
{
    //create TextView objects for each of the tracked nutrients (i.e. "100/200 calories")
    private TextView calText;
    private TextView totFatText;
    private TextView satFatText;
    private TextView cholText;
    private TextView sodiumText;
    private TextView totCarbsText;
    private TextView dietFiberText;
    private TextView sugarText;
    private TextView proteinText;
    private TextView potassText; //potassium

    //create variables for counted daily nutrients and required daily nutrients
    private int dailyCal = 10;
    private int recCal = 20; //rec = recommended
    private int dailyTotFat = 0;
    private int recTotFat = 0;
    private int dailySatFat = 0;
    private int recSatFat = 0;
    private int dailyChol = 0;
    private int recChol = 0;
    private int dailySodium = 0;
    private int recSodium = 0;
    private int dailyTotCarbs = 0;
    private int recTotCarbs = 0;
    private int dailyDietFib = 0;
    private int recDietFib = 0;
    private int dailySugar = 0;
    private int recSugar = 0;
    private int dailyProtein = 0;
    private int recProtein = 0;
    private int dailyPotass = 0;
    private int recPotass = 0;

    //create variables for each of the progess bars
    private ProgressBar caloriesProgress;
    private ProgressBar totalFatProgress;
    private ProgressBar satFatProgress;
    private ProgressBar cholesterolProgress;
    private ProgressBar sodiumProgress;
    private ProgressBar totalCarbsProgress;
    private ProgressBar dietaryFiberProgress;
    private ProgressBar sugarProgress;
    private ProgressBar proteinProgress;
    private ProgressBar potassiumProgress;

    private static final String ARG_SECTION_NUMBER = "section_number";
    public NutrientsFragment()
    {

    }

    public static Fragment newInstance(int sectionNumber)
    {
        NutrientsFragment nutrientsFragment = new NutrientsFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        nutrientsFragment.setArguments(args);
        return nutrientsFragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_nutrients, container, false);

        //changes the textView of the counted / recommended for each nutrient
        //each textView will have the format "(daily nutrients) / (recommended daily nutrients) nutrient"
        calText = (TextView) rootView.findViewById(R.id.countedCalories);
        calText.setText(dailyCal + "/" + recCal + " calories");

        totFatText = (TextView) rootView.findViewById(R.id.trackedTotalFat);
        totFatText.setText(dailyTotFat + "/" + recTotFat + "g");

        satFatText = (TextView) rootView.findViewById(R.id.trackedSatFat);
        satFatText.setText(dailySatFat + "/" + recSatFat + "g");

        cholText = (TextView) rootView.findViewById(R.id.trackedCholesterol);
        cholText.setText(dailyChol + "/" + recChol + "mg");

        sodiumText = (TextView) rootView.findViewById(R.id.trackedSodium);
        sodiumText.setText(dailySodium + "/" + recSodium + "mg");

        totCarbsText = (TextView) rootView.findViewById(R.id.trackedTotalCarbs);
        totCarbsText.setText(dailyTotCarbs + "/" + recTotCarbs + "g");

        dietFiberText = (TextView) rootView.findViewById(R.id.trackedDietFiber);
        dietFiberText.setText(dailyDietFib + "/" + recDietFib + "g");

        sugarText = (TextView) rootView.findViewById(R.id.trackedSugar);
        sugarText.setText(dailySugar + "/" + recSugar + "g");

        proteinText = (TextView) rootView.findViewById(R.id.trackedProtein);
        proteinText.setText(dailyProtein + "/" + recProtein + "g");

        potassText = (TextView) rootView.findViewById(R.id.trackedPotassium);
        potassText.setText(dailyPotass + "/" + recPotass + "mg");

        //setting nutrients progress bars
        //bar.setProgress will set how far the user is using their daily intake of nutrients
        //Max progress bar will be recommended nutrients * 2

        caloriesProgress = (ProgressBar) rootView.findViewById(R.id.caloriesProgressBar);
        caloriesProgress.setProgress(dailyCal);
        caloriesProgress.setMax(2 * recCal);

        totalFatProgress = (ProgressBar) rootView.findViewById(R.id.totalFatProgressBar);
        totalFatProgress.setProgress(dailyTotFat);
        totalFatProgress.setMax(2 * recTotFat);

        satFatProgress = (ProgressBar) rootView.findViewById(R.id.saturatedFatProgressBar);
        satFatProgress.setProgress(dailySatFat);
        satFatProgress.setMax(2 * recSatFat);

        cholesterolProgress = (ProgressBar) rootView.findViewById(R.id.cholesterolProgressBar);
        cholesterolProgress.setProgress(dailyChol);
        cholesterolProgress.setMax(2 * recChol);

        sodiumProgress = (ProgressBar) rootView.findViewById(R.id.sodiumProgressBar);
        sodiumProgress.setProgress(dailySodium);
        sodiumProgress.setMax(2 * recSodium);

        totalCarbsProgress = (ProgressBar) rootView.findViewById(R.id.totalCarbProgessBar);
        totalCarbsProgress.setProgress(dailyTotCarbs);
        totalCarbsProgress.setMax(2 * recTotCarbs);

        dietaryFiberProgress = (ProgressBar) rootView.findViewById(R.id.dietaryFiberProgressBar);
        dietaryFiberProgress.setProgress(dailyDietFib);
        dietaryFiberProgress.setMax(2 * recDietFib);

        sugarProgress = (ProgressBar) rootView.findViewById(R.id.sugarProgessBar);
        sugarProgress.setProgress(dailySugar);
        sugarProgress.setMax(2 * recSugar);

        proteinProgress = (ProgressBar) rootView.findViewById(R.id.proteinProgressBar);
        proteinProgress.setProgress(dailyProtein);
        proteinProgress.setMax(2 * recProtein);

        potassiumProgress = (ProgressBar) rootView.findViewById(R.id.potassiumProgressBar);
        potassiumProgress.setProgress(dailyPotass);
        potassiumProgress.setMax(2 * recPotass);

        return rootView;
    }
}
