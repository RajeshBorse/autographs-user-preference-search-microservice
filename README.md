# University of Leicester - Masters Project

Autographs is an application designed and developed as a part of an academic project for the year 2021/22. This is designed and developed by Rajesh Borse (rsb34)

## Requirements
As per the project requirements, we are expected to display the cloud-based data in the form of charts to android mobile users.

## Microservice

Autographs User Preference Search Microservice - This is a spring-boot java microservice which has RESTful APIs which will be used by the android mobile application for displaying the charts in the frontend systems based on the service response.

Below are the services that this microservice serves.

- User Preference Search.

Below are the endpoints that are exposed by this microservice.

## User Preference Search

- GET API Endpoint - Used for fetching all the User Preference Search data from the MongoDB database.


```bash
/api/v1/userPreferencesSearch/getUserPreferencesDataByQuery
```


- POST API Endpoint - Used for inserting all the User Preference Search data in the MongoDB database.

```bash
/api/v1/userPreferencesSearch/addAllUserPreferencesDataByQuery
```


- DELETE API Endpoint - Used for deleting all the User Preference Search in the MongoDB database.
```bash
/api/v1/userPreferencesSearch/deleteAllUserPreferencesDataByQuery
```

