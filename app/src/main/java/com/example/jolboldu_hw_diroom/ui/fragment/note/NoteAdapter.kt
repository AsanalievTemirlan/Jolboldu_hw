package com.example.jolboldu_hw_diroom.ui.fragment.note

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.jolboldu_hw_diroom.data.room.model.NoteModel
import com.example.jolboldu_hw_diroom.databinding.ItemBinding

class NoteAdapter(private val onItemLongClickListener: OnItemLongClickListener)
    : ListAdapter<NoteModel, NoteAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    inner class ViewHolder(private val binding: ItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(historyEntity: NoteModel) = with(binding) {
            historyEntity.apply {
                tvTitle.text = title
                tvDescription.text = description
            }
            root.setOnLongClickListener {
                onItemLongClickListener.onItemLongClicked(historyEntity)
                true
            }
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<NoteModel>() {
        override fun areItemsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteModel, newItem: NoteModel): Boolean {
            return oldItem== newItem
        }
    }
    interface OnItemLongClickListener {
        fun onItemLongClicked(model: NoteModel)
    }
}