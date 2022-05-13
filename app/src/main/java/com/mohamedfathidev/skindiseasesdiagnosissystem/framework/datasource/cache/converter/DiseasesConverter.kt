package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease

class DiseasesConverter {
    @TypeConverter
    fun fromDiseasesToGson(
        disease: Disease
    ): String = Gson().toJson(disease)
    @TypeConverter
    fun fromGsonToDiseases(
        diseasesGson: String
    ): Disease = Gson().fromJson(
        diseasesGson, Disease::class.java
    )
}