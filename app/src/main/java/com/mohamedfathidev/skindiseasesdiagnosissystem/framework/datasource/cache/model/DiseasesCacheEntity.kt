package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "diseases")
data class DiseasesCacheEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String,

    @ColumnInfo(name = "percentage")
    var percentage: String,

    @ColumnInfo(name = "advice")
    var advice: String? = null,
)