package com.example.readingdiary.lists

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.readingdiary.Book
import com.example.readingdiary.R
import com.example.readingdiary.placeholder.PlaceholderContent
import java.util.ArrayList

class ReadListFragment : Fragment(R.layout.fragment_read_books) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var refresher: SwipeRefreshLayout

    val booksRead = arrayListOf(
        Book("To Kill a Mockingbird", "Harper Lee", "A novel about racism and injustice."),
        Book("1984", "George Orwell", "A dystopian story of a totalitarian society."),
        Book("Pride and Prejudice", "Jane Austen", "A romantic novel of manners."),
    )


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvReadBooks)
        refresher = view.findViewById(R.id.swipeRefresher)

        setupBooksReadList()
    }

    private fun setupBooksReadList(){
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        val adapter = ReadListRecyclerViewAdapter(booksRead)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, linearLayoutManager.orientation)

        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        refresher.setOnRefreshListener {
            refresher.isRefreshing = false
        }

    }
}