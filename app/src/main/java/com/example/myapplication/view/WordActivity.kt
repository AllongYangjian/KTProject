package com.example.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.WordAdapter
import com.example.myapplication.databinding.ActivityWordBinding

class WordActivity : AppCompatActivity() {

    companion object{
        const val KEY = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bind = ActivityWordBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val letter = intent?.extras?.getString(KEY).toString()

        val recyclerView = bind.rvWord

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WordAdapter(letter,this)
        title = getString(R.string.detail_prefix)+" "+letter

    }
}