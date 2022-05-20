package com.example.bookapp.View



import com.example.bookapp.ViewModel.MainScreen_FragmentVM
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp.R
import com.example.bookapp.ViewModel.Adapters.Api_Book_List_Adapter
import com.example.bookapp.ViewModel.ApiBooksList_FragmentVM
import java.text.SimpleDateFormat

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainScreen_Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainScreen_Fragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var vm: MainScreen_FragmentVM
    lateinit var vm1: ApiBooksList_FragmentVM

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vm = ViewModelProvider(this).get(MainScreen_FragmentVM::class.java)

        // val name="Gliwice"
        vm.changeBook()

        // vm.changeFruit("Gliwice")
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_screen_, container, false)
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
        //TODO:Fix this
        val adapter=Api_Book_List_Adapter(vm.bookdata,vm1)
        vm.bookdata.observe(viewLifecycleOwner,{adapter.notifyDataSetChanged()})
        /*
        vm.bookdata.observe(viewLifecycleOwner, {


            view.findViewById<TextView>(R.id.textView).text =
                (vm.bookdata.value?.books?.get(0)?.volumeInfo?.description.toString())


        })

         */
        val layoutManager = LinearLayoutManager(view.context)
        view.findViewById<RecyclerView>(R.id.BookListRecycle).let {
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
         * @return A new instance of fragment MainScreen_Fragment.
         */
        // TODO: Rename and change types and number of parameters

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainScreen_Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
