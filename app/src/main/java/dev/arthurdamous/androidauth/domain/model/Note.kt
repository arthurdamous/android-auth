package dev.arthurdamous.androidauth.domain.model

data class Note(
    val id: String,
    val title: String,
    val description: String? = null,
    val created: String? = null,
    val modified: String? = null
)