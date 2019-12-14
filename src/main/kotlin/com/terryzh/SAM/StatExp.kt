package com.terryzh.SAM

import java.io.File

// 统计字符个数
fun main() {
    File("exp.txt").readText().toCharArray()
        .filterNot {
            it.isWhitespace()
        }
        .groupBy {
            it
        }
        .map {
            it.key to it.value.size
        }
        .let {
            println(it)
        }
}