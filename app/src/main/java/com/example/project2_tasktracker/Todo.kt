package com.example.project2_tasktracker

data class Todo(
    val title: String,
    var isChecked: Boolean = false
) {
}