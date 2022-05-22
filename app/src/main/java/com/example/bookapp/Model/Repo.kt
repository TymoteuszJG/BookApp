package com.example.bookapp.Model
import com.example.bookapp.Model.BookData
import retrofit2.awaitResponse

class Repo {
    companion object {




        suspend fun getSearchedBooks(BookName:String): BookData? {
            //var BookName:String="Percy Jackson"
            println(BookName)
            println(">><<<<<<<<<<<<<<<<<<<<<<<<<<<><><><><><><><><")
            return Retro.api.getSearchedBooks( BookName,"partial","lite","en","AIzaSyDvHL5IcME_79gg7ZOi06E9OUhfQU0CwcE").awaitResponse().body()

        }



    }
}
