package com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.network

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import okhttp3.MultipartBody

interface NetworkDataSource {
    suspend fun getDiseasesResult(part: MultipartBody.Part): List<Disease>
    suspend fun getAllDiseases(): List<Disease>
}