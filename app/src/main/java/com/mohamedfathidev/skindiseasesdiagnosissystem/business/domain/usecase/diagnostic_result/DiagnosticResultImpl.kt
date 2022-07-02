package com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.usecase.diagnostic_result

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.network.NetworkDataSource
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import okhttp3.MultipartBody

class DiagnosticResultImpl
constructor(
    private val networkDataSource: NetworkDataSource
): DiagnosticResult {
    override fun invoke(part: MultipartBody.Part): Flow<DataState<List<Disease>>> = flow {
        emit(DataState.Loading)
        delay(4000)
        try {
            val networkResult = networkDataSource.getDiseasesResult(part).sortedBy { it.percentage }.take(5)
            emit(DataState.Success(networkResult))
        }catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}