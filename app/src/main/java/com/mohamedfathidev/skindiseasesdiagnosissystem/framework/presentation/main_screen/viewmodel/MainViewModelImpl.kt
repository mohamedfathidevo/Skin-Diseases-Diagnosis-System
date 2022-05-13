package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.main_screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.main_screen.state.MainState
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.splash_screen.state.SplashState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModelImpl
@Inject constructor(): MainViewModel, ViewModel() {

    private val _state = mutableStateOf(MainState())
    val state: State<MainState> = _state

    override fun testMain() {
        _state.value = _state.value.copy(
            isPressed = true
        )
    }

}