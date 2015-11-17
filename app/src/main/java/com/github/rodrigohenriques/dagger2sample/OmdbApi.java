package com.github.rodrigohenriques.dagger2sample;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface OmdbApi {
    @GET("/") Call<QueryResult> queryByNameAndSeason(@Query("t") String name, @Query("season") int season);
}
