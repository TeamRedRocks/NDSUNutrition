package com.Engine;

import java.util.List;

/**
 *
 * @author donovan.beckmann
 */
public class StandardRecommendedDailyAllowance implements RecommendedDailyAllowance{

    public StandardRecommendedDailyAllowance() {
    }

    @Override
    public List<NutrientTotal> getAdjustedRDA(int calories) {
        return null;
    }

    @Override
    public int getCALORIES_STANDARD() {
        return CALORIES_STANDARD;
    }

    @Override
    public int getTOTALFAT_STANDARD() {
        return TOTALFAT_STANDARD;
    }

    @Override
    public int getSATURATEDFAT_STANDARD() {
        return SATURATEDFAT_STANDARD;
    }

    @Override
    public int getCHOLESTEROL_STANDARD() {
        return CHOLESTEROL_STANDARD;
    }

    @Override
    public int getSODIUM_STANDARD() {
        return SODIUM_STANDARD;
    }

    @Override
    public int getTOTALCARB_STANDARD() {
        return TOTALCARB_STANDARD;
    }

    @Override
    public int getDIETARYFIBER_STANDARD() {
        return DIETARYFIBER_STANDARD;
    }

    @Override
    public int getSUGAR_STANDARD() {
        return SUGAR_STANDARD;
    }

    @Override
    public int getPROTEIN_STANDARD() {
        return PROTEIN_STANDARD;
    }

    @Override
    public int getPOTASSIUM_STANDARD() {
        return POTASSIUM_STANDARD;
    }

    @Override
    public String toString() {
        return "StandardRecommendedDailyAllowance{" +
                "Calories: " + CALORIES_STANDARD +
                ", Total Fat: " + TOTALFAT_STANDARD +
                ", Saturated Fat: " + SATURATEDFAT_STANDARD +
                ", Cholesterol: " + CHOLESTEROL_STANDARD +
                ", Sodium: " + SODIUM_STANDARD +
                ", Carbohydrates: " + TOTALCARB_STANDARD +
                ", Dietary Fiber: " + DIETARYFIBER_STANDARD +
                ", Sugar: " + SUGAR_STANDARD +
                ", Protein: " + PROTEIN_STANDARD +
                ", Potassium: " + POTASSIUM_STANDARD +
                '}';
    }
}
