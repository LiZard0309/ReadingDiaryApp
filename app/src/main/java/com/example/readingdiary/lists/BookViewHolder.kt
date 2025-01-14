package com.example.readingdiary.lists

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.readingdiary.R

class BookViewHolder(val bookItemRootView: View) : RecyclerView.ViewHolder(bookItemRootView) {
    val bookTitleTextView: TextView = bookItemRootView.findViewById(R.id.tvBookItemTitle)
}
