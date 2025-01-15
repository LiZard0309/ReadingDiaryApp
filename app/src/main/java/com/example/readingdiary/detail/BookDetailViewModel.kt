package com.example.readingdiary.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.readingdiary.Book
import com.example.readingdiary.repository.repository

class BookDetailViewModel(private val savedStateHandle: SavedStateHandle): ViewModel() {


    fun read(): Book {
        return savedStateHandle["book"]!!
    }

    fun addToReadList(book: Book) {
        repository.addToReadList(book)
        Log.d("BookDetailViewModel", "Book added to read list: $book")
    }

    fun addToWishList(book: Book) {
        repository.addToWishList(book)
        Log.d("BookDetailViewModel", "Book added to wish list: $book")
    }

}