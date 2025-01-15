package com.example.readingdiary.lists

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.readingdiary.Book
import com.example.readingdiary.BookData
import com.example.readingdiary.R
import com.example.readingdiary.repository.repository

class WishListFragment : Fragment(R.layout.fragment_wishlist) {
    private lateinit var recyclerView: RecyclerView
    private lateinit var refresher: SwipeRefreshLayout

    private val wishListViewModel: WishListViewModel by viewModels()
    private lateinit var adapter: WishListRecyclerViewAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.rvWishlistBooks)
        refresher = view.findViewById(R.id.swipeRefresherWishList)

        setupBooksWishList()

        wishListViewModel.wishListBooks.observe(viewLifecycleOwner) { books ->
            updateBookListAfterChange(books)
        }
    }

    override fun onResume() {
        super.onResume()
        setupBooksWishList()
    }

    private fun updateBookListAfterChange(newBookList: List<Book>) {
        adapter.updateWishList(newBookList)
    }

    private fun setupBooksWishList(){
        val linearLayoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        adapter = WishListRecyclerViewAdapter(repository.wishListBooks.value!!)
        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, linearLayoutManager.orientation)

        recyclerView.addItemDecoration(dividerItemDecoration)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adapter

        refresher.setOnRefreshListener {
            refresher.isRefreshing = false
        }

    }
}