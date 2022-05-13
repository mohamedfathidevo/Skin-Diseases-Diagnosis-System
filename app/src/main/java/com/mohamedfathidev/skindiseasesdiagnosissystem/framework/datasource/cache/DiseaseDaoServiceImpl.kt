package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache

import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.database.DiseaseDao
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.model.DiseasesCacheEntity

class DiseaseDaoServiceImpl
constructor(
    private val diseaseDao: DiseaseDao
): DiseaseDaoService {
    override suspend fun insert(diseasesCacheEntity: DiseasesCacheEntity): Long {
        return diseaseDao.insert(diseasesCacheEntity)
    }

    override suspend fun get(): List<DiseasesCacheEntity> {
        return diseaseDao.get()
    }

}