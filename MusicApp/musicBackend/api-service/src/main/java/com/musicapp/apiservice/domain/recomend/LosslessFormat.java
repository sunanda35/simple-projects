
package com.musicapp.apiservice.domain.recomend;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "bitrate",
    "name",
    "sampleBits",
    "sampleRate"
})
@Generated("jsonschema2pojo")
public class LosslessFormat {

    @JsonProperty("type")
    private String type;
    @JsonProperty("bitrate")
    private Integer bitrate;
    @JsonProperty("name")
    private String name;
    @JsonProperty("sampleBits")
    private Integer sampleBits;
    @JsonProperty("sampleRate")
    private Integer sampleRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("bitrate")
    public Integer getBitrate() {
        return bitrate;
    }

    @JsonProperty("bitrate")
    public void setBitrate(Integer bitrate) {
        this.bitrate = bitrate;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("sampleBits")
    public Integer getSampleBits() {
        return sampleBits;
    }

    @JsonProperty("sampleBits")
    public void setSampleBits(Integer sampleBits) {
        this.sampleBits = sampleBits;
    }

    @JsonProperty("sampleRate")
    public Integer getSampleRate() {
        return sampleRate;
    }

    @JsonProperty("sampleRate")
    public void setSampleRate(Integer sampleRate) {
        this.sampleRate = sampleRate;
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
