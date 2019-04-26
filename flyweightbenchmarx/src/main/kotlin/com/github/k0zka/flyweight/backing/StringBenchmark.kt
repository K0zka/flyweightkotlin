package com.github.k0zka.flyweight.backing

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole
import java.util.UUID

@State(Scope.Benchmark)
open class StringBenchmark {

	var testString = UUID.randomUUID().toString()

	@Param(
			"0",
			"2",
			"4",
			"6",
			"8",
			"16",
			"32",
			"64",
			"128",
			"256",
			"512",
			"1024",
			"2048",
			"4096",
			"8192",
			"16384",
			"32768",
			"65536",
			"131072",
			"262144")
	var size = 0

	var otherInternStrings = listOf<String>()

	@Setup
	fun setup() {
		otherInternStrings = (0..size).map { UUID.randomUUID().toString().intern() }
	}

	@Benchmark
	fun intern(hole: Blackhole) {
		hole.consume(testString.intern())
	}
}