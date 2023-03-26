package com.example.adv160420043week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420043week4.R
import com.example.adv160420043week4.viewmodel.DetailViewModel
import com.example.adv160420043week4.viewmodel.ListViewModel
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

/**
 * A simple [Fragment] subclass.
 * Use the [StudentDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    private val studentListAdapter = StudentListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch()

        viewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
//            val txtID = view.findViewById<TextInputLayout>(R.id.txtName)
//            val editTxtID = txtID.editText
//            editTxtID?.setText("hehe")
            val txtID = view.findViewById<TextInputEditText>(R.id.txtID)
            txtID.setText(student.id.toString())

            val txtName = view.findViewById<TextInputEditText>(R.id.txtName)
            txtName.setText(student.name.toString())

            val txtBod = view.findViewById<TextInputEditText>(R.id.txtBod)
            txtBod.setText(student.dob.toString())

            val txtPhone = view.findViewById<TextInputEditText>(R.id.txtPhone)
            txtPhone.setText(student.phone.toString())
//            Log.d("TEST", student.name.toString())
        })

//        val recView = view.findViewById<RecyclerView>(R.id.recView)
//        recView?.layoutManager = LinearLayoutManager(context)
//        recView?.adapter = studentListAdapter

//        observeViewModel()

    }
}