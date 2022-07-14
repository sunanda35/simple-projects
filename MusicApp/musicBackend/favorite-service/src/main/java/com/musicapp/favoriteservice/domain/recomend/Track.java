
package com.musicapp.favoriteservice.domain.recomend;

import java.util.HashMap;
import java.util.List;
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
    "id",
    "index",
    "disc",
    "href",
    "playbackSeconds",
    "isExplicit",
    "isStreamable",
    "isAvailableInHiRes",
    "name",
    "isrc",
    "shortcut",
    "blurbs",
    "artistId",
    "artistName",
    "albumName",
    "formats",
    "losslessFormats",
    "albumId",
    "isAvailableInAtmos",
    "contributors",
    "links",
    "previewURL"
})
@Generated("jsonschema2pojo")
public class Track {

    @JsonProperty("type")
    private String type;
    @JsonProperty("id")
    private String id;
    @JsonProperty("index")
    private Integer index;
    @JsonProperty("disc")
    private Integer disc;
    @JsonProperty("href")
    private String href;
    @JsonProperty("playbackSeconds")
    private Integer playbackSeconds;
    @JsonProperty("isExplicit")
    private Boolean isExplicit;
    @JsonProperty("isStreamable")
    private Boolean isStreamable;
    @JsonProperty("isAvailableInHiRes")
    private Boolean isAvailableInHiRes;
    @JsonProperty("name")
    private String name;
    @JsonProperty("isrc")
    private String isrc;
    @JsonProperty("shortcut")
    private String shortcut;
    @JsonProperty("blurbs")
    private List<Object> blurbs = null;
    @JsonProperty("artistId")
    private String artistId;
    @JsonProperty("artistName")
    private String artistName;
    @JsonProperty("albumName")
    private String albumName;
    @JsonProperty("formats")
    private List<Format> formats = null;
    @JsonProperty("losslessFormats")
    private List<LosslessFormat> losslessFormats = null;
    @JsonProperty("albumId")
    private String albumId;
    @JsonProperty("isAvailableInAtmos")
    private Boolean isAvailableInAtmos;
    @JsonProperty("contributors")
    private Contributors contributors;
    @JsonProperty("links")
    private Links links;
    @JsonProperty("previewURL")
    private String previewURL;
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

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("index")
    public Integer getIndex() {
        return index;
    }

    @JsonProperty("index")
    public void setIndex(Integer index) {
        this.index = index;
    }

    @JsonProperty("disc")
    public Integer getDisc() {
        return disc;
    }

    @JsonProperty("disc")
    public void setDisc(Integer disc) {
        this.disc = disc;
    }

    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    @JsonProperty("playbackSeconds")
    public Integer getPlaybackSeconds() {
        return playbackSeconds;
    }

    @JsonProperty("playbackSeconds")
    public void setPlaybackSeconds(Integer playbackSeconds) {
        this.playbackSeconds = playbackSeconds;
    }

    @JsonProperty("isExplicit")
    public Boolean getIsExplicit() {
        return isExplicit;
    }

    @JsonProperty("isExplicit")
    public void setIsExplicit(Boolean isExplicit) {
        this.isExplicit = isExplicit;
    }

    @JsonProperty("isStreamable")
    public Boolean getIsStreamable() {
        return isStreamable;
    }

    @JsonProperty("isStreamable")
    public void setIsStreamable(Boolean isStreamable) {
        this.isStreamable = isStreamable;
    }

    @JsonProperty("isAvailableInHiRes")
    public Boolean getIsAvailableInHiRes() {
        return isAvailableInHiRes;
    }

    @JsonProperty("isAvailableInHiRes")
    public void setIsAvailableInHiRes(Boolean isAvailableInHiRes) {
        this.isAvailableInHiRes = isAvailableInHiRes;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("isrc")
    public String getIsrc() {
        return isrc;
    }

    @JsonProperty("isrc")
    public void setIsrc(String isrc) {
        this.isrc = isrc;
    }

    @JsonProperty("shortcut")
    public String getShortcut() {
        return shortcut;
    }

    @JsonProperty("shortcut")
    public void setShortcut(String shortcut) {
        this.shortcut = shortcut;
    }

    @JsonProperty("blurbs")
    public List<Object> getBlurbs() {
        return blurbs;
    }

    @JsonProperty("blurbs")
    public void setBlurbs(List<Object> blurbs) {
        this.blurbs = blurbs;
    }

    @JsonProperty("artistId")
    public String getArtistId() {
        return artistId;
    }

    @JsonProperty("artistId")
    public void setArtistId(String artistId) {
        this.artistId = artistId;
    }

    @JsonProperty("artistName")
    public String getArtistName() {
        return artistName;
    }

    @JsonProperty("artistName")
    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    @JsonProperty("albumName")
    public String getAlbumName() {
        return albumName;
    }

    @JsonProperty("albumName")
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    @JsonProperty("formats")
    public List<Format> getFormats() {
        return formats;
    }

    @JsonProperty("formats")
    public void setFormats(List<Format> formats) {
        this.formats = formats;
    }

    @JsonProperty("losslessFormats")
    public List<LosslessFormat> getLosslessFormats() {
        return losslessFormats;
    }

    @JsonProperty("losslessFormats")
    public void setLosslessFormats(List<LosslessFormat> losslessFormats) {
        this.losslessFormats = losslessFormats;
    }

    @JsonProperty("albumId")
    public String getAlbumId() {
        return albumId;
    }

    @JsonProperty("albumId")
    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    @JsonProperty("isAvailableInAtmos")
    public Boolean getIsAvailableInAtmos() {
        return isAvailableInAtmos;
    }

    @JsonProperty("isAvailableInAtmos")
    public void setIsAvailableInAtmos(Boolean isAvailableInAtmos) {
        this.isAvailableInAtmos = isAvailableInAtmos;
    }

    @JsonProperty("contributors")
    public Contributors getContributors() {
        return contributors;
    }

    @JsonProperty("contributors")
    public void setContributors(Contributors contributors) {
        this.contributors = contributors;
    }

    @JsonProperty("links")
    public Links getLinks() {
        return links;
    }

    @JsonProperty("links")
    public void setLinks(Links links) {
        this.links = links;
    }

    @JsonProperty("previewURL")
    public String getPreviewURL() {
        return previewURL;
    }

    @JsonProperty("previewURL")
    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
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
