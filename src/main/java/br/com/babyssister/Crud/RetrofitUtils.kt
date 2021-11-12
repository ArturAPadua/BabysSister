package br.com.babyssister.Crud

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitUtils {
    companion object {
        fun getRetrofitInstance(basePath: String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(basePath)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}