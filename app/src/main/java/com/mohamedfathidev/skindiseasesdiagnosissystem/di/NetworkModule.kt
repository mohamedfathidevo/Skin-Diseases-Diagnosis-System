package com.mohamedfathidev.skindiseasesdiagnosissystem.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.network.NetworkDataSource
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.network.NetworkDataSourceImpl
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.Constant.BASE_URL
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.EntityMapper
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.DiseaseRetrofitService
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.DiseaseRetrofitServiceImpl
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.mapper.NetworkMapper
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.model.DiseasesNetworkEntity
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.network.retrofit.DiseaseRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkMapper(): EntityMapper<DiseasesNetworkEntity, Disease> {
        return NetworkMapper()
    }

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson {
        return GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
    }

    @Singleton
    @Provides
    fun provideDiseaseService(retrofit: Retrofit.Builder): DiseaseRetrofit {
        return retrofit
            .build()
            .create(DiseaseRetrofit::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitService(
        diseaseRetrofit: DiseaseRetrofit
    ): DiseaseRetrofitService {
        return DiseaseRetrofitServiceImpl(diseaseRetrofit)
    }

    @Singleton
    @Provides
    fun provideNetworkDataSource(
        diseasesRetrofitService: DiseaseRetrofitService,
        networkMapper: NetworkMapper
    ): NetworkDataSource {
        return NetworkDataSourceImpl(
            diseasesRetrofitService,
            networkMapper
        )
    }
}