
package com.nutritionist.favorite.domain.dataSchema.search;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "fdcId",
    "description",
    "lowercaseDescription",
    "dataType",
    "gtinUpc",
    "publishedDate",
    "brandOwner",
    "ingredients",
    "marketCountry",
    "foodCategory",
    "modifiedDate",
    "dataSource",
    "servingSizeUnit",
    "servingSize",
    "householdServingFullText",
    "allHighlightFields",
    "score",
    "foodNutrients",
    "finalFoodInputFoods",
    "foodMeasures",
    "foodAttributes",
    "foodAttributeTypes",
    "foodVersionIds",
    "brandName",
    "packageWeight"
})
@Generated("jsonschema2pojo")
public class Food {

    @JsonProperty("fdcId")
    private Integer fdcId;
    @JsonProperty("description")
    private String description;
    @JsonProperty("lowercaseDescription")
    private String lowercaseDescription;
    @JsonProperty("dataType")
    private String dataType;
    @JsonProperty("gtinUpc")
    private String gtinUpc;
    @JsonProperty("publishedDate")
    private String publishedDate;
    @JsonProperty("brandOwner")
    private String brandOwner;
    @JsonProperty("ingredients")
    private String ingredients;
    @JsonProperty("marketCountry")
    private String marketCountry;
    @JsonProperty("foodCategory")
    private String foodCategory;
    @JsonProperty("modifiedDate")
    private String modifiedDate;
    @JsonProperty("dataSource")
    private String dataSource;
    @JsonProperty("servingSizeUnit")
    private String servingSizeUnit;
    @JsonProperty("servingSize")
    private Double servingSize;
    @JsonProperty("householdServingFullText")
    private String householdServingFullText;
    @JsonProperty("allHighlightFields")
    private String allHighlightFields;
    @JsonProperty("score")
    private Double score;
    @JsonProperty("foodNutrients")
    private List<FoodNutrient> foodNutrients = null;
    @JsonProperty("finalFoodInputFoods")
    private List<Object> finalFoodInputFoods = null;
    @JsonProperty("foodMeasures")
    private List<Object> foodMeasures = null;
    @JsonProperty("foodAttributes")
    private List<Object> foodAttributes = null;
    @JsonProperty("foodAttributeTypes")
    private List<Object> foodAttributeTypes = null;
    @JsonProperty("foodVersionIds")
    private List<Object> foodVersionIds = null;
    @JsonProperty("brandName")
    private String brandName;
    @JsonProperty("packageWeight")
    private String packageWeight;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("fdcId")
    public Integer getFdcId() {
        return fdcId;
    }

