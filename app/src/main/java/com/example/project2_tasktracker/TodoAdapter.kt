package com.example.project2_tasktracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TodoAdapter(
    private val todos: MutableList<Todo>
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.toDoItem)
        val checkBox: CheckBox = itemView.findViewById(R.id.cbDone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_todo,
            parent,
            false
        )

        return TodoViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentToDo = todos[position]
        holder.textView.text = currentToDo.title
        holder.checkBox.isChecked = currentToDo.isChecked
        holder.checkBox.setOnCheckedChangeListener { _, _ -> currentToDo.isChecked = !currentToDo.isChecked  }
    }

    override fun getItemCount(): Int {
            return todos.size
        }

    fun addToDoItem(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    fun deleteDoneToDoItems() {
        todos.removeAll { todo -> todo.isChecked  }
        notifyDataSetChanged()
    }
}
