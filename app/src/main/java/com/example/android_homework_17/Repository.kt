package com.example.android_homework_17

import com.example.android_homework_17.RetrofitInstance.searchApi

class Repository {
    suspend fun getData(): List<Photo> {
        return searchApi.getPhotoes().photoes
    }
}