package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.result_screen.viewmodel

import okhttp3.MultipartBody

interface ResultViewModel {
    fun getDiseasesResult(part: MultipartBody.Part)
    suspend fun justForTest(id: Int)
}