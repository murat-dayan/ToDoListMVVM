package com.example.todolist.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.example.todolist.R
import com.example.todolist.databinding.FragmentAddNoteBinding
import com.example.todolist.ui.viewmodel.AddNoteViewModel
import com.example.todolist.ui.viewmodel.MainViewModel
import com.example.todolist.util.doSwitch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddNoteFragment : Fragment() {


    private lateinit var binding: FragmentAddNoteBinding
    private lateinit var viewModel: AddNoteViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_add_note, container, false)
        binding.addNoteFragment= this
        binding.addNoteToolbarTitle= "Add Note"



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AddNoteViewModel by viewModels()
        viewModel= tempViewModel

    }

    fun buttonSave(noteTitle:String, note:String){
        viewModel.save(noteTitle,note)
        Navigation.doSwitch(binding.buttonAdd,R.id.mainSwitch)
    }


}