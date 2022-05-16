package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.mapper

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.EntityMapper
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.model.DiseasesNetworkEntity
import javax.inject.Inject

class NetworkMapper
@Inject
constructor(): EntityMapper<DiseasesNetworkEntity, Disease> {
    override fun mapFromEntity(entity: DiseasesNetworkEntity): Disease {
        return Disease(
            name = entity.name,
            percentage = entity.percentage
        )
    }

    override fun mapToEntity(domainModel: Disease): DiseasesNetworkEntity {
        return DiseasesNetworkEntity(
            name = domainModel.name,
            percentage = domainModel.percentage
        )
    }

    fun mapFromEntityList(entities: List<DiseasesNetworkEntity>): List<Disease>{
        return entities.map { mapFromEntity(it) }
    }

}