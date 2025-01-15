package com.example.readingdiary.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GoogleBooksResponse(
    val items: List<Volume>?
)

@Serializable
data class Volume(
    val volumeInfo: VolumeInfo
)

@Serializable
data class VolumeInfo(
    @SerialName("title") val bookTitle: String,
    @SerialName("authors") val bookAuthors: List<String>? = null,
    val description: String? = null
)
