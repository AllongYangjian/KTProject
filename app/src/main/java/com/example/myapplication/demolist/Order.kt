package com.example.myapplication.demolist

class Order(private val num: Int) {

    private val orderList = mutableListOf<Item>()

    fun addItem(item: Item):Order {
        orderList.add(item)
        return this
    }

    fun addItems(items: List<Item>):Order {
        orderList.addAll(items)
        return this
    }

    fun print() {
        println("Order #${num}")
        var total = 0;
        for (item in orderList) {
            println("${item}:$${item.price}")
            total += item.price
        }
        println("Total:$${total}")
    }


}