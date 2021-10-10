package com.example.myapplication.view

import android.view.View
import com.example.myapplication.adapter.LetterAdapter.ItemClick

class TestView {
    fun test() {}
    private val onClickListener = View.OnClickListener { }
    private val itemClick: ItemClick = object : ItemClick {
        override fun onClick(letter: String) {}
    }
}