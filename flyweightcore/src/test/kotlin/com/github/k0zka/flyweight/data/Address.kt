package com.github.k0zka.flyweight.data

import com.github.k0zka.flyweight.annotation.FlyWeight

data class Address(
		@FlyWeight
		val country: String,
		@FlyWeight
		val postalCode: String,
		@FlyWeight
		val town: String,
		@FlyWeight
		val street: String,
		@FlyWeight
		val nr: String
)