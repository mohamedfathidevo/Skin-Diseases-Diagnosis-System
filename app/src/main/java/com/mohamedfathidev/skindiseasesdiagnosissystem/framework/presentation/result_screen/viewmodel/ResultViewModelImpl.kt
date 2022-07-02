package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.state.DataState
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.usecase.diagnostic_result.DiagnosticResult
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.state.ResultState
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util.GenerateData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import okhttp3.MultipartBody
import javax.inject.Inject

@HiltViewModel
class ResultViewModelImpl
@Inject constructor(
    private val diagnosticResult: DiagnosticResult,
    savedStateHandle: SavedStateHandle
): ResultViewModel, ViewModel() {

    private val _state = mutableStateOf(ResultState())
    val state: State<ResultState> = _state

    override fun getDiseasesResult(part: MultipartBody.Part) {
        diagnosticResult(part).onEach { dataState ->
            when(dataState) {
                is DataState.Success -> {
                    _state.value = ResultState(
                        diseases = dataState.data
                    )
                }
                is DataState.Error -> {
                    _state.value = ResultState(
                        error = dataState.exception.toString()
                    )
                }
                is DataState.Loading -> {
                    _state.value = ResultState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
    }

    override suspend fun justForTest(id: Int) {
        viewModelScope.launch{
            _state.value = ResultState(
                isLoading = true
            )
            delay(5000)
            if (id == 1){
                _state.value = ResultState(
                    diseases = emptyList(),
                    isLoading = false
                )
            }else{
                _state.value = ResultState(
                    diseases = GenerateData.getDataFor(),
                    isLoading = false
                )
            }
        }
    }
}