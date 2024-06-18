package com.example.android_homework_17

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
const val BASE_URL = "https://api.nasa.gov"
interface PhotoesApi {
    @GET("mars-photos/api/v1/rovers/curiosity/photos?sol=1000&api_key=ButRbXOR1RaTbzWfjqEnbEdRxszsIxnpz8CF6Mgz")
    suspend fun getPhotoes (): Photoes
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