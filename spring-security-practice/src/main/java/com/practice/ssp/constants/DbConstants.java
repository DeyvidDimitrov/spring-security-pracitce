package com.practice.ssp.constants;

public interface DbConstants {
    // schemas
    String SCHEMA_PUBLIC = "public";

    // tables
    String TBL_USERS = "users";
    String TBL_BIOLOGICAL_DATA = "biological_data";
    String TBL_MEASUREMENT_VERSION = "measurement_version";
    String TBL_TARGET_MACROS = "target_macros";
    String TBL_ACCOUNT_DEACTIVATION_HISTORY = "account_deactivation_history";
    String TBL_N_ACCOUNT_DEACTIVATION_REASONS = "n_account_deactivation_reasons";
    String TBL_N_ENERGY_BALANCE_FACTOR = "n_energy_balance_factor";
    String TBL_N_PHYSICAL_ACTIVITY_FACTOR = "n_physical_activity_factor";
    String TBL_N_FOOD_THERMIC_EFFECT = "n_food_thermic_effect";
    String TBL_USER_MEASUREMENT_VERSION_RELATION = "user_measurement_version_relation";
    String TBL_USER_TARGET_MACROS_RELATION = "user_target_macros_relation";
    String TBL_CONSUMED_FOOD = "consumed_food";

    // sequences
    String SEQ_USERS_ID = "users_id_seq";
    String SEQ_ROLES_ID = "roles_id_seq";
    String SEQ_BIOLOGICAL_DATA_ID = "biological_data_id_seq";
    String SEQ_MEASUREMENT_VERSION_ID = "measurement_version_id_seq";
    String SEQ_TARGET_MACROS_ID = "target_macros_id_seq";
    String SEQ_ACCOUNT_DEACTIVATION_HISTORY_ID = "account_deactivation_history_id_seq";
    String SEQ_N_ACCOUNT_DEACTIVATION_REASONS_ID = "n_account_deactivation_reasons_id_seq";
    String SEQ_N_ENERGY_BALANCE_FACTOR_ID = "n_energy_balance_factor_id_seq";
    String SEQ_N_PHYSICAL_ACTIVITY_FACTOR_ID = "n_physical_activity_factor_id_seq";
    String SEQ_N_FOOD_THERMIC_EFFECT_ID = "n_food_thermic_effect_id_seq";
    String SEQ_USER_MEASUREMENT_VERSION_RELATION_ID = "user_measurement_version_relation_id_seq";
    String SEQ_USER_TARGET_MACROS_RELATION_ID = "user_target_macros_relation_id_seq";
    String SEQ_CONSUMED_FOOD_ID = "consumed_food_id_seq";

    // config
    int ALLOCATION_SIZE = 1;
}