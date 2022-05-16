package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.mapper

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.EntityMapper
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.model.DiseasesCacheEntity
import javax.inject.Inject

class CacheMapper
@Inject
constructor(): EntityMapper<DiseasesCacheEntity, Disease> {
    override fun mapFromEntity(entity: DiseasesCacheEntity): Disease {
        return Disease(
            name = entity.name,
            percentage = entity.percentage
        )
    }

    override fun mapToEntity(domainModel: Disease): DiseasesCacheEntity {
        return DiseasesCacheEntity(
            name = domainModel.name,
            percentage = domainModel.percentage
        )
    }

    fun mapFromEntityList(entities: List<DiseasesCacheEntity>): List<Disease>{
        return entities.map { mapFromEntity(it) }
    }

}