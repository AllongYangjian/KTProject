package com.example.myapplication.adapter

import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.example.myapplication.R

class LetterAdapter(private val listener: LetterAdapter.ItemClick) :
    RecyclerView.Adapter<LetterAdapter.ViewHolder>() {

    private val list = ('A').rangeTo('Z').toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_letter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.letter.text = list[position].toString()
        holder.letter.setOnClickListener { listener.onClick(list[position].toString()) }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val letter: TextView = view.findViewById(R.id.item_letter)
    }

    interface ItemClick {
        fun onClick(letter: String);
    }
}