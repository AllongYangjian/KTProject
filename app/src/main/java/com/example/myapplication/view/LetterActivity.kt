package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapter.LetterAdapter
import com.example.myapplication.databinding.ActivityLetterBinding

class LetterActivity : AppCompatActivity() {


    private var isLinearLayoutManager = true
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLetterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        recyclerView = binding.rvLetter
        chooseLayout()
    }

    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(this)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
//        recyclerView.adapter = LetterAdapter(object : LetterAdapter.ItemClick {
//            override fun onClick(letter: String) {
//                startActivity(letter)
//            }
//        })
        recyclerView.adapter = LetterAdapter(itemClick)
    }

    private val itemClick: LetterAdapter.ItemClick = object : LetterAdapter.ItemClick {
        override fun onClick(letter: String) {
            startActivity(letter)
        }
    }

    private fun startActivity(letter: String) {
        val intent = Intent(this, WordActivity::class.java)
        intent.putExtra(WordActivity.KEY, letter)
        startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val layoutButton = menu?.findItem(R.id.action_settings)
        setIcon(layoutButton)
        return true
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        // Set the drawable for the menu icon based on which LayoutManager is currently in use

        // An if-clause can be used on the right side of an assignment if all paths return a value.
        // The following code is equivalent to
        // if (isLinearLayoutManager)
        //     menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
        // else menu.icon = ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this, R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this, R.drawable.ic_linear_layout)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_settings -> {
                isLinearLayoutManager = !isLinearLayoutManager
                chooseLayout()
                setIcon(item)
                return true
            }
            else -> false
        }
    }


}