
package com.nutritionist.favorite.domain.dataSchema.search;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "totalHits",
    "currentPage",
    "totalPages",
    "pageList",
    "foodSearchCriteria",
    "foods",
    "aggregations"
})
@Generated("jsonschema2pojo")
public class Data {

    @JsonProperty("totalHits")
    private Integer totalHits;
    @JsonProperty("currentPage")
    private Integer currentPage;
    @JsonProperty("totalPages")
    private Integer totalPages;
    @JsonProperty("pageList")
    private List<Integer> pageList = null;
    @JsonProperty("foodSearchCriteria")
    private FoodSearchCriteria foodSearchCriteria;
    @JsonProperty("foods")
    private List<Food> foods = null;
    @JsonProperty("aggregations")
    private Aggregations aggregations;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("totalHits")
    public Integer getTotalHits() {
        return totalHits;
    }

    @JsonProperty("totalHits")
    public void setTotalHits(Integer totalHits) {
        this.totalHits = totalHits;
    }

    @JsonProperty("currentPage")
    public Integer getCurrentPage() {
        return currentPage;
    }

    @JsonProperty("currentPage")
    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    @JsonProperty("totalPages")
    public Integer getTotalPages() {
        return totalPages;
    }

    @JsonProperty("totalPages")
    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    @JsonProperty("pageList")
    public List<Integer> getPageList() {
        return pageList;
    }

    @JsonProperty("pageList")
    public void setPageList(List<Integer> pageList) {
        this.pageList = pageList;
    }

    @JsonProperty("foodSearchCriteria")
    public FoodSearchCriteria getFoodSearchCriteria() {
        return foodSearchCriteria;
    }

    @JsonProperty("foodSearchCriteria")
    public void setFoodSearchCriteria(FoodSearchCriteria foodSearchCriteria) {
        this.foodSearchCriteria = foodSearchCriteria;
    }

    @JsonProperty("foods")
    public List<Food> getFoods() {
        return foods;
    }

    @JsonProperty("foods")
    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    @JsonProperty("aggregations")
    public Aggregations getAggregations() {
        return aggregations;
    }

    @JsonProperty("aggregations")
    public void setAggregations(Aggregations aggregations) {
        this.aggregations = aggregations;
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
