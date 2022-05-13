package com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.network

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.DiseaseRetrofitService
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.mapper.NetworkMapper
import okhttp3.MultipartBody

class NetworkDataSourceImpl
constructor(
    private val diseaseRetrofitService: DiseaseRetrofitService,
    private val networkMapper: NetworkMapper,
): NetworkDataSource{
    override suspend fun getDiseasesResult(part: MultipartBody.Part): List<Disease> {
        return networkMapper.mapFromEntityList(diseaseRetrofitService.getDiseasesResult(part = part))
    }

    override suspend fun getAllDiseases(): List<Disease> {
        return networkMapper.mapFromEntityList(diseaseRetrofitService.getAllDiseases())
    }
}