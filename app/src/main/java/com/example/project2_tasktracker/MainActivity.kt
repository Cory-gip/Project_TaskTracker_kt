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
        todoAdapter = TodoAdapter(mutableListOf(), this)

        binding.toDoViewer.adapter = todoAdapter
        binding.toDoViewer.layoutManager = LinearLayoutManager(this)
        binding.addTaskButton.setOnClickListener{ addTask() }
        binding.deleteCheckedTasksButton.setOnClickListener { deleteCheckedTasks() }
    }

    //This method is for calling the adapter's delete method.
    private fun deleteCheckedTasks() {
        todoAdapter.deleteDoneToDoItems()
    }

    /* This method checks to make sure an empty string is not being added, then calls the adapter's
    add method. */
    private fun addTask() {
        val task = binding.taskText.text.toString()
        if(task.isNotEmpty()) {
            val todo = Todo(task)
            todoAdapter.addToDoItem(todo)
            binding.taskText.text.clear()
        }

    }
}