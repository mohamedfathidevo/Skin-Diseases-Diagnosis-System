package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network

import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.model.DiseasesNetworkEntity
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.retrofit.DiseaseRetrofit
import okhttp3.MultipartBody

class DiseaseRetrofitServiceImpl
constructor(
    private val diseaseRetrofit: DiseaseRetrofit
): DiseaseRetrofitService {
    override suspend fun getDiseasesResult(part: MultipartBody.Part): List<DiseasesNetworkEntity> {
        return diseaseRetrofit.getDiseasesResult(part)
    }

    override suspend fun getAllDiseases(): List<DiseasesNetworkEntity> {
        return diseaseRetrofit.getAllDiseases()
    }
}