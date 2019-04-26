package com.github.k0zka.flyweight.integration

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Param
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.Setup
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
open class SortBenchmark {

	@Param("8", "16", "32", "64", "128", "256", "512", "1024", "2048", "4096", "8192", "16384", "32768", "65536")
	var size = 0

	@Param("4", "8", "16", "32", "64", "128", "256", "512", "1024")
	var differentItems = 4

	var items = listOf<String>()
	var flyWeightItems = listOf<String>()

	@Setup
	fun setup() {
		items = (1..size).map { "item ${it % differentItems}" }.shuffled()
		flyWeightItems = items.map { it.intern() }
	}

	@Benchmark
	fun sort(hole: Blackhole) {
		hole.consume(items.sorted())
	}

	@Benchmark
	fun sortFlyWeight(hole: Blackhole) {
		hole.consume(flyWeightItems.sorted())
	}

}