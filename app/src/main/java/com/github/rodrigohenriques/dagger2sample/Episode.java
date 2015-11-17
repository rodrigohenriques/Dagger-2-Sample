package com.github.rodrigohenriques.dagger2sample;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Episode {
    @JsonProperty("Title") public String title;
    @JsonProperty("Released") public String released;
    @JsonProperty("Episode") public String episode;
    @JsonProperty("imdbRating") public String imdbRating;
    @JsonProperty("imdbID") public String imdbID;
}