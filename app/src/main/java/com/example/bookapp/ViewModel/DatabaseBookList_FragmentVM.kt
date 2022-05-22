package com.example.bookapp.ViewModel

import android.app.Application
import android.content.ContentValues
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.bookapp.Model.BookData
import com.example.bookapp.Model.Repo
import com.example.bookapp.Model.booklistentry
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class DatabaseBookList_FragmentVM (application: Application): AndroidViewModel(application) {
    private val _databaseData : MutableLiveData<List<booklistentry>> = MutableLiveData()
    var CheckValue=0
    //var ArrayofBookEntries:MutableList<booklistentry> = MutableList<booklistentry>
    var ArrayofBookEntries=mutableListOf<booklistentry>()
    //val mutableList = mutableListOf<Kolory>()
    val databaseData : LiveData<List<booklistentry>>
        get() {
            return _databaseData
        }
    val database = Firebase.database("https://mobilefirebaseproject-default-rtdb.europe-west1.firebasedatabase.app/")
    val myRef = database.getReference("")
    val postListener = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            ArrayofBookEntries.clear()
            for (snapshot in dataSnapshot.children) {
                var user: booklistentry? = snapshot.getValue(booklistentry::class.java)
                ArrayofBookEntries?.add(user!!)

            }
        changeBook()
        }
        override fun onCancelled(databaseError: DatabaseError) {
            // Getting Post failed, log a message
            Log.w(ContentValues.TAG, "loadPost:onCancelled", databaseError.toException())
        }
    }

    fun addListiner(){
        myRef.addValueEventListener(postListener)


    }


    fun changeBook(){
        if(CheckValue==0){
            this.addListiner()

            CheckValue=1
        }
        viewModelScope.launch {
            val newBook = ArrayofBookEntries


            if(newBook != null)
                _databaseData.value = newBook!!
        }
    }





}