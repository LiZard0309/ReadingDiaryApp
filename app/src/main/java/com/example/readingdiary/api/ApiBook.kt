package com.example.readingdiary.api

import kotlinx.serialization.Serializable

@Serializable
data class ApiBook(
    val bookTitle: String,
    val bookAuthor: String,
    val bookDescription: String
)