package com.terryzh.HOC

import java.io.File

class Animal(var name: String, var age: Int, var category: String)

fun main() {
    // region + 折叠
    // 什么是 HOC
    // 参数类型包含函数类型或返回值类型为函数类型的函数为高阶函数
    fun needsFunction(block: () -> Unit) {
        block()
    }

    fun returnsFunction(): () -> Long {
        return { System.currentTimeMillis() }
    }

    // 常见的高阶函数
//    inline fun IntArray.forEach(action: (Int) -> Unit): Unit {
//        for (ele in this) action(ele)
//    }

//    inline fun<R> IntArray.map(transform: (Int)-> R):List<R>{
//        return mapTo(ArrayList<R>(size), transform)
//    }

    // endregion
    fun cost(block: () -> Unit) {
        val start = System.currentTimeMillis()
        block()
        println("${System.currentTimeMillis() - start}ms")
    }

    // 斐波那契数列
    fun fibonacci(): () -> Long {
        var first = 0L
        var second = 1L
        return {
            val next = first + second
            val current = first
            first = second
            second = next
            current
        }
    }

    // usage
    cost {
        val fibonacciNext = fibonacci()
        println("out${fibonacciNext()}")
        println("out${fibonacciNext()}")
        for (i in 0..10) {
            println(fibonacciNext())
        }
    }


    // 几种常用的高阶函数
    val animal = Animal("dog", 1, "tidy")

    animal.let(::println)

    animal.run(::println)

    val animal1 = animal.also {
        it.name = "cat"
    }

    val animal2 = animal.apply {
        name = "cat"
    }

    // use
    File("build.gradle").inputStream().reader().buffered()
        .use {
            println(it.readLine())
        }

    // forEach 函数的特殊用法 @forEach
    val list = IntArray(5) { it * 2 }
    list.forEach {
        if (it == 4) {
            println("hehe" + it)
            return@forEach
        }
        println(it)
    }

}