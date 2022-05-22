package com.example.bookapp.View

import android.content.ContentValues
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.bookapp.R
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import java.net.URL

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BookDetailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BookDetailsFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var title: String? = null
    private var author: String? = null
    private var description: String? = null
    private var publish_date: String? = null
    private var imagelink:String?=null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        title = arguments?.getString("title")?:""
        author = arguments?.getString("author")?:""
        description = arguments?.getString("description")?:""
        publish_date = arguments?.getString("publish_date")?:""
        imagelink=arguments?.getString("image_link")?:""
        return inflater.inflate(R.layout.fragment_book_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<TextView>(R.id.BookTitleTextView).text = title
        view.findViewById<TextView>(R.id.BookAuthorTextView).text = author
        view.findViewById<TextView>(R.id.BookDescriptionTextView).text = description
        view.findViewById<TextView>(R.id.BookPublishDateTextView).text = publish_date
        view.findViewById<TextView>(R.id.BookStatusTextView).text = "Not Read"
        val url = URL(imagelink)

        //val url = URL(books?.get(position)?.volumeInfo?.imageLinks?.smallThumbnail.toString())
        var bookimage: Bitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        view.findViewById<ImageView>(R.id.BookImageImageView).setImageBitmap(bookimage)
        val database = Firebase.database("https://mobilefirebaseproject-default-rtdb.europe-west1.firebasedatabase.app/")
        val myRef = database.getReference("")
        val book = object {
            val Title = title
            val Author = author
            val Description = description
            val Publish_date = publish_date
            val finished:Boolean=false
            // object expressions extend Any, so `override` is required on `toString()`
            //override fun toString() = "$hello $world"
        }

        myRef.child(title?.replace("." , "").toString()).setValue(book)
        //myRef.setValue(book)



    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BookDetailsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BookDetailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}