package com.chua.searchyt.ui.player

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.chua.searchyt.databinding.CommentResultViewholderBinding
import com.chua.searchyt.network.CommentItemDTO

class CommentAdapter : RecyclerView.Adapter<CommentAdapter.ViewHolder>() {

    private var items: MutableList<CommentItemDTO> = mutableListOf()

    fun updateItems(items: List<CommentItemDTO> = emptyList()) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: CommentResultViewholderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(commentItem: CommentItemDTO) {
            binding.apply {
                author.text = commentItem.snippet.topLevelComment.snippet.authorDisplayName
                comment.text = commentItem.snippet.topLevelComment.snippet.textOriginal
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CommentResultViewholderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

}