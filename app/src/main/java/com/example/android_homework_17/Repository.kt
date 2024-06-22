package com.example.android_homework_17

import android.util.Log
import com.example.android_homework_17.RetrofitInstance.searchApi

class Repository {
    suspend fun getData(): List<Photo> {
        return searchApi.getPhotoes().photos
    }
}