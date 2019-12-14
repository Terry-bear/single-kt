package com.terryzh.listAndSequence

fun main() {

    // 集合与序列
    // java8 引入的 stream 流式在 kt 的实现
    val list = IntArray(10) { it * 2 }
    // 懒汉式
    println("----------懒汉式----------")
    list.asSequence()
        .filter {
            println("filter-> $it")
            it % 2 == 0
        }
        .map {
            println("map-> $it")
            it * 2 + 1
        }
        .forEach {
            println("forEach-> $it")
        }
    println("----------End----------")
    // 饿汉式 ---> JavaScript 里面没有 Sequence,只有饿汉式遍历
    println("----------饿汉式----------")
    list
        .filter {
            println("filter-> $it")
            it % 2 == 0
        }
        .map {
            println("map-> $it")
            it * 2 + 1
        }
        .forEach {
            println("forEach-> $it")
        }
    println("----------End----------")

    // flatMap
    list
        .flatMap {
            0 until it
        }
    list.asSequence()
        .flatMap {
            (0 until it).asSequence()
        }

}