
package com.nutritionist.favorite.domain.dataSchema.search;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "query",
    "generalSearchInput",
    "pageNumber",
    "numberOfResultsPerPage",
    "pageSize",
    "requireAllWords"
})
@Generated("jsonschema2pojo")
public class FoodSearchCriteria {

    @JsonProperty("query")
    private String query;
    @JsonProperty("generalSearchInput")
    private String generalSearchInput;
    @JsonProperty("pageNumber")
    private Integer pageNumber;
    @JsonProperty("numberOfResultsPerPage")
    private Integer numberOfResultsPerPage;
    @JsonProperty("pageSize")
    private Integer pageSize;
    @JsonProperty("requireAllWords")
    private Boolean requireAllWords;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    @JsonProperty("generalSearchInput")
    public String getGeneralSearchInput() {
        return generalSearchInput;
    }

    @JsonProperty("generalSearchInput")
    public void setGeneralSearchInput(String generalSearchInput) {
        this.generalSearchInput = generalSearchInput;
    }

    @JsonProperty("pageNumber")
    public Integer getPageNumber() {
        return pageNumber;
    }

    @JsonProperty("pageNumber")
    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    @JsonProperty("numberOfResultsPerPage")
    public Integer getNumberOfResultsPerPage() {
        return numberOfResultsPerPage;
    }

    @JsonProperty("numberOfResultsPerPage")
    public void setNumberOfResultsPerPage(Integer numberOfResultsPerPage) {
        this.numberOfResultsPerPage = numberOfResultsPerPage;
    }

    @JsonProperty("pageSize")
    public Integer getPageSize() {
        return pageSize;
    }

    @JsonProperty("pageSize")
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    @JsonProperty("requireAllWords")
    public Boolean getRequireAllWords() {
        return requireAllWords;
    }

    @JsonProperty("requireAllWords")
    public void setRequireAllWords(Boolean requireAllWords) {
        this.requireAllWords = requireAllWords;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
