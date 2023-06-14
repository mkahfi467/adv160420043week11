package com.example.adv160420043week4.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420043week4.R
import com.example.adv160420043week4.databinding.FragmentStudentDetailBinding
import com.example.adv160420043week4.util.loadImage
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

    private lateinit var dataBinding:FragmentStudentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_student_detail, container, false)

        // W11
        dataBinding = DataBindingUtil.inflate<FragmentStudentDetailBinding>(inflater, R.layout.fragment_student_detail, container, false)
        return dataBinding.root
        //
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // WEEK 6 GET ARGUMENT
//        val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
//
//        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
//        viewModel.fetch(studentId)
//        Log.d("TEST", StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId)
        //

//        viewModel.studentLD.observe(viewLifecycleOwner, Observer { student ->
//            val txtID = view.findViewById<TextInputEditText>(R.id.txtID)
//            txtID.setText(student.id.toString())
//
//
//            val txtName = view.findViewById<TextInputEditText>(R.id.txtName)
//            txtName.setText(student.name.toString())
//
//            val txtBod = view.findViewById<TextInputEditText>(R.id.txtBod)
//            txtBod.setText(student.dob.toString())
//
//            val txtPhone = view.findViewById<TextInputEditText>(R.id.txtPhone)
//            txtPhone.setText(student.phone.toString())
////            Log.d("TEST", student.name.toString())
//
//            // WEEK 6 CLASS Exercise
//            var imageView = view.findViewById<ImageView>(R.id.imageView2)
//            var progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
//            imageView.loadImage(student.photoUrl.toString(), progressBar)
//        })

        // W11
        viewModel = ViewModelProvider(this).get(DetailViewModel::class.java)
        val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId
        viewModel.fetch(studentId)

        observeViewModel()
        //

    }

    fun observeViewModel() {
        viewModel.studentLD.observe(viewLifecycleOwner, Observer {
            dataBinding.student = it
        })

    }
}