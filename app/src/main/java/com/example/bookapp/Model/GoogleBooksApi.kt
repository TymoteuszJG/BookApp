package com.example.bookapp.Model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GoogleBooksApi {


    @GET("volumes?")
    fun getSearchedBooks(@Query("q") q:String,@Query("filter") filter:String,@Query("projection") projection:String,@Query("langRestrict") langRestrict:String,  @Query("key") key:String): Call<BookData>



}

