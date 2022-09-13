package com.module.autographs.userpreferencesearch.microservice.controller;

import com.module.autographs.userpreferencesearch.microservice.AutographsUserPreferenceSearchApplication;
import com.module.autographs.userpreferencesearch.microservice.dto.UserPreferencesSearchDTO;
import com.module.autographs.userpreferencesearch.microservice.model.UserPreferencesSearchDataModel;
import com.module.autographs.userpreferencesearch.microservice.repository.UserPreferencesSearchRepository;
import com.module.autographs.userpreferencesearch.microservice.service.UserPreferencesSearchService;
import com.module.autographs.userpreferencesearch.microservice.util.ObjectMapperUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static com.module.autographs.userpreferencesearch.microservice.util.Constants.*;


@RestController
@RequestMapping("/api/v1/userPreferencesSearch")
@Tag(name = "UserPreferencesSearchRestController")

public class UserPreferencesSearchRestController {

    @Autowired
    private UserPreferencesSearchService userPreferencesSearchService;

    @Autowired
    private UserPreferencesSearchRepository userPreferencesSearchRepository;

    private static final Logger logger = LogManager.getLogger(AutographsUserPreferenceSearchApplication.class);

    @GetMapping(value = GET_API_PATH)
    @Operation(summary = SWAGGER_GET_API_SUMMARY, responses = {@ApiResponse(description = SWAGGER_GET_API_SUCCESS, responseCode = HTTP_RESPONSE_CODE_OK, content = @Content(mediaType = "application/json", schema = @Schema(implementation = UserPreferencesSearchDTO.class))), @ApiResponse(description = SWAGGER_GET_API_NO_DATA_FOUND, responseCode = HTTP_RESPONSE_CODE_OK, content = @Content)})
    public List<UserPreferencesSearchDTO> getUserPreferencesSearchByQuery(@RequestParam(required = false) String searchType, @RequestParam(required = false) String searchValue) {
        List<UserPreferencesSearchDTO> userPreferencesSearchDTOList = ObjectMapperUtils.mapAll(userPreferencesSearchService.findAllUserPreferencesSearchByType(searchType, searchValue), UserPreferencesSearchDTO.class);
        if (userPreferencesSearchDTOList.size() > 0) {
            logger.info(LOGGER_GET_API_SUCCESS);
            return ResponseEntity.ok(userPreferencesSearchDTOList).getBody();
        } else {
            logger.info(LOGGER_GET_API_FAILURE);
            throw new ResponseStatusException(HttpStatus.OK, SWAGGER_GET_API_NO_DATA_FOUND);
        }
    }

    @PostMapping(value = POST_API_PATH)
    @Operation(summary = SWAGGER_POST_API_SUMMARY, responses = {@ApiResponse(description = SWAGGER_POST_API_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = UserPreferencesSearchDTO.class))), @ApiResponse(description = SWAGGER_POST_API_FAILURE, responseCode = HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> addUserPreferencesSearchData(@RequestBody List<UserPreferencesSearchDTO> userPreferencesSearchDTOList) {
        List<UserPreferencesSearchDataModel> userPreferencesSearchDataModelList = userPreferencesSearchService.addUserPreferencesSearchData(ObjectMapperUtils.mapAll(userPreferencesSearchDTOList, UserPreferencesSearchDataModel.class));
        if (userPreferencesSearchDataModelList.size() > 0) {
            logger.info(LOGGER_POST_API_SUCCESS);
            return ResponseEntity.ok(SWAGGER_POST_API_SUCCESS);
        } else {
            logger.info(LOGGER_POST_API_FAILURE);
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, SWAGGER_POST_API_FAILURE);
        }
    }

    @DeleteMapping(value = DELETE_ALL_API_PATH)
    @Operation(summary = SWAGGER_DELETE_API_SUMMARY, responses = {@ApiResponse(description = SWAGGER_DELETE_API_SUCCESS, responseCode = "200", content = @Content(mediaType = "application/text", schema = @Schema(implementation = UserPreferencesSearchDTO.class))), @ApiResponse(description = SWAGGER_DELETE_API_FAILURE, responseCode = HTTP_RESPONSE_CODE_INTERNAL_SERVER_ERROR, content = @Content)})
    public ResponseEntity<?> deleteAllUserPreferencesSearchData() {
        logger.info(LOGGER_DELETE_API_SUCCESS);
        userPreferencesSearchRepository.deleteAll();
        return ResponseEntity.ok(SWAGGER_DELETE_API_SUCCESS);
    }

}