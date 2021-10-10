package com.example.myapplication

import org.junit.Test

class LambdaTest {

    @Test
    fun testLambda(){
        val triple: (Int) -> Int = {a:Int -> a * 3}
        println(triple(5))
    }

    @Test
    fun  testLambda2(){
        //简写方式，lambda 只有一个参数的情况很常见，因此 Kotlin 提供了一种简写形式。
        // Kotlin 隐式使用特殊标识符 it 表示只有一个参数的 lambda 的参数。
        val triple : (Int)->Int = {it * 3}
        println(triple(5))
    }

    @Test
    fun highFun(){
        val peopleNames = listOf("Fred", "Ann", "Barbara", "Joe")
        val sortedWith =
            peopleNames.sortedWith { str1: String, str2: String -> str1.length - str2.length }
        println(sortedWith)
    }

    @Test
    fun testLambdaAndHighFun(){
        val words = listOf("about", "acute", "awesome", "balloon", "best", "brief", "class", "coffee", "creative")
        val arr = words.filter{it.startsWith("a",true)}
            .shuffled()
            .take(2)
            .sorted()
        println(arr)
    }
}