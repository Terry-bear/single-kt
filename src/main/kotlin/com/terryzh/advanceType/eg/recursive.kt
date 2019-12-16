package com.terryzh.advanceType.eg

sealed class IntList {
    object Nil : IntList() {
        override fun toString(): String {
            return "Nil"
        }
    }

    data class Cons(val head: Int, val tail: IntList) : IntList() {
        override fun toString(): String {
            return "$head $tail"
        }
    }

    fun joinToString(seq: Char = ','): String {
        return when (this) {
            Nil -> "Nil"
            is Cons -> {
                "$head$seq${tail.joinToString(seq)}"
            }
        }
    }
}


fun intListOf(vararg ints: Int): IntList {
    return when (ints.size) {
        0 -> IntList.Nil
        else -> {
            IntList.Cons(
                ints[0],
                intListOf(*(ints.slice(1 until ints.size).toIntArray()))
            )
        }
    }
}

// [0, 1, 2, 3]
fun main() {
//    val list = IntList.Cons(
//        0,
//        IntList.Cons(
//            1,
//            IntList.Cons(
//                2,
//                IntList.Cons(
//                    3,
//                    IntList.Nil
//                )
//            )
//        )
//    )
    val list = intListOf(0, 1, 2, 3)
    println(list)
    println(list.joinToString('-'))
}