package com.example.api_simpsons.features.data.remote

import com.example.api_simpsons.features.domain.Simpson
import retrofit2.Call
import retrofit2.http.GET

interface SimpsonApiService {

    @GET("characters")
    fun findAllCharacters(): Call<List<SimpsonApiModel>>
}