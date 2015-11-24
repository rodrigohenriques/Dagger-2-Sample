package com.github.rodrigohenriques.dagger2sample;

import dagger.Module;
import dagger.Provides;
import retrofit.JacksonConverterFactory;
import retrofit.Retrofit;

@Module
public class ApplicationModule {
    @Provides public OmdbApi providesOmdbApi() {
        return new Retrofit.Builder()
                .baseUrl("http://www.omdbapi.com")
                .addConverterFactory(JacksonConverterFactory.create())
                .build()
                .create(OmdbApi.class);
    }
}
