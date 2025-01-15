package com.example.readingdiary.lists

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.readingdiary.R


class BookSearchListFragment : Fragment(R.layout.fragment_book_search) {

    private val bookSearchViewModel: BookSearchViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var refresher: SwipeRefreshLayout
    private lateinit var searchView: SearchView
    private lateinit var progressBarSpinner: ProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.rvSearchedBooks)
        refresher = view.findViewById(R.id.swipeRefresherBookSearch)
        searchView = view.findViewById(R.id.svBookApi)
        progressBarSpinner = view.findViewById(R.id.progressBarBookSearch)

        val adapter = SearchListRecyclerViewAdapter(arrayListOf())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        progressBarSpinner.visibility = View.GONE

        bookSearchViewModel.books.observe(viewLifecycleOwner) { books ->
            adapter.books = ArrayList(books)
            adapter.notifyDataSetChanged()
        }

        bookSearchViewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            progressBarSpinner.visibility = if (isLoading) View.VISIBLE else View.GONE
        }

        bookSearchViewModel.error.observe(viewLifecycleOwner) { error ->
            error?.let {
                Log.e("BookSearchListFragment", "Error: $error")
            }
        }
        setupSearch()

    }

    private fun setupSearch() {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(newText: String?): Boolean {
                bookSearchViewModel.onSearchTermEntered(newText ?: "")
                return true
            }

            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

        })
    }

}