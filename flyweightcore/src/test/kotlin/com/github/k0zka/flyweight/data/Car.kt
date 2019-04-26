package com.github.k0zka.flyweight.data

import com.github.k0zka.flyweight.annotation.FlyWeight

data class Car(
		val licensePlateNo: String,
		@FlyWeight
		val type: String,
		@FlyWeight
		val labels: List<String> = listOf()
)