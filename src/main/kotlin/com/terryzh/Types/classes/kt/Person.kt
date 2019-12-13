package com.terryzh.Types.classes.kt

class Person (age: Int, name: String) {
    var age: Int = age
    get() {
        return field
    }
    set(value) {
        println("setAge: ${value}")
        field = value
    }

}