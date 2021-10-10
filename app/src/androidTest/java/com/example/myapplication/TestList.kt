package com.example.myapplication

import com.example.myapplication.demolist.Noodles
import com.example.myapplication.demolist.Order
import com.example.myapplication.demolist.Vegetables
import org.junit.Test

class TestList {
    @Test
    fun testMain1() {

        val noodles = Noodles()
        val vegetables = Vegetables("Cabbage","sprouts","onion")
        val vegetables2 = Vegetables()

        println(noodles)
        println(vegetables)
        println(vegetables2)
    }

    @Test
    fun testOrder(){
        val orderList = mutableListOf<Order>()

        val order1 = Order(1)
        order1.addItem(Noodles()).addItem(Vegetables("HH"))

        orderList.add(order1)

        val order2 = Order(2)
        order2.addItem(Noodles()).addItem(Vegetables("HH","ss"))
        orderList.add(order2)

        for(order in orderList){
            order.print()
            println("############")
            println()
        }
    }
}