package com.example.android_homework_17

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val BASE_URL = "https://api.nasa.gov/mars-photos/"
const val API_KEY = "ButRbXOR1RaTbzWfjqEnbEdRxszsIxnpz8CF6Mgz"
interface PhotoesApi {
    @GET("api/v1/rovers/curiosity/photos")
    suspend fun getPhotoes (@Query("sol") sol: Int = 1000, @Query("api_key") api_key: String = API_KEY): Photoes
}

object RetrofitInstance {
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()
    val searchApi: PhotoesApi = retrofit.create(PhotoesApi::class.java)
}