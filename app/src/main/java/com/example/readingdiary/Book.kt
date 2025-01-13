package com.example.readingdiary

class Book(
    var bookTitle: String,
    var bookAuthor: String,
    var bookDescription: String
) : java.io.Serializable

fun createBooks(bookCount: Int) =
    (1..bookCount).map { index ->
        Book("Book $index", "Author from Book $index", "Description $index")
    }