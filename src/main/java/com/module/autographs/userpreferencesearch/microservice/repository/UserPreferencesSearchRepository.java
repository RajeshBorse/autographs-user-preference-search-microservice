package com.module.autographs.userpreferencesearch.microservice.repository;

import com.module.autographs.userpreferencesearch.microservice.model.UserPreferencesSearchDataModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserPreferencesSearchRepository extends MongoRepository<UserPreferencesSearchDataModel, String> {

    @Query("{searchType:'?0', searchValue:'?1'}")
    List<UserPreferencesSearchDataModel> findAllUserPreferencesSearchByType(String searchType, String searchValue);

}