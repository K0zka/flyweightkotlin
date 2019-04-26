package com.github.k0zka.flyweight.integration

import java.util.Random

val random = Random()

fun <T> List<T>.random() = this[random.nextInt(this.size)]