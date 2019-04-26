package com.github.k0zka.flyweight

import com.github.k0zka.flyweight.data.Address
import com.github.k0zka.flyweight.data.Car
import com.github.k0zka.flyweight.data.Gender
import com.github.k0zka.flyweight.data.Person
import org.junit.Test
import kotlin.test.assertTrue

class FlyWeightServiceTest {
	@Test
	fun flyweightPerson() {
		assertTrue("") {
			val service = FlyWeightService()
			val person = Person(
					firstName = "Eugene",
					lastName = "Cuckoo",
					gender = Gender.male
			)
			person == service.flyweight(person)
		}

		assertTrue("A flyweight instance must have the same string as name") {
			val service = FlyWeightService()
			val eugene = Person(
					firstName = "Eugene",
					lastName = "Cuckoo".toUpperCase(),
					gender = Gender.male
			)
			val eduard = Person(
					firstName = "Eduard",
					lastName = "cuckoo".toUpperCase(),
					gender = Gender.male
			)
			val eugeneFly = service.flyweight(eugene)
			val eduardFly = service.flyweight(eduard)
			eugene.lastName !== eduard.lastName &&
					eduardFly.lastName === eugeneFly.lastName
		}

		assertTrue("Address must be flyweighted") {
			val service = FlyWeightService()
			val eugene = Person(
					firstName = "Eugene",
					lastName = "Cuckoo",
					gender = Gender.male,
					address = Address(
							country = "Swaziland".toUpperCase(),
							postalCode = "1234",
							town = "Hunglibungli",
							street = "Hungli strasse",
							nr = "12"
					)
			)
			val eduard = Person(
					firstName = "Eduard",
					lastName = "Suckoo",
					gender = Gender.male,
					address = Address(
							country = "swaziland".toUpperCase(),
							postalCode = "1234",
							town = "Hunglibungli",
							street = "Hungli strasse",
							nr = "13"
					)

			)
			val eugeneFly = service.flyweight(eugene)
			val eduardFly = service.flyweight(eduard)

			eugene.address?.country !== eduard.address?.country
					&& eugeneFly.address?.country === eduardFly.address?.country
		}

		assertTrue("Do not flyweight the license plate nr, it is usually unique") {
			val car = Car(licensePlateNo = "abc-123", labels = listOf(), type = "Trabant")

			val flyTruck = FlyWeightService().flyweight(car)

			// we do not flyweight the license plate no
			flyTruck.licensePlateNo == car.licensePlateNo
					&& flyTruck.licensePlateNo === car.licensePlateNo
		}

		assertTrue("do not flyweight an immutable empty list, it has single instance") {
			val car = Car(licensePlateNo = "abc-123", labels = listOf(), type = "Trabant")

			val flyTruck = FlyWeightService().flyweight(car)

			flyTruck.labels == car.labels
					&& flyTruck.labels === car.labels
		}

		assertTrue("flyweight an immutable list if not empty, it may have some strings in common") {
			val car = Car(licensePlateNo = "abc-123", labels = listOf("old", "paper", "smelly"), type = "Trabant")

			val flyTruck = FlyWeightService().flyweight(car)

			flyTruck.labels == car.labels
					&& flyTruck.labels !== car.labels
		}

		assertTrue("flyweight the type, there aren't a lot of types anyway") {
			val car = Car(licensePlateNo = "abc-123", labels = listOf(), type = "Trabant")

			val flyTruck = FlyWeightService().flyweight(car)

			flyTruck.type == car.type
					&& flyTruck.type === car.type
		}

	}

}