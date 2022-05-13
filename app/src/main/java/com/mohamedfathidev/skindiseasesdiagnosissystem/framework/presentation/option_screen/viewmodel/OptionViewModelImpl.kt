package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.option_screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.option_screen.state.OptionState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OptionViewModelImpl
@Inject constructor(): OptionViewModel, ViewModel(){

    private val _state = mutableStateOf(OptionState())
    val state: State<OptionState> = _state

    override fun isPressedButton() {
        _state.value = _state.value.copy(
            isPressed = true
        )
    }
}