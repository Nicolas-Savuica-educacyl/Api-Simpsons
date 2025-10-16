package com.example.api_simpsons.features.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.Observer
import com.example.api_simpsons.R
import com.example.api_simpsons.core.api.ApiClient
import com.example.api_simpsons.features.data.SimpsonDataRepository
import com.example.api_simpsons.features.data.remote.SimpsonsApiRemoteDataSource
import com.example.api_simpsons.features.domain.ErrorApp
import com.example.api_simpsons.features.domain.GetAllSimpsonsUseCase
import com.example.api_simpsons.features.domain.Simpson

class SimpsonListActivity : AppCompatActivity() {



        private val viewModel = SimpsonListViewModel(
            GetAllSimpsonsUseCase(
                SimpsonDataRepository(
                SimpsonsApiRemoteDataSource(ApiClient())
                )
            )
        )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun setupObserver() {
        val observer = Observer<SimpsonListViewModel.UiState>{ uiState ->

            if (uiState.isLoading){

            }else {

            }


            uiState.error?.let {

            } ?: {

            }


            uiState.simpsons?.let { simpsons ->
                simpsons
            }

        }
        viewModel.uiState.observe(this, observer)
    }

    private fun isFailure(errorApp: ErrorApp) {
        Log.d("SimpsonsError", "Error: ${errorApp.javaClass.simpleName}")
    }

    private fun isSuccess(simpsons: List<Simpson>) {
        Log.d(
            "HeroesSuccess", simpsons.toString()
        )
    }
}