package com.example.myapplication.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.view.WordActivity

class WordAdapter(private val letter: String, context: Context) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    private val filteredWords: List<String>

    init {
        val words = context.resources.getStringArray(R.array.words).toList()
        filteredWords = words.filter { it.startsWith(letter, true) }
            .shuffled()
            .take(5)
            .sorted()
    }


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text: TextView = view.findViewById(R.id.item_letter)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_letter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = filteredWords[position]

        holder.text.text = item
        holder.text.setOnClickListener{
            val queryUrl: Uri = Uri.parse("${WordActivity.SEARCH_PREFIX}${item}")
            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return filteredWords.size
    }

}
