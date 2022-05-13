package com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.cache

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease

interface CacheDataSource {
    suspend fun insert(disease: Disease): Long
    suspend fun get(): List<Disease>
}