    @JsonProperty("fdcId")
    public void setFdcId(Integer fdcId) {
        this.fdcId = fdcId;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("lowercaseDescription")
    public String getLowercaseDescription() {
        return lowercaseDescription;
    }

    @JsonProperty("lowercaseDescription")
    public void setLowercaseDescription(String lowercaseDescription) {
        this.lowercaseDescription = lowercaseDescription;
    }

    @JsonProperty("dataType")
    public String getDataType() {
        return dataType;
    }

    @JsonProperty("dataType")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @JsonProperty("gtinUpc")
    public String getGtinUpc() {
        return gtinUpc;
    }

    @JsonProperty("gtinUpc")
    public void setGtinUpc(String gtinUpc) {
        this.gtinUpc = gtinUpc;
    }

    @JsonProperty("publishedDate")
    public String getPublishedDate() {
        return publishedDate;
    }

    @JsonProperty("publishedDate")
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    @JsonProperty("brandOwner")
    public String getBrandOwner() {
        return brandOwner;
    }

    @JsonProperty("brandOwner")
    public void setBrandOwner(String brandOwner) {
        this.brandOwner = brandOwner;
    }

    @JsonProperty("ingredients")
    public String getIngredients() {
        return ingredients;
    }

    @JsonProperty("ingredients")
    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @JsonProperty("marketCountry")
    public String getMarketCountry() {
        return marketCountry;
    }

    @JsonProperty("marketCountry")
    public void setMarketCountry(String marketCountry) {
        this.marketCountry = marketCountry;
    }

    @JsonProperty("foodCategory")
    public String getFoodCategory() {
        return foodCategory;
    }

    @JsonProperty("foodCategory")
    public void setFoodCategory(String foodCategory) {
        this.foodCategory = foodCategory;
    }

    @JsonProperty("modifiedDate")
    public String getModifiedDate() {
        return modifiedDate;
    }

    @JsonProperty("modifiedDate")
    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @JsonProperty("dataSource")
    public String getDataSource() {
        return dataSource;
    }

    @JsonProperty("dataSource")
    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    @JsonProperty("servingSizeUnit")
    public String getServingSizeUnit() {
        return servingSizeUnit;
    }

    @JsonProperty("servingSizeUnit")
    public void setServingSizeUnit(String servingSizeUnit) {
        this.servingSizeUnit = servingSizeUnit;
    }

    @JsonProperty("servingSize")
    public Double getServingSize() {
        return servingSize;
    }

    @JsonProperty("servingSize")
    public void setServingSize(Double servingSize) {
        this.servingSize = servingSize;
    }

    @JsonProperty("householdServingFullText")
    public String getHouseholdServingFullText() {
        return householdServingFullText;
    }

    @JsonProperty("householdServingFullText")
    public void setHouseholdServingFullText(String householdServingFullText) {
        this.householdServingFullText = householdServingFullText;
    }

    @JsonProperty("allHighlightFields")
    public String getAllHighlightFields() {
        return allHighlightFields;
    }

    @JsonProperty("allHighlightFields")
    public void setAllHighlightFields(String allHighlightFields) {
        this.allHighlightFields = allHighlightFields;
    }

    @JsonProperty("score")
    public Double getScore() {
        return score;
    }

    @JsonProperty("score")
    public void setScore(Double score) {
        this.score = score;
    }

    @JsonProperty("foodNutrients")
    public List<FoodNutrient> getFoodNutrients() {
        return foodNutrients;
    }

    @JsonProperty("foodNutrients")
    public void setFoodNutrients(List<FoodNutrient> foodNutrients) {
        this.foodNutrients = foodNutrients;
    }

    @JsonProperty("finalFoodInputFoods")
    public List<Object> getFinalFoodInputFoods() {
        return finalFoodInputFoods;
    }

    @JsonProperty("finalFoodInputFoods")
    public void setFinalFoodInputFoods(List<Object> finalFoodInputFoods) {
        this.finalFoodInputFoods = finalFoodInputFoods;
    }

    @JsonProperty("foodMeasures")
    public List<Object> getFoodMeasures() {
        return foodMeasures;
    }

    @JsonProperty("foodMeasures")
    public void setFoodMeasures(List<Object> foodMeasures) {
        this.foodMeasures = foodMeasures;
    }

    @JsonProperty("foodAttributes")
    public List<Object> getFoodAttributes() {
        return foodAttributes;
    }

    @JsonProperty("foodAttributes")
    public void setFoodAttributes(List<Object> foodAttributes) {
        this.foodAttributes = foodAttributes;
    }

    @JsonProperty("foodAttributeTypes")
    public List<Object> getFoodAttributeTypes() {
        return foodAttributeTypes;
    }

    @JsonProperty("foodAttributeTypes")
    public void setFoodAttributeTypes(List<Object> foodAttributeTypes) {
        this.foodAttributeTypes = foodAttributeTypes;
    }

    @JsonProperty("foodVersionIds")
    public List<Object> getFoodVersionIds() {
        return foodVersionIds;
    }

    @JsonProperty("foodVersionIds")
    public void setFoodVersionIds(List<Object> foodVersionIds) {
        this.foodVersionIds = foodVersionIds;
    }

    @JsonProperty("brandName")
    public String getBrandName() {
        return brandName;
    }

    @JsonProperty("brandName")
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @JsonProperty("packageWeight")
    public String getPackageWeight() {
        return packageWeight;
    }

    @JsonProperty("packageWeight")
    public void setPackageWeight(String packageWeight) {
        this.packageWeight = packageWeight;
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
