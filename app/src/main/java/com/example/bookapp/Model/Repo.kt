package com.example.bookapp.Model
import com.example.bookapp.Model.BookData
import retrofit2.awaitResponse

class Repo {
    companion object {




        suspend fun getSearchedBooks(): BookData? {
            //var BookName:String="Percy Jackson"
            return Retro.api.getSearchedBooks( "Percy Jackson","partial","lite","pl","AIzaSyDvHL5IcME_79gg7ZOi06E9OUhfQU0CwcE").awaitResponse().body()
        }



    }
}