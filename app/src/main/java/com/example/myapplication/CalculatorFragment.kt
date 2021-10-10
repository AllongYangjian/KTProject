package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentCalculatorBinding
import com.google.android.material.snackbar.Snackbar
import java.text.NumberFormat

class CalculatorFragment : Fragment() {

    private var _binding: FragmentCalculatorBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentCalculatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calculateButton.setOnClickListener{
            hideInput()
            binding.tipResult.text =  calculateTips()
        }

        binding.editText.setOnKeyListener{ v,keyCode,_ -> handleKeyEvent(v,keyCode)}
    }

    private fun handleKeyEvent(view:View,code:Int):Boolean{
        if(code == KeyEvent.KEYCODE_ENTER){
            hideInput()
            calculateTips()
            return true
        }
        return false
    }

    private fun hideInput(){
        val inputManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(binding.editText.windowToken,0)
    }


    private fun calculateTips(): String? {
        val toString = binding.editText.text.toString()
        val toDoubleOrNull = toString.toDoubleOrNull()
        if (toDoubleOrNull == null) {
            Snackbar.make(binding.editText,"请输入值",Snackbar.LENGTH_LONG).show()
            return null
        }
        val tipPercent = when (binding.rg.checkedRadioButtonId) {
            R.id.rb_1 -> 0.20
            R.id.rb_2 -> 0.18
            else -> 0.15
        }
        var tip = toDoubleOrNull * tipPercent
        val roundUp = binding.roundUpSwitch.isChecked
        if(roundUp){
            tip = kotlin.math.ceil(tip)
        }
        return NumberFormat.getCurrencyInstance().format(tip)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}