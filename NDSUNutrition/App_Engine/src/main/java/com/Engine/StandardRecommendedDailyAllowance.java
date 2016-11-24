package com.Engine;

/**
 *
 * @author donovan.beckmann
 */
public class StandardRecommendedDailyAllowance {
    private final int CALORIES_STANDARD = 2000;
    private final int TOTALFAT_STANDARD = 65;
    private final int SATURATEDFAT_STANDARD = 20;
    private final int CHOLESTEROL_STANDARD = 300;
    private final int SODIUM_STANDARD = 2400;
    private final int TOTALCARB_STANDARD = 300;
    private final int DIETARYFIBER_STANDARD = 25;
    private final int SUGAR_STANDARD = 25;
    private final int PROTEIN_STANDARD = 50;
    private final int POTASSIUM_STANDARD = 3500;

    public StandardRecommendedDailyAllowance() {
    }

    public int getCALORIES_STANDARD() {
        return CALORIES_STANDARD;
    }

    public int getTOTALFAT_STANDARD() {
        return TOTALFAT_STANDARD;
    }

    public int getSATURATEDFAT_STANDARD() {
        return SATURATEDFAT_STANDARD;
    }

    public int getCHOLESTEROL_STANDARD() {
        return CHOLESTEROL_STANDARD;
    }

    public int getSODIUM_STANDARD() {
        return SODIUM_STANDARD;
    }

    public int getTOTALCARB_STANDARD() {
        return TOTALCARB_STANDARD;
    }

    public int getDIETARYFIBER_STANDARD() {
        return DIETARYFIBER_STANDARD;
    }

    public int getSUGAR_STANDARD() {
        return SUGAR_STANDARD;
    }

    public int getPROTEIN_STANDARD() {
        return PROTEIN_STANDARD;
    }

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
