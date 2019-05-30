package com.ynov.kotlin.rickmorty.data

import com.ynov.kotlin.rickmorty.data.entity.Remote.CharactersResult
import com.ynov.kotlin.rickmorty.data.entity.Remote.RMCharacter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import io.reactivex.Single
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.http.Path

private const val API_BASE_URL = "https://rickandmortyapi.com/"

class ApiManager {

    private val service: ApiService

    interface ApiService {
        @GET("api/character")
        fun retrieveCharacter(): Single<CharactersResult>

        @GET("api/character/{id}")
        fun retrieveDetailCharacter(@Path("id") id: String): Single<RMCharacter>
    }

    init {
        service = Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(
                OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BASIC
                })
                .build())
            .build()
            .create(ApiService::class.java)
    }

    fun retrieveCharacter(): Single<List<RMCharacter>> = service.retrieveCharacter().map { it.results }
    fun retrieveDetailCharacter(id: String): Single<RMCharacter> = service.retrieveDetailCharacter(id = id).map { it }
}