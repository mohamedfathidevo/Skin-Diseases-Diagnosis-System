package com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.cache

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.DiseaseDaoService
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.mapper.CacheMapper

class CacheDataSourceImpl
constructor(
    private val diseaseDaoService: DiseaseDaoService,
    private val cacheMapper: CacheMapper
): CacheDataSource{
    override suspend fun insert(disease: Disease): Long {
        return diseaseDaoService.insert(cacheMapper.mapToEntity(domainModel = disease))
    }

    override suspend fun get(): List<Disease> {
        return cacheMapper.mapFromEntityList(diseaseDaoService.get())
    }

}