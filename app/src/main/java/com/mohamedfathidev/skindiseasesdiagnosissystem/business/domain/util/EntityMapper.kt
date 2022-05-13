package com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util

interface EntityMapper <Entity, DomainModel> {
    fun mapFromEntity(entity: Entity): DomainModel
    fun mapToEntity(domainModel: DomainModel): Entity
}