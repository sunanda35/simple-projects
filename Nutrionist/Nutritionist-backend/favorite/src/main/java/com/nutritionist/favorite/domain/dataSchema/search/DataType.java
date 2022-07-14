
package com.nutritionist.favorite.domain.dataSchema.search;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Branded",
    "SR Legacy",
    "Survey (FNDDS)",
    "Foundation"
})
@Generated("jsonschema2pojo")
public class DataType {

    @JsonProperty("Branded")
    private Integer branded;
    @JsonProperty("SR Legacy")
    private Integer sRLegacy;
    @JsonProperty("Survey (FNDDS)")
    private Integer surveyFNDDS;
    @JsonProperty("Foundation")
    private Integer foundation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("Branded")
    public Integer getBranded() {
        return branded;
    }

    @JsonProperty("Branded")
    public void setBranded(Integer branded) {
        this.branded = branded;
    }

    @JsonProperty("SR Legacy")
    public Integer getSRLegacy() {
        return sRLegacy;
    }

    @JsonProperty("SR Legacy")
    public void setSRLegacy(Integer sRLegacy) {
        this.sRLegacy = sRLegacy;
    }

    @JsonProperty("Survey (FNDDS)")
    public Integer getSurveyFNDDS() {
        return surveyFNDDS;
    }

    @JsonProperty("Survey (FNDDS)")
    public void setSurveyFNDDS(Integer surveyFNDDS) {
        this.surveyFNDDS = surveyFNDDS;
    }

    @JsonProperty("Foundation")
    public Integer getFoundation() {
        return foundation;
    }

    @JsonProperty("Foundation")
    public void setFoundation(Integer foundation) {
        this.foundation = foundation;
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
