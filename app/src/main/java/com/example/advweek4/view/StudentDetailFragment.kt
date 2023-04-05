package com.example.advweek4.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.advweek4.R
import com.example.advweek4.util.loadImage
import com.example.advweek4.viewmodel.DetailViewModel

class StudentDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_student_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val studentId = StudentDetailFragmentArgs.fromBundle(requireArguments()).studentId

        viewModel =ViewModelProvider(this).get(DetailViewModel::class.java)
        viewModel.fetch(studentId)

        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.studentLD.observe(viewLifecycleOwner, Observer { studentLD->
            val txtID = view?.findViewById<TextView>(R.id.txtID)
            val txtName = view?.findViewById<TextView>(R.id.txtName)
            val txtbod = view?.findViewById<TextView>(R.id.txtBod)
            val txtPhone = view?.findViewById<TextView>(R.id.txtPhone)
            val imgView = view?.findViewById<ImageView>(R.id.imageView2)
            val progressBar2 = view?.findViewById<ProgressBar>(R.id.progressBar2)

            txtID?.setText(studentLD.id)
            txtName?.setText(studentLD.name)
            txtbod?.setText(studentLD.dob)
            txtPhone?.setText(studentLD.phone)
            if (progressBar2 != null) {
                imgView?.loadImage(studentLD.photoUrl, progressBar2)
            }
        })
    }
}