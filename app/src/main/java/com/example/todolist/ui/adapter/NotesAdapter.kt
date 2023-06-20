package com.example.todolist.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.entity.Notes
import com.example.todolist.databinding.CardviewNotesTitleBinding
import com.example.todolist.ui.fragment.MainFragmentDirections
import com.example.todolist.ui.viewmodel.MainViewModel
import com.example.todolist.util.doSwitch
import com.google.android.material.snackbar.Snackbar

class NotesAdapter(var mContext: Context, var notesList:List<Notes>, var viewModel: MainViewModel) :
    RecyclerView.Adapter<NotesAdapter.NotesViewHolder>(){

        inner class NotesViewHolder(binding: CardviewNotesTitleBinding) : RecyclerView.ViewHolder(binding.root){

            var binding: CardviewNotesTitleBinding

            init {
                this.binding= binding
            }

        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        val layoutInflater= LayoutInflater.from(mContext)
        val binding : CardviewNotesTitleBinding= DataBindingUtil.inflate(layoutInflater,R.layout.cardview_notes_title, parent,false)
        return NotesViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val note= notesList.get(position)

        val n= holder.binding

        n.note= note

        n.cardViewnoteTitle.setOnClickListener {
            val switch= MainFragmentDirections.noteDetailSwitch(note)
            Navigation.doSwitch(it,switch)
        }

        n.cardViewDeleteImageView.setOnClickListener {
            Snackbar.make(it, "is note will be deleted are you sure?", Snackbar.LENGTH_LONG)
                .setAction("YES"){
                    viewModel.delete(note.note_id)
                }.show()
        }
    }

}