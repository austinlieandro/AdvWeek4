package com.example.advweek4.view

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
import androidx.viewbinding.ViewBinding
import com.example.advweek4.R
import com.example.advweek4.databinding.StudentListItemBinding
import com.example.advweek4.model.Student
import com.example.advweek4.util.loadImage
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso

class StudentListAdapter(val studenList:ArrayList<Student>) :RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>(), ButtonDetailClickListener
{
    class StudentViewHolder(var view: StudentListItemBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<StudentListItemBinding>(inflater, R.layout.student_list_item, parent,  false)
        return StudentViewHolder(view)
    }

    override fun getItemCount(): Int {
        return studenList.size
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        holder.view.student = studenList[position]
        holder.view.listener = this
//        var txtID = holder.view.findViewById<TextView>(R.id.txtID)
//        var txtName = holder.view.findViewById<TextView>(R.id.txtName)
//        var btnDetail = holder.view.findViewById<Button>(R.id.btnDetail)
//
//        txtID.text = studenList[position].id
//        txtName.text = studenList[position].name
//        btnDetail.setOnClickListener {
//            val action = StudentListFragmentDirections.actionStudentDetail(studenList[position].id.toString())
//            Navigation.findNavController(it).navigate(action)
//        }
//
//        var imageView = holder.view.findViewById<ImageView>(R.id.imageView)
//        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
//        imageView.loadImage(studenList[position].photoUrl, progressBar)
    }

    fun updateStudentList(newStudentList: ArrayList<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }

    override fun onButtonDetailClick(v: View) {
        val action = StudentListFragmentDirections.actionStudentDetail(v.tag.toString())
        Navigation.findNavController(v).navigate(action)
    }
}