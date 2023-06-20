package com.example.todolist.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todolist.R
import com.example.todolist.databinding.FragmentNoteDetailBinding
import com.example.todolist.ui.viewmodel.AddNoteViewModel
import com.example.todolist.ui.viewmodel.MainViewModel
import com.example.todolist.ui.viewmodel.NoteDetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NoteDetailFragment : Fragment() {

    private lateinit var binding: FragmentNoteDetailBinding
    private lateinit var viewModel: NoteDetailViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_note_detail, container, false)

        binding.noteDetailToolbarTitle= "Note Detail"

        val bundle: NoteDetailFragmentArgs by navArgs()
        val inComingNote= bundle.note
        binding.note= inComingNote

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: NoteDetailViewModel by viewModels()
        viewModel= tempViewModel

    }


}