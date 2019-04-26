package com.github.k0zka.flyweight

import com.github.k0zka.flyweight.annotation.FlyWeight
import java.math.BigDecimal
import java.math.BigInteger
import java.util.UUID
import kotlin.reflect.KClass
import kotlin.reflect.full.functions
import kotlin.reflect.full.memberProperties

class FlyWeightService {

	companion object {
		val knownImmutables = setOf<KClass<*>>(
				String::class,
				Int::class,
				Boolean::class,
				Double::class,
				Float::class,
				Long::class,
				BigDecimal::class,
				BigInteger::class,
				Short::class,
				UUID::class
		)
	}

	fun <T : Any> flyweight(data: T): T =
			when (data) {
				is String -> data.intern() as T
				is List<*> -> {
					if (data.isEmpty()) {
						data
					} else {
						val mapped = data.map { item -> item?.let { flyweight(item) } ?: null }
						mapped as T
					}
				}
				data.javaClass.kotlin in knownImmutables -> data
				else ->
					if (data.javaClass.kotlin.let { it.isData && it.isFinal }) {
						val copyMethod = data.javaClass.kotlin.functions.single { "copy" == it.name }
						val properties = data.javaClass.kotlin.memberProperties.associateBy { it.name }
						val params = Array(copyMethod.parameters.size - 1) { idx ->
							val componentMethod =
									data.javaClass.declaredMethods.single { it.name == "component${idx + 1}" }
							val originalValue = componentMethod.invoke(data)

							val parameter = copyMethod.parameters[idx + 1]
							if (properties[parameter.name]?.annotations?.any { it is FlyWeight } == true) {
								originalValue?.let { flyweight(it) }
							} else {
								originalValue
							}
						}
						val copy = copyMethod.call(data, *params)
						copy as T
					} else data
			}
}