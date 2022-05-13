package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.converter.DiseasesConverter
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.model.DiseasesCacheEntity

@Database(entities = [DiseasesCacheEntity::class ], version = 1)
@TypeConverters(DiseasesConverter::class)
abstract class DiseaseDatabase: RoomDatabase() {
    abstract fun diseaseDao(): DiseaseDao
}