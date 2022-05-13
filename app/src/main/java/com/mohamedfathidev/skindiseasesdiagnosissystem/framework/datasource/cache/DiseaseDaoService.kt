package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache

import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.model.DiseasesCacheEntity

interface DiseaseDaoService {
    suspend fun insert(diseasesCacheEntity: DiseasesCacheEntity): Long
    suspend fun get(): List<DiseasesCacheEntity>
}