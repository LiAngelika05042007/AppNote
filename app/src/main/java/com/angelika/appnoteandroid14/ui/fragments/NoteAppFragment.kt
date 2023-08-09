package com.angelika.appnoteandroid14.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.angelika.appnoteandroid14.App
import com.angelika.appnoteandroid14.R
import com.angelika.appnoteandroid14.databinding.FragmentNoteAppBinding
import com.angelika.appnoteandroid14.ui.adapters.NoteAppAdapter

class NoteAppFragment : Fragment() {

    private lateinit var binding: FragmentNoteAppBinding
    private var noteAppAdapter = NoteAppAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAppBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycle()
        addItemClick()
        getData()
    }

    private fun initRecycle() {
        binding.rvNotes.adapter = noteAppAdapter
    }

    private fun addItemClick() = with(binding){
        btnAddItem.setOnClickListener {
            findNavController().navigate(R.id.action_noteAppFragment_to_noteAppDetailFragment)
        }
    }

    private fun getData() {
        App.getInstance()?.noteDao()?.getAll()?.observe(viewLifecycleOwner){
            noteAppAdapter.addNote(it)
        }
    }
}