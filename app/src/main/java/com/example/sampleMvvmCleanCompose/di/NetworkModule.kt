package com.example.samplemvvemproject.di
import okhttp3.OkHttpClient;
import java.util.concurrent.TimeUnit;
import com.example.sampleMvvmCleanCompose.common.utls.etension.URL
import com.example.sampleMvvmCleanCompose.data.utility.LenientTypeAdapterFactory
import com.example.sampleMvvmCleanCompose.data.remote.dto.Api
import com.example.sampleMvvmCleanCompose.data.repository.ProductRepository
import com.example.sampleMvvmCleanCompose.domain.repository.ProductRepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import javax.net.ssl.*

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideRetrofit(client :OkHttpClient,gson:Gson) :Api{
     return  Retrofit.Builder()
            .baseUrl(URL.BASE_URL)
           .addConverterFactory(GsonConverterFactory.create(gson))
           .client(client).build()
           .create(Api::class.java)
    }



    @Singleton
    @Provides
    fun provideProductRepository(api:Api): ProductRepository {
        return  ProductRepositoryImpl(api)
    }

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return   GsonBuilder().registerTypeAdapterFactory(LenientTypeAdapterFactory()).create()
    }

    @Singleton
    @Provides
    fun okHttpClient(): OkHttpClient{
       return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS) // Set connection timeout
            .readTimeout(30, TimeUnit.SECONDS) // Set read timeout
            .build()
    }


}