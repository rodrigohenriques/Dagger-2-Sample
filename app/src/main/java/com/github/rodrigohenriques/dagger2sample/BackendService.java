package com.github.rodrigohenriques.dagger2sample;

import javax.inject.Inject;

import retrofit.Call;
import retrofit.Callback;

public class BackendService {
    private final OmdbApi mOmdbApi;

    @Inject
    public BackendService(OmdbApi mOmdbApi) {
        this.mOmdbApi = mOmdbApi;
    }

    void getTvShow(String tvShow, int season, Callback<QueryResult> callback) {
        Call<QueryResult> call = mOmdbApi.queryByNameAndSeason(tvShow, season);
        call.enqueue(callback);
    }
}
