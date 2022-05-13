package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.splash_screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.splash_screen.state.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModelImpl
@Inject constructor(): SplashViewModel, ViewModel() {

    private val _state = mutableStateOf(SplashState())
    val state: State<SplashState> = _state

    override fun testSplashTime() {
        _state.value = state.value.copy(
            splashTime = 4000
        )
    }
}