package com.github.k0zka.flyweight.annotation

/**
 * Implicitly marks a property as not-ok for flyweight, which is anyway the default behavior, but in some cases it may
 * be better to make it clear
 */
@Target(AnnotationTarget.PROPERTY, AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FlyWeightIgnore