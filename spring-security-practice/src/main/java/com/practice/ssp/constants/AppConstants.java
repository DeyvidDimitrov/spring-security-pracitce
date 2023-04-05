package com.practice.ssp.constants;

public interface AppConstants {
    String EMAIL_VALIDATOR_REGEX = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    String DATE_TIME_FORMAT = "dd-MM-yyyy HH:mm:ss";
    String DATE_FORMAT = "dd-MM-yyyy";
    String JSON_FORMAT = "yyyy-MM-dd";

    Integer FOOD_CONSUMED_BEFORE_AFTER_LIMIT_DAYS = 3;

    // Generation
    double PROTEIN_PER_KG_LEAN_MASS_FACTOR = 2.2;
    String TARGET_MACROS_TITLE = "Generated";

    // Constraints
    int USER_FIRST_NAME_MAX_SIZE = 30;
    int USER_LAST_NAME_MAX_SIZE = 30;
    int FOOD_NAME_MAX_SIZE = 50;
    String WEIGHT_MIN_VALUE_STRING = "20";
    double WEIGHT_MIN_VALUE = 20.0;
    int USER_MINIMAL_AGE = 18;
    int TARGET_MACROS_TITLE_MAX_SIZE = 100;

    int N_NAME_MAX_SIZE = 20;
    int N_DESCRIPTION_MAX_SIZE = 100;

    int N_ENERGY_BALANCE_FACTOR_MIN_VALUE = -25;
    int N_ENERGY_BALANCE_FACTOR_MAX_VALUE = 25;

    int N_FOOD_THERMIC_EFFECT_MIN_VALUE = 10;
    int N_FOOD_THERMIC_EFFECT_MAX_VALUE = 25;

    String N_PHYSICAL_ACTIVITY_FACTOR_MIN_VALUE = "1.00";
    String N_PHYSICAL_ACTIVITY_FACTOR_MAX_VALUE = "1.45";

    int N_MIN_INDEX = 1;
    int N_DEACTIVATE_REASON_MAX_INDEX = 3;
    int N_ENERGY_BALANCE_FACTOR_MAX_INDEX = 5;
    int N_FOOD_THERMIC_EFFECT_MAX_INDEX  = 4;
    int N_PHYSICAL_ACTIVITY_FACTOR_MAX_INDEX = 4;

    String secretKey = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecure";
}