
package com.musicapp.favoriteservice.domain.recomend;

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
    "artists",
    "albums",
    "genres",
    "tags",
    "composers"
})
@Generated("jsonschema2pojo")
public class Links {

    @JsonProperty("artists")
    private Artists artists;
    @JsonProperty("albums")
    private Albums albums;
    @JsonProperty("genres")
    private Genres genres;
    @JsonProperty("tags")
    private Tags tags;
    @JsonProperty("composers")
    private Composers composers;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("artists")
    public Artists getArtists() {
        return artists;
    }

    @JsonProperty("artists")
    public void setArtists(Artists artists) {
        this.artists = artists;
    }

    @JsonProperty("albums")
    public Albums getAlbums() {
        return albums;
    }

    @JsonProperty("albums")
    public void setAlbums(Albums albums) {
        this.albums = albums;
    }

    @JsonProperty("genres")
    public Genres getGenres() {
        return genres;
    }

    @JsonProperty("genres")
    public void setGenres(Genres genres) {
        this.genres = genres;
    }

    @JsonProperty("tags")
    public Tags getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(Tags tags) {
        this.tags = tags;
    }

    @JsonProperty("composers")
    public Composers getComposers() {
        return composers;
    }

    @JsonProperty("composers")
    public void setComposers(Composers composers) {
        this.composers = composers;
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
