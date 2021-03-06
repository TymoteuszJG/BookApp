package com.example.bookapp.ViewModel
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

import com.example.bookapp.Model.BookData
import com.example.bookapp.Model.Repo

import kotlinx.coroutines.launch
class ApiBooksList_FragmentVM (application: Application): AndroidViewModel(application) {
    private val _bookData: MutableLiveData<BookData> = MutableLiveData()
    val bookdata: LiveData<BookData>
        get() {
            return _bookData
        }

    //fun changeFruit(name:String){
    fun changeBook(BookName:String) {
        viewModelScope.launch {
            val newBook = Repo.getSearchedBooks(BookName)
            //val newFruit = Repo.getall()

            if (newBook != null)
                _bookData.value = newBook!!
        }
    }
}