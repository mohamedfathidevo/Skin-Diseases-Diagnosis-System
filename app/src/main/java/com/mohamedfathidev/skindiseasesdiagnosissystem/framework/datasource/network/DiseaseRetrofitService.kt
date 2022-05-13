package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network

import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.model.DiseasesNetworkEntity
import okhttp3.MultipartBody

interface DiseaseRetrofitService {
    suspend fun getDiseasesResult(part: MultipartBody.Part): List<DiseasesNetworkEntity>
    suspend fun getAllDiseases(): List<DiseasesNetworkEntity>
}