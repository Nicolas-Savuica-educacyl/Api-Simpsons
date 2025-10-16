package com.example.api_simpsons.features.domain

interface SimpsonsRepository {
    suspend fun getAllSimpsons(): Result<List<Simpson>>
}