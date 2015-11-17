package com.github.rodrigohenriques.dagger2sample;

import retrofit.Call;
import retrofit.Callback;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

public class BackendService {

    OmdbApi omdbApi;

    public BackendService() {
        omdbApi = new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(OmdbApi.class);
    }

    void getTvShow(String tvShow, int season, Callback<QueryResult> callback) {
        Call<QueryResult> call = omdbApi.queryByNameAndSeason(tvShow, season);
        call.enqueue(callback);
    }
}
