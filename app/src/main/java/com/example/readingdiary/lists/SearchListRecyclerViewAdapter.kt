package com.example.readingdiary.lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.readingdiary.Book
import com.example.readingdiary.R


class SearchListRecyclerViewAdapter(var books: ArrayList<Book>) : RecyclerView.Adapter<BookViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listItemContactRootView =
            layoutInflater.inflate(R.layout.fragment_book_item, parent, false)
        return BookViewHolder(listItemContactRootView)
    }

    override fun getItemCount(): Int {
        return books.size
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        val book = books[position]
        holder.bookTitleTextView.text = book.bookTitle

        holder.bookItemRootView.setOnClickListener {
            val navHostFragment = holder.bookItemRootView.findNavController()
            navHostFragment.navigate(BookSearchListFragmentDirections.actionBookSearchListFragmentToBookDetailsFragment(book))
        }

    }
}