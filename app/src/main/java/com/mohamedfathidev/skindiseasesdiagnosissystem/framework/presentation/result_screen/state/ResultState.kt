package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.state

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease

data class ResultState(
    val diseases: List<Disease> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)