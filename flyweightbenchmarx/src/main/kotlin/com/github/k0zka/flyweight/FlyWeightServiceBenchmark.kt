package com.github.k0zka.flyweight

import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State


@State(Scope.Benchmark)
open class FlyWeightServiceBenchmark {

	@Benchmark
	fun flyweight() {

	}
}