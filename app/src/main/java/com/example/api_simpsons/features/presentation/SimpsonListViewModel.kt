package com.example.api_simpsons.features.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.api_simpsons.features.domain.ErrorApp
import com.example.api_simpsons.features.domain.GetAllSimpsonsUseCase
import com.example.api_simpsons.features.domain.Simpson
import kotlinx.coroutines.launch

class SimpsonListViewModel (val getAll : GetAllSimpsonsUseCase) : ViewModel(){

    private val _uiState  = MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState


    fun loadAllSimpsons(){
        viewModelScope.launch {
            _uiState.value = UiState(isLoading = true)
            getAll().fold(
                {onSuccess(it)},
                {onFailure(it as ErrorApp)}
            )
        }
    }

    private fun onSuccess(simpsons: List<Simpson>){
        _uiState.value = UiState(simpsons = simpsons)
    }
    private fun onFailure(error : ErrorApp){
        _uiState.value = UiState(error = error)
    }

    data class UiState(
        val error : ErrorApp? = null,
        val isLoading : Boolean = false,
        val simpsons: List<Simpson>? = null
    )
}