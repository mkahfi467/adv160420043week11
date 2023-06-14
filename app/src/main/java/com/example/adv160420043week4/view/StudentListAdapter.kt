package com.example.adv160420043week4.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.adv160420043week4.R
import com.example.adv160420043week4.databinding.StudentListItemBinding
import com.example.adv160420043week4.model.Student
import com.example.adv160420043week4.util.loadImage

class StudentListAdapter(val studentList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener {
//    class StudentViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    // W11
    class StudentViewHolder(var view:StudentListItemBinding) : RecyclerView.ViewHolder(view.root)
    //

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val view = inflater.inflate(R.layout.student_list_item, parent, false)
//        return StudentViewHolder(view)

        //W11
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater,R.layout.student_list_item, parent, false)
        return StudentViewHolder(view)
        //
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
//        val txtID = holder.view.findViewById<TextView>(R.id.txtID)
//        txtID.text = studentList[position].id
//        val txtName = holder.view.findViewById<TextView>(R.id.txtName)
//        txtName.text = studentList[position].name
//
//        val btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
//        btnDetail.setOnClickListener {
//            // WEEK 6 Buat variable student id dan dikirim ke studentDetailFragment
//            val student_id = studentList[position].id.toString()
//
//            val action = StudentListFragmentDirections.actionStudentDetail(student_id)
//            Navigation.findNavController(it).navigate(action)
//        }

        // WEEK 6
//        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
//        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
//        imageView.loadImage(studentList[position].photoUrl, progressBar)

        //W11
        holder.view.student = studentList[position]
        holder.view.listener = this
        //
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studentList.clear()
        studentList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    //W11
    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
    //
}