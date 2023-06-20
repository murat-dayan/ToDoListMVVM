package com.example.todolist.util

import android.view.View
import androidx.navigation.NavArgs
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.example.todolist.R

fun Navigation.doSwitch(it:View, id:Int){
    findNavController(it).navigate(id)
}

fun Navigation.doSwitch(it:View, id: NavDirections){
    findNavController(it).navigate(id)
}