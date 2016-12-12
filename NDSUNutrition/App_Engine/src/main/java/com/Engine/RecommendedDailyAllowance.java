/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Engine;

import java.util.List;

/**
 * @author mitchell.olson.1
 */
public interface RecommendedDailyAllowance {

    int CALORIES_STANDARD = 2000;
    int TOTALFAT_STANDARD = 65;
    int SATURATEDFAT_STANDARD = 20;
    int CHOLESTEROL_STANDARD = 300;
    int SODIUM_STANDARD = 2400;
    int TOTALCARB_STANDARD = 300;
    int DIETARYFIBER_STANDARD = 25;
    int SUGAR_STANDARD = 25;
    int PROTEIN_STANDARD = 50;
    int POTASSIUM_STANDARD = 3500;

    public List<NutrientTotal> getAdjustedRDA(int calories);

    public int getCALORIES_STANDARD();

    public int getTOTALFAT_STANDARD();

    public int getSATURATEDFAT_STANDARD();

    public int getCHOLESTEROL_STANDARD();

    public int getSODIUM_STANDARD();

    public int getTOTALCARB_STANDARD();

    public int getDIETARYFIBER_STANDARD();

    public int getSUGAR_STANDARD();

    public int getPROTEIN_STANDARD();

    public int getPOTASSIUM_STANDARD();
}