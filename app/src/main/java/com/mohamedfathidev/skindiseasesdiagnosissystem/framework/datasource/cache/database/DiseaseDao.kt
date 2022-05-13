package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.model.DiseasesCacheEntity

@Dao
interface DiseaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(diseasesCacheEntity: DiseasesCacheEntity): Long

    @Query("SELECT * FROM diseases")
    suspend fun get(): List<DiseasesCacheEntity>
}