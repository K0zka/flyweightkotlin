package com.github.k0zka.flyweight.data

import com.github.k0zka.flyweight.annotation.FlyWeight
import com.github.k0zka.flyweight.annotation.FlyWeightString

data class Person(
		@FlyWeight
		@FlyWeightString(maxLength = 10)
		val firstName: String,
		@FlyWeight
		val lastName: String,
		@FlyWeight
		val middleName: String? = null,
		@FlyWeight
		val address: Address? = null,
		val gender: Gender
)