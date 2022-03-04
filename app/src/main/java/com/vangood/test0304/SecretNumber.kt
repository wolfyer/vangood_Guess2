package com.vangood.test0304

import kotlin.random.Random

class SecretNumber {
    val secret = Random.nextInt(10)+1
    var count = 1

    fun validate(number: Int):Int{
        count++
        return number - secret
    }
}

fun main() {
    val secretNumber = SecretNumber()
    println(secretNumber.secret)
    //println("${secretNumber.validate(2)},count: ${secretNumber.count}")
}
