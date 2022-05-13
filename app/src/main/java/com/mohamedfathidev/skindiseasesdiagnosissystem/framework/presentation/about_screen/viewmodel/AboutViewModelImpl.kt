package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.about_screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.about_screen.state.AboutState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutViewModelImpl
@Inject constructor(): AboutViewModel, ViewModel(){

    private val _state = mutableStateOf(AboutState())
    val state: State<AboutState> = _state

    override fun isReadData() {
        _state.value = _state.value.copy(
            isRead = true
        )
    }

}