package com.terryzh.Types.nullables

import java.io.File

fun main() {
//    var nonnull: String = "hello"
//    nonnull = null
//    val len = nonnull.length

    var nullable: String? = "hello"
//    val len = nullable?.length
    val len = nullable?.length ?: 0 // elvis boolean? a: b

    var x: String = "Hello"
    var y: String? = "World"

//    x = y // Type mismatch
    y = x // OK

    var a: Int = 2
    var b: Number = 10.0

//    a = b // Type mismatch
    b = a // OK













//    val person = Person()
//    val title = person.title
//
//    val titleLength = title?.length

    val file = File("abc")

    val files = file.listFiles()
    println(files.size)
}