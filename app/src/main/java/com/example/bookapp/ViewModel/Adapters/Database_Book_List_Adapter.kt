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
import com.example.bookapp.Model.BookData
import com.example.bookapp.Model.booklistentry
import com.example.bookapp.R
import com.example.bookapp.ViewModel.ApiBooksList_FragmentVM
import com.example.bookapp.ViewModel.DatabaseBookList_FragmentVM
import java.net.URL

class Database_Book_List_Adapter (private val bookdata: LiveData<List<booklistentry>>, private val viewModel : DatabaseBookList_FragmentVM)
: RecyclerView.Adapter<Database_Book_List_Adapter.BookListHolder>(){


    inner class BookListHolder(private val view : View): RecyclerView.ViewHolder(view){
        //val Book_List_Image = view.findViewById<ImageView>(R.id.one_row_book_list_api_Image)
        val Book_List_Title=view.findViewById<TextView>(R.id.one_row_book_list_api_title)
        val Book_List_Author=view.findViewById<TextView>(R.id.one_row_book_list_api_author)
        val Book_List_Status=view.findViewById<TextView>(R.id.one_row_book_list_api_status)
        val myView=view
        //val button=view.findViewById<Button>(R.id.RemoveCalorieListButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookListHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.one_row_book_list_database,parent,false)
        return BookListHolder(view)
    }

    override fun onBindViewHolder(holder: Database_Book_List_Adapter.BookListHolder, position: Int) {
        var books=bookdata.value
        holder.Book_List_Title.text = books?.get(position)?.Title
        // holder.Book_List_Author.text = books1?.get(position)?.volumeInfo?.authors.toString()
        holder.Book_List_Author.text = books?.get(position)?.Author
        holder.Book_List_Status.text=books?.get(position)?.finished.toString()
        //val string = books?.get(position)?.volumeInfo?.imageLinks?.smallThumbnail.toString().replaceRange(4,4,"s")
        //val url = URL(string)
        //val url = URL(books?.get(position)?.volumeInfo?.imageLinks?.smallThumbnail.toString())
        //var bookimage: Bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        //holder.Book_List_Image.setImageBitmap(bookimage)
        /*
        val bundle= Bundle()
        bundle.putString("title",books?.get(position)?.volumeInfo?.title.toString())
        bundle.putString("author",books?.get(position)?.volumeInfo?.authors?.joinToString())
        bundle.putString("publish_date",books?.get(position)?.volumeInfo?.publishedDate.toString())
        bundle.putString("description",books?.get(position)?.volumeInfo?.description.toString())
        bundle.putString("image_link",string)


        holder.myView.setOnClickListener(){
            holder.myView.findNavController().navigate(R.id.action_apiBooksList_Fragment_to_bookDetailsFragment,bundle)



         */
        }




        override fun getItemCount(): Int {
            return bookdata.value?.size?:0
        }
}