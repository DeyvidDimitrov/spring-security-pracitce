package com.practice.ssp.constants;

public interface CommonPaths {
	// COMMON
	String PATH_API = "/api";

	// Foods
	String PATH_FOODS = PATH_API + "/foods";
	String PATH_FOOD_BY_ID = PATH_FOODS + "/{id}";
	String PATH_FOOD_VERIFY_BY_ID = PATH_FOODS + "/verify/{id}";

	// Recipes
	String PATH_RECIPE = PATH_API + "/recipes";

	// Users
	String PATH_USERS = PATH_API + "/users";
	String PATH_USER_LIGHT_BY_ID = PATH_USERS + "/{id}/light";
	String PATH_DETAILS_LIGHT_PUBLIC = "/public_details_light";

}