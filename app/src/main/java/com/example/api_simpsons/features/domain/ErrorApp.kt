package com.example.api_simpsons.features.domain

sealed class ErrorApp : Throwable() {
    object ApiError : ErrorApp()
    object UnknownError : ErrorApp()
}