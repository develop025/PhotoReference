package com.example.photoreference.di

import com.example.photoreference.api.FlickrService
import com.example.photoreference.api.GithubService
import com.example.photoreference.data.Repo
import com.example.photoreference.ui.list.ListViewModel
import com.example.photoreference.ui.list.paged.PhotoDataSource
import com.example.photoreference.ui.list.paged.PhotoDataSourceFactory
import com.example.photoreference.ui.menu.MenuViewModel
import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

const val FLICKR_URL: String = "https://api.flickr.com/"
const val GITHUB_URL: String = "https://raw.githubusercontent.com/"

val mainModule = module {
    viewModel { ListViewModel(get()) }
    viewModel { MenuViewModel(get()) }
    single { Repo() }
    factory { PhotoDataSourceFactory(get()) }
    factory { PhotoDataSource(get()) }
    factory { provideGson() }
    factory { createOkHttpClient() }
    factory { provideExecutor() }
    factory { provideFlickrApiService(get(), get(), FLICKR_URL) }
    factory { provideGithubApiService(get(), get(), GITHUB_URL) }
}

val referenceApp = listOf(mainModule)

fun createOkHttpClient(): OkHttpClient {
    val httpLoggingInterceptor = HttpLoggingInterceptor()
    httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
    return OkHttpClient.Builder()
        .connectTimeout(20L, TimeUnit.SECONDS)
        .readTimeout(20L, TimeUnit.SECONDS)
        .addInterceptor(httpLoggingInterceptor)
        .addNetworkInterceptor(StethoInterceptor())
        .build()
}

fun provideGson(): Gson {
    return GsonBuilder().setLenient().create()
}

fun provideExecutor(): Executor {
    return Executors.newCachedThreadPool()
}

fun provideFlickrApiService(client: OkHttpClient, gson: Gson, baseUrl: String): FlickrService {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .baseUrl(baseUrl)
        .build()

    return retrofit.create(FlickrService::class.java)
}

fun provideGithubApiService(client: OkHttpClient, gson: Gson, baseUrl: String): GithubService {
    val retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .baseUrl(baseUrl)
        .build()

    return retrofit.create(GithubService::class.java)
}