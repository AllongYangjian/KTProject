package com.example.myapplication.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.adapter.LetterAdapter
import com.example.myapplication.databinding.FragmentLetterBinding

class LetterFragment : Fragment() {

    private var _binding: FragmentLetterBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLetterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvLetter.layoutManager = LinearLayoutManager(this.requireContext())
        binding.rvLetter.adapter = LetterAdapter(object : LetterAdapter.ItemClick {
            override fun onClick(letter: String) {
                val bundle = LetterFragmentArgs(letter).toBundle()
                findNavController().navigate(R.id.action_letterFragment_to_wordFragment,bundle)

//                startActivity(letter)
            }
        })
    }

    private fun startActivity(letter: String) {
        val intent = Intent(this.requireContext(), WordActivity::class.java)
        intent.putExtra(WordActivity.KEY, letter)
        startActivity(intent)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}