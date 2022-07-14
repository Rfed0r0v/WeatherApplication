package com.example.weatherapplication.features.weather_screen.di

import BASE_URL
import com.example.weatherapplication.features.weather_screen.WeatherInteractor
import com.example.weatherapplication.features.weather_screen.data.*
import com.example.weatherapplication.features.weather_screen.ui.WeatherScreenPresenter
import okhttp3.OkHttpClient
import org.koin.core.scope.get
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val weatherScreenModule = module {

    single<OkHttpClient> { OkHttpClient.Builder().build() }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get<OkHttpClient>())
            .build()
    }

    single<WeatherAPI> { get<Retrofit>().create(WeatherAPI::class.java) }

    single { WeatherRemoteSource(get<WeatherAPI>()) }

    single<WeatherRepo> { WeatherRepoImplement(get<WeatherRemoteSource>()) }

    single { WeatherInteractor(get<WeatherRepo>()) }

    single { WeatherScreenPresenter(get<WeatherInteractor>()) }
}