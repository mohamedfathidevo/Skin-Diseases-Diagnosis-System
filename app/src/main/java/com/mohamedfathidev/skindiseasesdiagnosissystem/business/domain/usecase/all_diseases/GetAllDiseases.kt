package com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.usecase.all_diseases

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.state.DataState
import kotlinx.coroutines.flow.Flow

interface GetAllDiseases {
    operator fun invoke(): Flow<DataState<List<Disease>>>
}