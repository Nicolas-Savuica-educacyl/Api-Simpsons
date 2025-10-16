package com.example.api_simpsons.features.data.remote

import java.net.IDN

data class SimpsonApiModel (
    val results : results
)

data class results (
    val id : Int,
    val age : Int,
    val gender : String,
    val name : String,
    val occupation : String,
    val portrait_path : String,
    val status : String
)