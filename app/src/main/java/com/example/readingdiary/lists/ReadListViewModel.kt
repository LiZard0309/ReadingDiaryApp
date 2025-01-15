package com.example.readingdiary.lists

import androidx.lifecycle.ViewModel
import com.example.readingdiary.repository.repository

class ReadListViewModel(): ViewModel() {
    val readListBooks = repository.readBooks

    fun readAll() = repository.readAllReadBooks()
}