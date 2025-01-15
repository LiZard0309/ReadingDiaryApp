package com.example.readingdiary.lists

import androidx.lifecycle.ViewModel
import com.example.readingdiary.repository.repository

class ReadListViewModel(): ViewModel() {
    fun readAll() = repository.readAllReadBooks()

    fun refreshTriggered() {
        repository.loadNewReadList()
    }

}