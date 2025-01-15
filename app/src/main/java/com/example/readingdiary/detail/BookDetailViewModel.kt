package com.example.readingdiary.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.readingdiary.Book

class BookDetailViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {

    fun read(): Book {
        return savedStateHandle["book"]!!
    }
}