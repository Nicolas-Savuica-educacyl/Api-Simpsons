package com.example.api_simpsons.features.data.remote

import com.example.api_simpsons.core.api.ApiClient
import com.example.api_simpsons.features.domain.ErrorApp
import com.example.api_simpsons.features.domain.Simpson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SimpsonsApiRemoteDataSource (private val apiClient: ApiClient){

    val apiService = apiClient.createService(SimpsonApiService::class.java)

    val responseSimpson = apiService.findAllCharacters()

    suspend fun getSimpsons(): Result<List<Simpson>> {
        return withContext(Dispatchers.Main) {
            val apiService = apiClient.createService(SimpsonApiService::class.java)
            val resultSimpson = apiService.findAllCharacters().execute()
            if (resultSimpson.isSuccessful && resultSimpson.errorBody() == null) {
                val listSimpsonApiModel : List<SimpsonApiModel> = resultSimpson.body()!!

                val listSimpson = listSimpsonApiModel.map { simpsonApiModel ->
                    simpsonApiModel.toModel()
                }
                return@withContext Result.success(listSimpson)
            }
            return@withContext Result.failure(ErrorApp.UnknownError)


        }
    }




}