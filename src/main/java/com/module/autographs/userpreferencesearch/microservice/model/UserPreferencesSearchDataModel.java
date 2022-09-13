package com.module.autographs.userpreferencesearch.microservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userPreferencesCollection")
public class UserPreferencesSearchDataModel {

    @Id
    private String id;
    private String year;
    private String month;
    private String searchType;
    private String searchValue;
    private String count;

    public UserPreferencesSearchDataModel() {
    }

    public UserPreferencesSearchDataModel(String id, String year, String month, String searchType, String searchValue, String count) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.searchType = searchType;
        this.searchValue = searchValue;
        this.count = count;
    }

    @Override
    public String toString() {
        return "UserPreferencesSearchDataModel{" +
                "id='" + id + '\'' +
                ", year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", searchType='" + searchType + '\'' +
                ", searchValue='" + searchValue + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }
}