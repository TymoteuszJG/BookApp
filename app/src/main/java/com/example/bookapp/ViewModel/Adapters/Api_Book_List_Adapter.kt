package com.example.bookapp.ViewModel.Adapters
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.Model.Book
import com.example.bookapp.Model.BookData
import com.example.bookapp.R
import com.example.bookapp.ViewModel.ApiBooksList_FragmentVM
import com.example.bookapp.ViewModel.MainScreen_FragmentVM
import java.net.URL

class Api_Book_List_Adapter (private val bookdata: LiveData<BookData>, private val viewModel : ApiBooksList_FragmentVM)
    : RecyclerView.Adapter<Api_Book_List_Adapter.BookListHolder>(){

    inner class BookListHolder(private val view : View): RecyclerView.ViewHolder(view){
        val Book_List_Image = view.findViewById<ImageView>(R.id.one_row_book_list_api_Image)
        val Book_List_Title=view.findViewById<TextView>(R.id.one_row_book_list_api_title)
        val Book_List_Author=view.findViewById<TextView>(R.id.one_row_book_list_api_author)
        val myView=view
        //val button=view.findViewById<Button>(R.id.RemoveCalorieListButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_book_list_api,parent,false)
        return BookListHolder(view)
    }

    override fun onBindViewHolder(holder: BookListHolder, position: Int) {
        var books=bookdata.value?.books
        holder.Book_List_Title.text = books?.get(position)?.volumeInfo?.title.toString()
       // holder.Book_List_Author.text = books?.get(position)?.volumeInfo?.authors.toString()
        holder.Book_List_Author.text = books?.get(position)?.volumeInfo?.authors?.joinToString()
        val string = books?.get(position)?.volumeInfo?.imageLinks?.smallThumbnail.toString().replaceRange(4,4,"s")
        val url = URL(string)
        //val url = URL(books?.get(position)?.volumeInfo?.imageLinks?.smallThumbnail.toString())
        var bookimage:Bitmap=BitmapFactory.decodeStream(url.openConnection().getInputStream());
        holder.Book_List_Image.setImageBitmap(bookimage)
        val bundle=Bundle()
        bundle.putString("title",books?.get(position)?.volumeInfo?.title.toString())
        bundle.putString("author",books?.get(position)?.volumeInfo?.authors?.joinToString())
        bundle.putString("publish_date",books?.get(position)?.volumeInfo?.publishedDate.toString())
        bundle.putString("description",books?.get(position)?.volumeInfo?.description.toString())
        bundle.putString("image_link",string)
        holder.myView.setOnClickListener(){
            holder.myView.findNavController().navigate(R.id.action_apiBooksList_Fragment_to_bookDetailsFragment,bundle)
        }

        /*
        holder.Book_List_Title.text = books.value?.get(position)?.volumeInfo?.title.toString()
        holder.Book_List_Author.text = books.value?.get(position)?.volumeInfo?.authors.toString()
        val url = URL(books.value?.get(position)?.volumeInfo?.imageLinks?.smallThumbnail.toString())
        var bookimage:Bitmap=BitmapFactory.decodeStream(url.openConnection().getInputStream());
        holder.Book_List_Image.setImageBitmap(bookimage)
    */
        // var url:String=books.value?.get(position)?.volumeInfo?.imageLinks?.smallThumbnail
            //books.value?.get(position)?.volumeInfo?.title.toString()
        //  holder.fName.setOnClickListener {
        //viewModel._chosenFruit.value= fruits.value?.get(position)
        //  }
       /* holder.button.setOnClickListener(){
            viewModel.removeFromListCalorie(fruits.value?.get(position)!!)
        }*/

        /*
        holder.checkbox.setOnCheckedChangeListener   {buttonView, isChecked ->
            //Add  to temp list of selected
            if (isChecked) {
                viewModel..add(fruits.value?.get(position)?.fruitID!!)
            } else {
                var ind =
                    viewModel..indexOf(fruits.value?.get(position)?.fruitID!!)
                viewModel..removeAt(ind)
            }
       }
        */
    }

    override fun getItemCount(): Int {
        return bookdata.value?.books?.size?:0
    }
}