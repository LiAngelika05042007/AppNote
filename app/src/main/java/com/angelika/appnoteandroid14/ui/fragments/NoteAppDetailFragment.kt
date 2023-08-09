package com.angelika.appnoteandroid14.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.angelika.appnoteandroid14.App
import com.angelika.appnoteandroid14.data.models.NoteModel
import com.angelika.appnoteandroid14.databinding.FragmentNoteAppDetailBinding
import com.angelika.appnoteandroid14.ui.adapters.NoteAppAdapter
import java.text.SimpleDateFormat
import java.util.Date

class NoteAppDetailFragment : Fragment() {

    private lateinit var binding: FragmentNoteAppDetailBinding
    private val dates = SimpleDateFormat("dd MMM").format(Date())
    private val times = SimpleDateFormat("HH:m").format(Date())
    private var backgroundColor = "#1B1A1A"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteAppDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataAndTime()
        backClick()
        ready()
    }

    private fun dataAndTime() = with(binding) {
        date.text = dates
        time.text = times
    }

    private fun backClick() {
        binding.back.setOnClickListener {
            findNavController().navigateUp()
        }
        binding.btnRadioFirst.setOnClickListener {
            backgroundColor = "#1E1E1E"
        }
        binding.btnSecond.setOnClickListener {
            backgroundColor = "#EBE4C9"
        }
        binding.btnThird.setOnClickListener {
            backgroundColor = "#571818"
        }
    }

    private fun ready() = with(binding) {
        ready.setOnClickListener {
            if (etName.text.isNotEmpty() || description.text.isNotEmpty()) {
                val title = etName.text.toString()
                val description = description.text.toString()
                val data = date.text.toString()
                val time = time.text.toString()

                App.getInstance()?.noteDao()
                    ?.insertAll(
                        NoteModel(
                            title,
                            description,
                            date = data,
                            time = time,
                            color = backgroundColor
                        )
                    )
                findNavController().navigateUp()
            }
        }
    }
}
