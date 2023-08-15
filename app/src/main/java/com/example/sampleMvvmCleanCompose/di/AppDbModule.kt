package com.example.samplemvvemproject.di

import android.content.Context
import androidx.room.Room
import com.example.sampleMvvmCleanCompose.common.utls.etension.LocalDb
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import com.example.sampleMvvmCleanCompose.data.local.db.AppDb
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppDbModule {
        @Singleton
        @Provides
    fun provideAppDb(@ApplicationContext context : Context,): AppDb {
        return  Room.databaseBuilder(context,
            AppDb ::class.java, LocalDb.DB_NAME )
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration().build()

    }
}