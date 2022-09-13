package com.module.autographs.userpreferencesearch.microservice.util;

public class Constants {

    // HTTP STATUS CODES
    public static final String HTTP_RESPONSE_CODE_OK = "200";
    public static final String HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR = "500";

    // ALL API PATHS

    // 1 - USER PREFERENCES SEARCH
    public static final String GET_API_PATH = "/getUserPreferencesDataByQuery";
    public static final String POST_API_PATH = "/addAllUserPreferencesDataByQuery";
    public static final String DELETE_ALL_API_PATH = "/deleteAllUserPreferencesDataByQuery";


    // ALL SWAGGER CONSTANTS BELOW ---------------------------------------------------------------------------------------------------------

    // 1 - USER PREFERENCE SEARCH
    // GET API
    public static final String SWAGGER_GET_API_SUMMARY = "GET - USER PREFERENCES DATA";
    public static final String SWAGGER_GET_API_SUCCESS = "USER PREFERENCES DATA FETCHED SUCCESSFULLY.";
    public static final String SWAGGER_GET_API_NO_DATA_FOUND = "NO DATA FOUND FOR USER PREFERENCES";
    // POST API
    public static final String SWAGGER_POST_API_SUMMARY = "POST - USER PREFERENCES DATA";
    public static final String SWAGGER_POST_API_SUCCESS = "USER PREFERENCES DATA ADDED SUCCESSFULLY.";
    public static final String SWAGGER_POST_API_FAILURE = "FAILURE OCCURRED WHILE ADDING USER PREFERENCES DATA.";
    // DELETE API
    public static final String SWAGGER_DELETE_API_SUMMARY = "DELETE ALL - USER PREFERENCES DATA";
    public static final String SWAGGER_DELETE_API_SUCCESS = "USER PREFERENCES DATA DELETED SUCCESSFULLY.";
    public static final String SWAGGER_DELETE_API_FAILURE = "FAILURE OCCURRED WHILE DELETING USER PREFERENCES DATA.";

    // LOGGER CONSTANTS ---------------------------------------------------
    public static final String LOGGER_GET_API_SUCCESS = "NewCarRegistrationsRestController : LOGGER : GET API : Data Fetch Success";
    public static final String LOGGER_GET_API_FAILURE = "NewCarRegistrationsRestController : LOGGER : GET API : Data Fetch Failure";
    public static final String LOGGER_POST_API_SUCCESS = "NewCarRegistrationsRestController : LOGGER : POST API : Data Adding Success";
    public static final String LOGGER_POST_API_FAILURE = "NewCarRegistrationsRestController : LOGGER : POST API : Data Adding Failure";
    public static final String LOGGER_DELETE_API_SUCCESS = "NewCarRegistrationsRestController : LOGGER : DELETE API : Data Deleting Success";
}
