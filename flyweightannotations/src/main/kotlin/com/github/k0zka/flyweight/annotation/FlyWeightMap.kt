package com.github.k0zka.flyweight.annotation

/**
 * Marks a map property as ok or flyweight.
 * @param keys flyweight the keys
 * @param values flyweight the values
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FlyWeightMap(val keys: Boolean = true, val values: Boolean = true)