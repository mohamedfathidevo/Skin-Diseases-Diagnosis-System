package com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.usecase.diagnostic_result

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.state.DataState
import kotlinx.coroutines.flow.Flow
import okhttp3.MultipartBody

interface DiagnosticResult {
    operator fun invoke(part: MultipartBody.Part): Flow<DataState<List<Disease>>>
}