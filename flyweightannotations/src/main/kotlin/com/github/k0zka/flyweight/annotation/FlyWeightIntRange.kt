package com.github.k0zka.flyweight.annotation

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
annotation class FlyWeightIntRange(val min: Int, val max: Int)