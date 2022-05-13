package com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.usecase.all_diseases

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.network.NetworkDataSource
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.state.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetAllDiseasesImpl
constructor(
    private val networkDataSource: NetworkDataSource
): GetAllDiseases {
    override fun invoke(): Flow<DataState<List<Disease>>> = flow {
        emit(DataState.Loading)
        delay(4000)
        try {
            val networkResult = networkDataSource.getAllDiseases()
            emit(DataState.Success(networkResult))
        }catch (e: Exception) {
            emit(DataState.Error(e))
        }
    }
}