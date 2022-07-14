
package com.nutritionist.favorite.domain.dataSchema.search;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nutrientId",
    "nutrientName",
    "nutrientNumber",
    "unitName",
    "derivationCode",
    "derivationDescription",
    "derivationId",
    "value",
    "foodNutrientSourceId",
    "foodNutrientSourceCode",
    "foodNutrientSourceDescription",
    "rank",
    "indentLevel",
    "foodNutrientId",
    "percentDailyValue"
})
@Generated("jsonschema2pojo")
public class FoodNutrient {

    @JsonProperty("nutrientId")
    private Integer nutrientId;
    @JsonProperty("nutrientName")
    private String nutrientName;
    @JsonProperty("nutrientNumber")
    private String nutrientNumber;
    @JsonProperty("unitName")
    private String unitName;
    @JsonProperty("derivationCode")
    private String derivationCode;
    @JsonProperty("derivationDescription")
    private String derivationDescription;
    @JsonProperty("derivationId")
    private Integer derivationId;
    @JsonProperty("value")
    private Double value;
    @JsonProperty("foodNutrientSourceId")
    private Integer foodNutrientSourceId;
    @JsonProperty("foodNutrientSourceCode")
    private String foodNutrientSourceCode;
    @JsonProperty("foodNutrientSourceDescription")
    private String foodNutrientSourceDescription;
    @JsonProperty("rank")
    private Integer rank;
    @JsonProperty("indentLevel")
    private Integer indentLevel;
    @JsonProperty("foodNutrientId")
    private Integer foodNutrientId;
    @JsonProperty("percentDailyValue")
    private Integer percentDailyValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nutrientId")
    public Integer getNutrientId() {
        return nutrientId;
    }

    @JsonProperty("nutrientId")
    public void setNutrientId(Integer nutrientId) {
        this.nutrientId = nutrientId;
    }

    @JsonProperty("nutrientName")
    public String getNutrientName() {
        return nutrientName;
    }

    @JsonProperty("nutrientName")
    public void setNutrientName(String nutrientName) {
        this.nutrientName = nutrientName;
    }

    @JsonProperty("nutrientNumber")
    public String getNutrientNumber() {
        return nutrientNumber;
    }

    @JsonProperty("nutrientNumber")
    public void setNutrientNumber(String nutrientNumber) {
        this.nutrientNumber = nutrientNumber;
    }

    @JsonProperty("unitName")
    public String getUnitName() {
        return unitName;
    }

    @JsonProperty("unitName")
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    @JsonProperty("derivationCode")
    public String getDerivationCode() {
        return derivationCode;
    }

    @JsonProperty("derivationCode")
    public void setDerivationCode(String derivationCode) {
        this.derivationCode = derivationCode;
    }

    @JsonProperty("derivationDescription")
    public String getDerivationDescription() {
        return derivationDescription;
    }

    @JsonProperty("derivationDescription")
    public void setDerivationDescription(String derivationDescription) {
        this.derivationDescription = derivationDescription;
    }

    @JsonProperty("derivationId")
    public Integer getDerivationId() {
        return derivationId;
    }

    @JsonProperty("derivationId")
    public void setDerivationId(Integer derivationId) {
        this.derivationId = derivationId;
    }

    @JsonProperty("value")
    public Double getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Double value) {
        this.value = value;
    }

    @JsonProperty("foodNutrientSourceId")
    public Integer getFoodNutrientSourceId() {
        return foodNutrientSourceId;
    }

    @JsonProperty("foodNutrientSourceId")
    public void setFoodNutrientSourceId(Integer foodNutrientSourceId) {
        this.foodNutrientSourceId = foodNutrientSourceId;
    }

    @JsonProperty("foodNutrientSourceCode")
    public String getFoodNutrientSourceCode() {
        return foodNutrientSourceCode;
    }

    @JsonProperty("foodNutrientSourceCode")
    public void setFoodNutrientSourceCode(String foodNutrientSourceCode) {
        this.foodNutrientSourceCode = foodNutrientSourceCode;
    }

    @JsonProperty("foodNutrientSourceDescription")
    public String getFoodNutrientSourceDescription() {
        return foodNutrientSourceDescription;
    }

    @JsonProperty("foodNutrientSourceDescription")
    public void setFoodNutrientSourceDescription(String foodNutrientSourceDescription) {
        this.foodNutrientSourceDescription = foodNutrientSourceDescription;
    }

    @JsonProperty("rank")
    public Integer getRank() {
        return rank;
    }

    @JsonProperty("rank")
    public void setRank(Integer rank) {
        this.rank = rank;
    }

    @JsonProperty("indentLevel")
    public Integer getIndentLevel() {
        return indentLevel;
    }

    @JsonProperty("indentLevel")
    public void setIndentLevel(Integer indentLevel) {
        this.indentLevel = indentLevel;
    }

    @JsonProperty("foodNutrientId")
    public Integer getFoodNutrientId() {
        return foodNutrientId;
    }

    @JsonProperty("foodNutrientId")
    public void setFoodNutrientId(Integer foodNutrientId) {
        this.foodNutrientId = foodNutrientId;
    }

    @JsonProperty("percentDailyValue")
    public Integer getPercentDailyValue() {
        return percentDailyValue;
    }

    @JsonProperty("percentDailyValue")
    public void setPercentDailyValue(Integer percentDailyValue) {
        this.percentDailyValue = percentDailyValue;
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
