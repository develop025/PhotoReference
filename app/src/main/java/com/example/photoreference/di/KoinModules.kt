package com.example.photoreference.di

import com.example.photoreference.api.FlickrService
import com.example.photoreference.ui.list.ListViewModel
import com.example.photoreference.ui.list.paged.PhotoDataSource
import com.example.photoreference.ui.list.paged.PhotoDataSourceFactory
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

const val BASE_URL: String = "https://api.flickr.com"

val mainModule = module {
    viewModel { ListViewModel(get()) }
    factory { PhotoDataSourceFactory(get()) }
    factory { PhotoDataSource(get()) }
    factory { provideGson() }
    factory { createOkHttpClient() }
    factory { provideExecutor() }
    single { provideRetrofit(get(), BASE_URL) }
    single { provideApiPixelService(get()) }
}

val referenceApp = listOf(mainModule)

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
            .connectTimeout(20L, TimeUnit.SECONDS)
            .readTimeout(20L, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor).build()
}

fun provideGson(): Gson {
    return GsonBuilder().setLenient().create()
}

fun provideExecutor(): Executor {
    return Executors.newCachedThreadPool()
}

fun provideRetrofit(gson: Gson, baseUrl: String): Retrofit {
    val client = OkHttpClient.Builder()
            .build()

    return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .baseUrl(baseUrl)
            .build()
}

fun provideApiPixelService(restAdapter: Retrofit): FlickrService {
    return restAdapter.create(FlickrService::class.java)
}