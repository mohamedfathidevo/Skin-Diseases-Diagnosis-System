package com.mohamedfathidev.skindiseasesdiagnosissystem.framework.presentation.util

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease

object GenerateData {
    fun getDataFor(): List<Disease> = mutableListOf(
        Disease("Test 1", "90"),
        Disease("Test 2", "85"),
        Disease("Test 3", "83"),
        Disease("Test 4", "80"),
        Disease("Test 5", "78")
    )
}