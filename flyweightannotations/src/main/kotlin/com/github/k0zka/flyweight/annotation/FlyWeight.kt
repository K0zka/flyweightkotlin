package com.github.k0zka.flyweight.annotation

/**
 * Marks fields of a class as ok for replacement by the flyweight service.
 */
@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FlyWeight