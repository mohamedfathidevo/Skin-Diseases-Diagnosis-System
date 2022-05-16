package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DiseasesNetworkEntity (

    @SerializedName("diseaseName")
    @Expose
    val name: String,

    @SerializedName("diseasePercentage")
    @Expose
    val percentage: String,
)
