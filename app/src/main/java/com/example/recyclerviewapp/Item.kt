package com.example.recyclerviewapp

/**
 * Simple data model for a list item.
 *
 * @param id Unique identifier (stable id for RecyclerView diffing).
 * @param title Title text shown in the list.
 * @param description Short description displayed under the title.
 * @param imageRes Drawable resource id for the icon.
 */
data class Item(
    val id: Long,
    val title: String,
    val description: String,
    val imageRes: Int
)
