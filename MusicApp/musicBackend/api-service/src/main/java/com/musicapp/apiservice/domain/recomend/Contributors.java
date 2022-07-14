
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
    "primaryArtist",
    "guestMusician",
    "producer",
    "collaborator",
    "engineer",
    "composer",
    "featuredPerformer",
    "guestVocals",
    "remixer"
})
@Generated("jsonschema2pojo")
public class Contributors {

    @JsonProperty("primaryArtist")
    private String primaryArtist;
    @JsonProperty("guestMusician")
    private String guestMusician;
    @JsonProperty("producer")
    private String producer;
    @JsonProperty("collaborator")
    private String collaborator;
    @JsonProperty("engineer")
    private String engineer;
    @JsonProperty("composer")
    private String composer;
    @JsonProperty("featuredPerformer")
    private String featuredPerformer;
    @JsonProperty("guestVocals")
    private String guestVocals;
    @JsonProperty("remixer")
    private String remixer;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("primaryArtist")
    public String getPrimaryArtist() {
        return primaryArtist;
    }

    @JsonProperty("primaryArtist")
    public void setPrimaryArtist(String primaryArtist) {
        this.primaryArtist = primaryArtist;
    }

    @JsonProperty("guestMusician")
    public String getGuestMusician() {
        return guestMusician;
    }

    @JsonProperty("guestMusician")
    public void setGuestMusician(String guestMusician) {
        this.guestMusician = guestMusician;
    }

    @JsonProperty("producer")
    public String getProducer() {
        return producer;
    }

    @JsonProperty("producer")
    public void setProducer(String producer) {
        this.producer = producer;
    }

    @JsonProperty("collaborator")
    public String getCollaborator() {
        return collaborator;
    }

    @JsonProperty("collaborator")
    public void setCollaborator(String collaborator) {
        this.collaborator = collaborator;
    }

    @JsonProperty("engineer")
    public String getEngineer() {
        return engineer;
    }

    @JsonProperty("engineer")
    public void setEngineer(String engineer) {
        this.engineer = engineer;
    }

    @JsonProperty("composer")
    public String getComposer() {
        return composer;
    }

    @JsonProperty("composer")
    public void setComposer(String composer) {
        this.composer = composer;
    }

    @JsonProperty("featuredPerformer")
    public String getFeaturedPerformer() {
        return featuredPerformer;
    }

    @JsonProperty("featuredPerformer")
    public void setFeaturedPerformer(String featuredPerformer) {
        this.featuredPerformer = featuredPerformer;
    }

    @JsonProperty("guestVocals")
    public String getGuestVocals() {
        return guestVocals;
    }

    @JsonProperty("guestVocals")
    public void setGuestVocals(String guestVocals) {
        this.guestVocals = guestVocals;
    }

    @JsonProperty("remixer")
    public String getRemixer() {
        return remixer;
    }

    @JsonProperty("remixer")
    public void setRemixer(String remixer) {
        this.remixer = remixer;
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
