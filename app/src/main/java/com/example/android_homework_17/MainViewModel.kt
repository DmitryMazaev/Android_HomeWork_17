package com.example.android_homework_17

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainViewModel private constructor(
    private val repository: Repository
): ViewModel() {
    constructor() : this(Repository())

    private val _photoes = MutableStateFlow<List<Photo>>(emptyList())
    val photoes = _photoes.asStateFlow()

    init {

    }

    private fun loadPhotoes() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                repository.getData()
            }.fold(
                onSuccess = {_photoes.value = it },
                onFailure = { Log.d("MainViewModel", it.message ?: "")}
            )
        }
    }



}