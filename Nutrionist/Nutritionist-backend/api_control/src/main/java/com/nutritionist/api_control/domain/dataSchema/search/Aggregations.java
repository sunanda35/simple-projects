
package com.nutritionist.api_control.domain.dataSchema.search;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "dataType",
    "nutrients"
})
@Generated("jsonschema2pojo")
public class Aggregations {

    @JsonProperty("dataType")
    private DataType dataType;
    @JsonProperty("nutrients")
    private Nutrients nutrients;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("dataType")
    public DataType getDataType() {
        return dataType;
    }

    @JsonProperty("dataType")
    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    @JsonProperty("nutrients")
    public Nutrients getNutrients() {
        return nutrients;
    }

    @JsonProperty("nutrients")
    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
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
