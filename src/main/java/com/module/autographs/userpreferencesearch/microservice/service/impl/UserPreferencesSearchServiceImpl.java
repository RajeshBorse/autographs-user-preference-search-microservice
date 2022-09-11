package com.module.autographs.userpreferencesearch.microservice.service.impl;

import com.module.autographs.userpreferencesearch.microservice.model.UserPreferencesSearchDataModel;
import com.module.autographs.userpreferencesearch.microservice.repository.UserPreferencesSearchRepository;
import com.module.autographs.userpreferencesearch.microservice.service.UserPreferencesSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserPreferencesSearchServiceImpl implements UserPreferencesSearchService {

    @Autowired
    UserPreferencesSearchRepository userPreferencesSearchRepository;

    @Override
    public List<UserPreferencesSearchDataModel> findAll() {
        return userPreferencesSearchRepository.findAll();
    }

    @Override
    public List<UserPreferencesSearchDataModel> addUserPreferencesSearchData(List<UserPreferencesSearchDataModel> userPreferencesSearchDataModelList) {
        return userPreferencesSearchRepository.saveAll(userPreferencesSearchDataModelList);
    }

    public List<UserPreferencesSearchDataModel> findAllUserPreferencesSearchByType(String searchType, String searchValue) {
        List<UserPreferencesSearchDataModel> userPreferencesSearchDataModelList = userPreferencesSearchRepository.findAllUserPreferencesSearchByType(searchType, searchValue);
        return userPreferencesSearchDataModelList;
    }

}