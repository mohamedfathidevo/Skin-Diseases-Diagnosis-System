package com.mohamedfathidev.skindiseasesdiagnosissystem.di

import com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.network.NetworkDataSource
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.usecase.all_diseases.GetAllDiseases
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.usecase.all_diseases.GetAllDiseasesImpl
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.usecase.diagnostic_result.DiagnosticResult
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.usecase.diagnostic_result.DiagnosticResultImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideGetDiseasesResultUseCase(
        networkDataSource: NetworkDataSource
    ): DiagnosticResult {
        return DiagnosticResultImpl(
            networkDataSource = networkDataSource
        )
    }

    @Singleton
    @Provides
    fun provideGetAllDiseasesUseCase(
        networkDataSource: NetworkDataSource
    ): GetAllDiseases {
        return GetAllDiseasesImpl(
            networkDataSource = networkDataSource
        )
    }

}