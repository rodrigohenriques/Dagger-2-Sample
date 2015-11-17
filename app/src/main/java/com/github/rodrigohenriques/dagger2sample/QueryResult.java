package com.github.rodrigohenriques.dagger2sample;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class QueryResult {
    @JsonProperty("Title") public String title;
    @JsonProperty("Season") public String season;
    @JsonProperty("Episodes") public List<Episode> episodes = new ArrayList<>();
    @JsonProperty("Response") public boolean response;
}
