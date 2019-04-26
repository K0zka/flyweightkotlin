package com.github.k0zka.flyweight.integration

import com.fasterxml.jackson.databind.ObjectMapper
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
open class JasonBenchmark {

	data class Person(
			val id: Int,
			val color: String,
			val firstName: String,
			val lastName: String
	)

	@Param("8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096", "8192", "16384", "32768", "65536")
	var size = 0

	companion object {
		val firstNames = listOf("Bob", "John", "Bill", "Jane", "Chris", "Ben", "Tom", "Sue")
		val lastNames = listOf(
				"Bush",
				"Clinton",
				"Nixon",
				"Kennedy",
				"Rosewelt",
				"Obama"
		)
		val colors = listOf("white", "black", "blue", "gray", "green", "pink", "zigzag")
	}

	private var people = listOf<Person>()

	private var flyWeightPeople = listOf<Person>()

	@Setup
	fun setup() {
		people = (1..size).map {
			Person(
					firstName = firstNames.random().toUpperCase(),
					lastName = lastNames.random().toUpperCase(),
					id = it,
					color = colors.random().toUpperCase()
			)
		}
		flyWeightPeople = people.map {
			it.copy(
					firstName = it.firstName.intern(),
					lastName = it.lastName.intern(),
					color = it.color.intern()
			)
		}
	}


	private var objectMapper = ObjectMapper()

	@Benchmark
	fun serialize(hole: Blackhole) {
		hole.consume(
				objectMapper.writeValueAsString(people)
		)
	}

	@Benchmark
	fun serializeFlyWeight(hole: Blackhole) {
		hole.consume(
				objectMapper.writeValueAsString(flyWeightPeople)
		)
	}

}