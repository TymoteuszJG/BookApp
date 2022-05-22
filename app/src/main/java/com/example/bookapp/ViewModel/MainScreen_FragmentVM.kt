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
class MainScreen_FragmentVM (application: Application): AndroidViewModel(application) {
    /*
    private val _weatherData : MutableLiveData<BookData> = MutableLiveData()
    val bookdata : LiveData<BookData>
        get() {
            return _weatherData
        }
    //fun changeFruit(name:String){
    fun changeBook(){
        viewModelScope.launch {
            val newBook = Repo.getSearchedBooks()
            //val newFruit = Repo.getall()

            if(newBook != null)
                _weatherData.value = newBook!!
        }
    }*/

}

