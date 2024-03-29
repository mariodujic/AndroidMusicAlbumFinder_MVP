package com.groundzero.appfactory.common.di.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

  private static final String BASE_URL =
          "http://ws.audioscrobbler.com/2.0/";

  @Provides
  Gson provideGson() {
    return new GsonBuilder()
            .setLenient().create();
  }

  @Provides
  @Singleton
  Retrofit provideRetrofit() {
    return new Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .baseUrl(BASE_URL)
            .build();
  }
}
