package com.cinecity.entities.dto.movie;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;

import java.io.Serializable;

@JsonSubTypes({
        @JsonSubTypes.Type(Movie.class),
        @JsonSubTypes.Type(TvShow.class),
        @JsonSubTypes.Type(Person.class)
})
public class MediaType implements Serializable {

    private Long id;
    @JsonProperty("media_type")
    private String mediaType;

    public MediaType() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }
}
