package com.example.bookapp.View

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.R
import com.example.bookapp.ViewModel.Adapters.Api_Book_List_Adapter
import com.example.bookapp.ViewModel.ApiBooksList_FragmentVM
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ApiBooksList_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ApiBooksList_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    lateinit var vm: ApiBooksList_FragmentVM
    //var Bookname:String?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(ApiBooksList_FragmentVM::class.java)
        //Bookname = arguments?.getString("Bookname")?:""
        // val name="Gliwice"
        val BookName=arguments?.getString("BookName")?:""
        println(BookName)
        println("=------------------------------------------------------------------------")
        //val BookName=Bookname
        vm.changeBook(BookName)

        // vm.changeFruit("Gliwice")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_api_books_list_, container, false)
    }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_screen_, container, false)
    }*/
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter=Api_Book_List_Adapter(vm.bookdata,vm)
        vm.bookdata.observe(viewLifecycleOwner,{adapter.notifyDataSetChanged()})
        /*
        vm.bookdata.observe(viewLifecycleOwner, {


            view.findViewById<TextView>(R.id.textView).text =
                (vm.bookdata.value?.books?.get(0)?.volumeInfo?.description.toString())


        })



        class NodeObject {
            var mStaticAddress: String? = null
            var mLat: String? = null
            var mLong: String? = null

            constructor() {
                //needed for firebase
            }

            constructor(address: String?, lat: String?, Long: String?) {
                mStaticAddress = address
                mLat = lat
                mLong = Long
            }

            fun getmStaticAddress(): String? {
                return mStaticAddress
            }

            fun setmStaticAddress(mStaticAddress: String?) {
                this.mStaticAddress = mStaticAddress
            }

            fun getmLat(): String? {
                return mLat
            }

            fun setmLat(mLat: String?) {
                this.mLat = mLat
            }

            fun getmLong(): String? {
                return mLong
            }

            fun setmLong(mLong: String?) {
                this.mLong = mLong
            }
        }

         */

        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.BookListRecycle).let {
            it.adapter = adapter
            it.layoutManager = layoutManager
        }



        // Read from the database


       // postReference.addValueEventListener(postListener)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ApiBooksList_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ApiBooksList_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}