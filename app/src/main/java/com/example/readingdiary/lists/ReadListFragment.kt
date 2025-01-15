package com.example.readingdiary.lists

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.readingdiary.R

class ReadListFragment : Fragment(R.layout.fragment_read_books) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var refresher: SwipeRefreshLayout

    private val readListViewModel: ReadListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvReadBooks)
        refresher = view.findViewById(R.id.swipeRefresherReadList)

        setupBooksReadList()
    }

    override fun onResume() {
        super.onResume()
        setupBooksReadList()
    }

    private fun setupBooksReadList(){
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = ReadListRecyclerViewAdapter(readListViewModel.readAll())
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, linearLayoutManager.orientation)

        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        refresher.setOnRefreshListener {
            readListViewModel.refreshTriggered()
            refresher.isRefreshing = false
        }

    }
}