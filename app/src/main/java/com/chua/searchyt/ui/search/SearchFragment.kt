package com.chua.searchyt.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.chua.searchyt.R
import com.chua.searchyt.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val searchViewModel: SearchViewModel by viewModels()

    private val searchAdapter = SearchAdapter {videoId ->
        findNavController().navigate(R.id.action_searchFragment_to_playerFragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            textField.setEndIconOnClickListener {
                searchViewModel.search(textField.editText?.text.toString())
            }
            searchRecyclerView.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = searchAdapter
            }
        }

        searchViewModel.searchResponse.observe(viewLifecycleOwner) {
            searchAdapter.updateItems(it.items)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}