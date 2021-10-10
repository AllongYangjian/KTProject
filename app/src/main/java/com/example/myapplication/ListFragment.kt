package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapter.ItemAdapter
import com.example.myapplication.data.Datasource
import com.example.myapplication.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private var _bind: FragmentListBinding? = null



    private val bind get() = _bind!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bind = FragmentListBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView(){
        var dataSet = Datasource().loadAffirmations()
        bind.rvList.adapter = ItemAdapter(this.requireContext(),dataSet)

        bind.rvList.setHasFixedSize(true)
    }


    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }

}