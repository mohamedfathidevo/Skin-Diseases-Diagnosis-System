package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.retrofit

import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.model.DiseasesNetworkEntity
import okhttp3.MultipartBody
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface DiseaseRetrofit {
    @Multipart
    @POST("predictskin")
    suspend fun getDiseasesResult(
        @Part part: MultipartBody.Part
    ): List<DiseasesNetworkEntity>

    @GET("diseases")
    suspend fun getAllDiseases(): List<DiseasesNetworkEntity>
}