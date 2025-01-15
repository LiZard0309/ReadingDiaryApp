package com.example.readingdiary.lists

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.readingdiary.R


class BookSearchListFragment : Fragment(R.layout.fragment_book_search) {

    private val bookSearchViewModel: BookSearchViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}