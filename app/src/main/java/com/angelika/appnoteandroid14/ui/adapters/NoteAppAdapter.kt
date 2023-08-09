package com.angelika.appnoteandroid14.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.angelika.appnoteandroid14.data.models.NoteModel
import com.angelika.appnoteandroid14.databinding.ItemTheNoteBinding

class NoteAppAdapter : RecyclerView.Adapter<NoteAppAdapter.NoteViewHolder>() {

    private var notes: List<NoteModel> = ArrayList()

    fun addNote(list: List<NoteModel>) {
        this.notes = list
        notifyDataSetChanged()
    }

    inner class NoteViewHolder(private val binding: ItemTheNoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(theNote: NoteModel) = with(binding) {
            title.text = theNote.title
            description.text = theNote.description
            tvDate.text = theNote.date
            time.text = theNote.time

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val item = ItemTheNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(item)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(notes[position])
    }

    override fun getItemCount(): Int {
        return notes.size
    }
}