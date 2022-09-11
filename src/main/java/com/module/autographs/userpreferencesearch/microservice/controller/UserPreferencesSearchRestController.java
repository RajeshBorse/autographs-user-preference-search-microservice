package com.module.autographs.userpreferencesearch.microservice.controller;

import com.module.autographs.userpreferencesearch.microservice.dto.UserPreferencesSearchDTO;
import com.module.autographs.userpreferencesearch.microservice.model.UserPreferencesSearchDataModel;
import com.module.autographs.userpreferencesearch.microservice.repository.UserPreferencesSearchRepository;
import com.module.autographs.userpreferencesearch.microservice.service.UserPreferencesSearchService;
import com.module.autographs.userpreferencesearch.microservice.util.Constants;
import com.module.autographs.userpreferencesearch.microservice.util.ObjectMapperUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userPreferencesSearch")
@Tag(name = "UserPreferencesSearch")

public class UserPreferencesSearchRestController {

    @Autowired
    private UserPreferencesSearchService userPreferencesSearchService;

    @Autowired
    private UserPreferencesSearchRepository userPreferencesSearchRepository;

    @GetMapping(value = Constants.USER_PREFERENCES_SEARCH_GET_API_PATH)
    @Operation(summary = Constants.USER_PREFERENCES_SEARCH_GET_SUMMARY, responses = {@ApiResponse(description = Constants.USER_PREFERENCES_SEARCH_SUCCESS, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserPreferencesSearchDTO.class))), @ApiResponse(description = Constants.USER_PREFERENCES_SEARCH_NO_DATA_FOUND, responseCode = Constants.HTTP_RESPONSE_CODE_OK, content = @Content)})
    public List<UserPreferencesSearchDTO> getUserPreferencesSearchByQuery(@RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) {
        List<UserPreferencesSearchDTO> userPreferencesSearchDTOList = ObjectMapperUtils.mapAll(userPreferencesSearchService.findAllUserPreferencesSearchByType(searchType,searchValue), UserPreferencesSearchDTO.class);
        if (userPreferencesSearchDTOList.size() > 0) {
            return ResponseEntity.ok(userPreferencesSearchDTOList).getBody();
        } else {
            throw new ResponseStatusException(HttpStatus.OK, Constants.USER_PREFERENCES_SEARCH_NO_DATA_FOUND);
        }
    }

    @PostMapping(value = Constants.USER_PREFERENCES_SEARCH_POST_API_PATH)
    @Operation(summary = Constants.USER_PREFERENCES_SEARCH_POST_SUMMARY, responses = {@ApiResponse(description = Constants.USER_PREFERENCES_SEARCH_ADD_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = UserPreferencesSearchDTO.class))), @ApiResponse(description = Constants.USER_PREFERENCES_SEARCH_ADD_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> addUserPreferencesSearchData(@RequestBody List<UserPreferencesSearchDTO> userPreferencesSearchDTOList) {
        List<UserPreferencesSearchDataModel> userPreferencesSearchDataModelList = userPreferencesSearchService.addUserPreferencesSearchData(ObjectMapperUtils.mapAll(userPreferencesSearchDTOList, UserPreferencesSearchDataModel.class));
        if (userPreferencesSearchDataModelList.size() > 0) {
            return ResponseEntity.ok(Constants.USER_PREFERENCES_SEARCH_ADD_SUCCESS);
        } else {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, Constants.USER_PREFERENCES_SEARCH_ADD_FAILURE);
        }
    }

    @DeleteMapping(value = Constants.USER_PREFERENCES_SEARCH_DELETE_ALL_API_PATH)
    @Operation(summary = Constants.USER_PREFERENCES_SEARCH_DELETE_ALL_SUMMARY, responses = {@ApiResponse(description = Constants.USER_PREFERENCES_SEARCH_DELETE_ALL_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = UserPreferencesSearchDTO.class))), @ApiResponse(description = Constants.USER_PREFERENCES_SEARCH_DELETE_ALL_FAILURE, responseCode = Constants.HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> deleteAllUserPreferencesSearchData() {
        userPreferencesSearchRepository.deleteAll();
        return ResponseEntity.ok(Constants.USER_PREFERENCES_SEARCH_DELETE_ALL_SUCCESS);
    }

}