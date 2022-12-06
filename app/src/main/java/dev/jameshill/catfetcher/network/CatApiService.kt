package dev.jameshill.catfetcher.network

import retrofit2.Call
import retrofit2.http.GET

interface CatApiService {
    @GET("cat?json=true")
    fun fetchCat(): Call<CatResponse>
}