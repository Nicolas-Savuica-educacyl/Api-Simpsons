package com.example.api_simpsons.features.domain

class GetAllSimpsonsUseCase (private val repository: SimpsonsRepository) {
    suspend operator fun invoke() : Result<List<Simpson>>{
        val simpson = repository.getAllSimpsons()
        return simpson
    }
}