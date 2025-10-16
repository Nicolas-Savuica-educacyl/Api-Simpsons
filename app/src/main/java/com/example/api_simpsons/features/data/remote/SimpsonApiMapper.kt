package com.example.api_simpsons.features.data.remote

import com.example.api_simpsons.features.domain.Simpson

fun SimpsonApiModel.toModel() : Simpson{
    return Simpson(
        this.results.id,
        this.results.age,
        this.results.gender,
        this.results.name,
        this.results.occupation,
        this.results.portrait_path,
        this.results.status
        )
}