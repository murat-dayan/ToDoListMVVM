package com.example.todolist.ui.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.todolist.R
import com.example.todolist.data.entity.Notes
import com.example.todolist.databinding.FragmentMainBinding
import com.example.todolist.ui.adapter.NotesAdapter
import com.example.todolist.ui.viewmodel.AddNoteViewModel
import com.example.todolist.ui.viewmodel.MainViewModel
import com.example.todolist.util.doSwitch
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_main, container, false)
        binding.mainFragment=this
        binding.mainFragmentToolbarTitle= "Notes"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarMain)

        viewModel.notesList.observe(viewLifecycleOwner){
            val notesAdapter= NotesAdapter(requireContext(), it, viewModel)
            binding.notesAdapter= notesAdapter

        }


        requireActivity().addMenuProvider(object : MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)

                val  item= menu.findItem(R.id.action_search)
                val searchView= item.actionView as SearchView
                searchView.setOnQueryTextListener(this@MainFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner,Lifecycle.State.RESUMED)


        return binding.root

    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainViewModel by viewModels()
        viewModel= tempViewModel

    }

    fun pressFab(it:View){
        Navigation.doSwitch(it,R.id.addNoteSwitch)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }



    override fun onResume() {
        super.onResume()
        viewModel.loadNotes()
    }

}