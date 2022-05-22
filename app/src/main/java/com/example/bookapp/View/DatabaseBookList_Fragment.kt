package com.example.bookapp.View

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.Model.booklistentry
import com.example.bookapp.R
import com.example.bookapp.ViewModel.Adapters.Api_Book_List_Adapter
import com.example.bookapp.ViewModel.Adapters.Database_Book_List_Adapter
import com.example.bookapp.ViewModel.ApiBooksList_FragmentVM
import com.example.bookapp.ViewModel.DatabaseBookList_FragmentVM
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
 * Use the [DatabaseBookList_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DatabaseBookList_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var vm: DatabaseBookList_FragmentVM


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
        vm = ViewModelProvider(this).get(DatabaseBookList_FragmentVM::class.java)
        vm.changeBook()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_database_book_list_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter= Database_Book_List_Adapter(vm.databaseData,vm)
        vm.databaseData.observe(viewLifecycleOwner,{adapter.notifyDataSetChanged()})
        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.DatabaseBookListRecycleView).let {
            it.adapter = adapter
            it.layoutManager = layoutManager
        }



    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DatabaseBookList_Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DatabaseBookList_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}