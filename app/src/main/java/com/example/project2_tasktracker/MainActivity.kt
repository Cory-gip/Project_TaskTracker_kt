package com.example.project2_tasktracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.project2_tasktracker.databinding.ActivityMainBinding

lateinit var binding: ActivityMainBinding

private lateinit var todoAdapter: TodoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        todoAdapter = TodoAdapter(mutableListOf())

        binding.toDoViewer.adapter = todoAdapter
        binding.toDoViewer.layoutManager = LinearLayoutManager(this)
        binding.addTaskButton.setOnClickListener{ addTask() }
        binding.deleteCheckedTasksButton.setOnClickListener { deleteCheckedTasks() }
    }

    private fun deleteCheckedTasks() {
        todoAdapter.deleteDoneToDoItems()
    }


    private fun addTask() {
        val task = binding.taskText.text.toString()
        if(task.isNotEmpty()) {
            val todo = Todo(task)
            todoAdapter.addToDoItem(todo)
            binding.taskText.text.clear()
        }

    }
}