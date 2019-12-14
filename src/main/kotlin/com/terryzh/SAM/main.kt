package com.terryzh.SAM

// SAM -> single abstract Method
fun Runnable(block: ()-> Unit): Runnable {
    return object: Runnable {
        override fun run() {
            block()
        }
    }
}
fun main() {

}