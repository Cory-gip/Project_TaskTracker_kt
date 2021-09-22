package com.example.project2_tasktracker

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

//This is the Adapter class for handling the set of to-do items.
class TodoAdapter(
    /* When the class is instantiated, it will need an empty list for holding the to-do
    items, and a context in which to display them.
     */
    private val todos: MutableList<Todo>,
    private val context: Context
) : RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    //This class is for displaying and handling the data associated with each to-do item.
    class TodoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.toDoItem)
        val checkBox: CheckBox = itemView.findViewById(R.id.cbDone)
    }

    //When the ViewHolder is created, it will be attached to the item_todo xml file.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context).inflate(
            R.layout.item_todo,
            parent,
            false
        )

        return TodoViewHolder(adapterLayout)
    }

    /*This method will go through the list of todos and bind the data from each of their attributes
    to the item_todo xml file
    */
    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentToDo = todos[position]
        holder.textView.text = currentToDo.title
        holder.checkBox.isChecked = currentToDo.isChecked
        holder.checkBox.setOnCheckedChangeListener { _, _ -> currentToDo.isChecked = !currentToDo.isChecked  }
    }

    //This will keep track of how many to-do items are in the list
    override fun getItemCount(): Int {
            return todos.size
        }

    //This will add a to-do item to the end of the list, and update the size of the list.
    fun addToDoItem(todo: Todo) {
        todos.add(todo)
        notifyItemInserted(todos.size - 1)
    }

    //This will delete a to-do item from the list if it is checked, and update the size of the list.
    fun deleteDoneToDoItems() {
        todos.removeAll { todo -> todo.isChecked  }
        notifyDataSetChanged()
    }
}
