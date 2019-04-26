package com.github.k0zka.flyweight.annotation

/**
 * Marks a collection field as ok for flyweight.
 * @param max    the maximum size of the collection
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FlyWeightCollection(val max: Int = Int.MAX_VALUE)