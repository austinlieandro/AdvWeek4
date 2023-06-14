package com.example.advweek4.view

import android.view.View
import com.example.advweek4.model.Student

interface ButtonDetailClickListener{
    fun onButtonDetailClick(v:View)
}

interface StudentDetailClickListener {
    fun onUpdateClicked(v:View, student: Student)
    fun onNotificationClicked(v:View, student: Student)
}