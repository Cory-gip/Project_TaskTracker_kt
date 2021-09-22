package com.example.project2_tasktracker

// Class for the data that will be displayed inside of each element of the RecyclerView.
data class Todo(
    val title: String,
    var isChecked: Boolean = false
) {
}