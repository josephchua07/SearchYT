package com.chua.searchyt.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.chua.searchyt.databinding.SearchResultViewholderBinding
import com.chua.searchyt.network.SearchItemDTO

class SearchAdapter : RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private var items: MutableList<SearchItemDTO> = mutableListOf()

    fun updateItems(items: List<SearchItemDTO> = emptyList()) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: SearchResultViewholderBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(searchItem: SearchItemDTO) {
            binding.apply {
                thumbnail.load(searchItem.snippet.thumbnails.default.url)
                title.text = searchItem.snippet.title
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SearchResultViewholderBinding.inflate(
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