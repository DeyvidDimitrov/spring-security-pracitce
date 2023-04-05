package com.practice.ssp.constants;

public interface PathConstants extends CommonPaths {

    String PATH_DETAILS_LIGHT_PUBLIC = "/public_details_light";
    // COMMON
    String PATH_API = "api";

    // AUTH

    String PATH_HOME = "";

    String PATH_REGISTER = "/register";
    String PATH_LOGIN = "/login";
    String PATH_REFRESH = "/refresh";

    String PATH_BIOLOGICAL_DATA = "/biological-data";
    String PATH_BIOLOGICAL_DATA_ADD = PATH_BIOLOGICAL_DATA + "/add";
    String PATH_BIOLOGICAL_DATA_UPDATE = PATH_BIOLOGICAL_DATA + "/update";

    String PATH_MEASUREMENTS = "/measurements";
    String PATH_MEASUREMENT_GET_BY_ID = PATH_MEASUREMENTS + "/{id}";
    String PATH_ALL_MEASUREMENTS_GET_BY_USER_ID = PATH_MEASUREMENTS + "/all/{id}";
    String PATH_CURRENT_USER_ALL_MEASUREMENTS = PATH_MEASUREMENTS + "/all";
    String PATH_MEASUREMENTS_ADD = PATH_MEASUREMENTS + "/add";
    String PATH_MEASUREMENTS_UPDATE = PATH_MEASUREMENTS + "/update";
    String PATH_MEASUREMENTS_REMOVE = PATH_MEASUREMENTS + "/remove";

    String PATH_MEASUREMENT_HISTORY = PATH_MEASUREMENTS + "/history";

    // NOMENCLATURES
    String PATH_NOMENCLATURES = PATH_API + "/nomenclatures";
    String PATH_ALL_ACCOUNT_DEACTIVATION_REASONS = "/all-account-deactivation-reasons";
    String PATH_ACCOUNT_DEACTIVATION_REASONS_BY_ID = "/account-deactivation-reason/{id}";
    String PATH_ALL_FOOD_THERMIC_EFFECTS = "/all-food-thermic-effects";
    String PATH_FOOD_THERMIC_EFFECTS_BY_ID = "/food-thermic-effect/{id}";
    String PATH_ALL_PHYSICAL_ACTIVITY_FACTORS = "/all-physical-activity-factors";
    String PATH_PHYSICAL_ACTIVITY_FACTORS_BY_ID = "/physical-activity-factor/{id}";
    String PATH_ALL_ENERGY_BALANCE_FACTORS = "/all-energy-balance-factors";
    String PATH_ENERGY_BALANCE_FACTOR_BY_ID = "/energy-balance-factor/{id}";

    // ADMIN
    String PATH_ADMIN = PATH_API + "/admin";
    String PATH_DETAILS_BY_ID = "/{id}/details";
    String PATH_LIGHT_BY_ID = "/{id}/light";
    String PATH_ALL_LIGHT = "/all-light";
    String PATH_ALL_DETAILS = "/all-details";
    String PATH_DEACTIVATE_BY_ID = "/deactivate/{id}";
    String PATH_CHANGE_PASSWORD = "/change-password";
    String PATH_CHANGE_EMAIL = "/change-email";
    String PATH_UPDATE_USER = "/update-user";

    String PATH_GET_TOTAL_WEIGHT_LOST = "/total-weight";

    String PATH_TARGET_MACROS_BY_USER_ID = "/target-macros/{userId}";

    // CURRENT USER

    // USER
    String PATH_CURRENT = PATH_API + "/current";
    String PATH_CURRENT_USER_TARGET_MACROS = "/target-macros";
    String PATH_REMAINING_TARGET_MACROS = "/remaining-target-macros/{date}";
    String PATH_CURRENT_USER_LIGHT = "/light";
    String PATH_CURRENT_USER_DETAILS = "/details";
    String PATH_CURRENT_USER_GENERATE = "/generate";

    // FOOD
    String PATH_GET_FOOD_BY_ID = "/food/{id}";

    String PATH_CONSUMED_FOOD = "/consumed-food";
    String PATH_GET_CONSUMED_FOOD_BY_ID = PATH_CONSUMED_FOOD + "/{id}";
    String PATH_CREATE_CONSUMED_FOOD = PATH_CONSUMED_FOOD + "/create";
    String PATH_UPDATE_CONSUMED_FOOD = PATH_CONSUMED_FOOD + "/update";
    String PATH_GET_DAILY_CONSUMED_FOODS = PATH_CONSUMED_FOOD + "/daily";
    String PATH_GET_CONSUMED_FOODS_BY_DATE = PATH_CONSUMED_FOOD + "/date/{date}";
    String PATH_DELETE_CONSUMED_FOOD_BY_ID = PATH_CONSUMED_FOOD + "/delete/{id}";
}