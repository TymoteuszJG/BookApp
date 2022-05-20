package com.example.bookapp.Model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

const val BaseUrl = "https://www.googleapis.com/books/v1/"
object Retro {
    private val retro by lazy{
        Retrofit.Builder().baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }

    val api : GoogleBooksApi by lazy {
        Retrofit.Builder()
            .baseUrl(BaseUrl).addConverterFactory(GsonConverterFactory.create())
            .build().create(GoogleBooksApi::class.java)
    }
}