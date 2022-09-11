package com.module.autographs.userpreferencesearch.microservice.service;

import com.module.autographs.userpreferencesearch.microservice.model.UserPreferencesSearchDataModel;

import java.util.List;

public interface UserPreferencesSearchService {

    List<UserPreferencesSearchDataModel> findAll();

    List<UserPreferencesSearchDataModel> addUserPreferencesSearchData(List<UserPreferencesSearchDataModel> userPreferencesSearchDataModelList);

    List<UserPreferencesSearchDataModel> findAllUserPreferencesSearchByType(String searchType,String searchValue);


}
