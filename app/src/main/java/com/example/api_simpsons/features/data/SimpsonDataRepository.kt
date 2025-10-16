package com.example.api_simpsons.features.data

import com.example.api_simpsons.features.data.remote.SimpsonsApiRemoteDataSource
import com.example.api_simpsons.features.domain.Simpson
import com.example.api_simpsons.features.domain.SimpsonsRepository

class SimpsonDataRepository (val apiDataSource: SimpsonsApiRemoteDataSource) : SimpsonsRepository {
    override suspend fun getAllSimpsons(): Result<List<Simpson>> {
        return apiDataSource.getSimpsons()
    }

}