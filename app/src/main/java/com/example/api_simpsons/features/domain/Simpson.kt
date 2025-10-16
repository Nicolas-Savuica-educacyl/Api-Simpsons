package com.example.api_simpsons.features.domain

data class Simpson (
    val id : Int,
    val age : Int,
    val gender : String,
    val name : String,
    val occupation : String,
    val portrait_path : String,
    val status : String
)