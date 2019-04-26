package com.github.k0zka.flyweight.annotation

/**
 * Adds restrictions on a string
 * @param maxLength    the maximum length of the string
 * @param pattern    a regular expression to match against, the string will only be fly-weighted if it matches
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FlyWeightString(val maxLength: Int = Int.MAX_VALUE, val pattern: String = "")