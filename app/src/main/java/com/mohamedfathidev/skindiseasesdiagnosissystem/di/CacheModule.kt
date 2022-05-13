package com.mohamedfathidev.skindiseasesdiagnosissystem.di

import android.content.Context
import androidx.room.Room
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.cache.CacheDataSource
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.data.cache.CacheDataSourceImpl
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.model.Disease
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.Constant.DatabaseName
import com.mohamedfathidev.skindiseasesdiagnosissystem.business.domain.util.EntityMapper
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.DiseaseDaoService
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.DiseaseDaoServiceImpl
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.database.DiseaseDao
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.database.DiseaseDatabase
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.mapper.CacheMapper
import com.mohamedfathidev.skindiseasesdiagnosissystem.framework.datasource.cache.model.DiseasesCacheEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideCacheMapper(): EntityMapper<DiseasesCacheEntity, Disease> {
        return CacheMapper()
    }

    @Singleton
    @Provides
    fun provideDiseaseDb(@ApplicationContext context: Context): DiseaseDatabase {
        return Room
            .databaseBuilder(
                context,
                DiseaseDatabase::class.java,
                DatabaseName
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideDiseaseDAO(diseaseDatabase: DiseaseDatabase): DiseaseDao {
        return diseaseDatabase.diseaseDao()
    }

    @Singleton
    @Provides
    fun provideDiseaseDaoService(
        diseaseDao: DiseaseDao
    ): DiseaseDaoService {
        return DiseaseDaoServiceImpl(diseaseDao)
    }

    @Singleton
    @Provides
    fun provideCacheDataSource(
        diseaseDaoService: DiseaseDaoService,
        cacheMapper: CacheMapper
    ): CacheDataSource {
        return CacheDataSourceImpl(diseaseDaoService, cacheMapper)
    }
}