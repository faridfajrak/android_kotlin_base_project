package f.fajrak.kotlin_base_project.tools.repository

import f.fajrak.kotlin_base_project.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


interface ApiService {

    companion object {
        fun create(): ApiService {
            val baseUrl = BuildConfig.base_url
            val logger = HttpLoggingInterceptor();
            logger.level = HttpLoggingInterceptor.Level.BODY;

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build();

            return Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }

    }

}