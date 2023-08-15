package com.example.samplemvvemproject.di
import android.content.Context
import android.content.SharedPreferences
import com.example.sampleMvvmCleanCompose.common.utls.AppSp
import com.example.sampleMvvmCleanCompose.common.utls.etension.SP
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SharedPreferenceModule {


    @Singleton
    @Provides
    fun providePreference(@ApplicationContext context : Context): SharedPreferences {
         val file = SP.SP_File_NAME
        return context.getSharedPreferences(file, Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideJustSP(sp:SharedPreferences): AppSp {
        return AppSp(sp)
    }

}