package cl.uchile.dcc.finalreality.model.weapons

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldHaveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import io.kotest.matchers.types.shouldNotHaveSameHashCodeAs
import io.kotest.property.Arb
import io.kotest.property.arbitrary.positiveInt
import io.kotest.property.arbitrary.string
import io.kotest.property.assume
import io.kotest.property.checkAll

class AbstractWeaponTest : FunSpec({
    context("Equal") {
        test("Two weapons with same attributes and same class are equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, damage, weight ->
                val axe1 = Axe(name, damage, weight)
                val axe2 = Axe(name, damage, weight)
                axe1::class shouldBe axe2::class
                axe1 shouldNotBeSameInstanceAs axe2
                axe1 shouldBe axe2
                axe1 shouldHaveSameHashCodeAs axe2
            }
        }
        test("Two weapons with same attributes but different class are not equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, damage, weight ->
                val axe = Axe(name, damage, weight)
                val staff = Sword(name, damage, weight)
                axe::class shouldNotBe staff::class
                axe shouldNotBeSameInstanceAs staff
                axe shouldNotBe staff
                axe shouldNotHaveSameHashCodeAs staff
            }
        }
        test("Two weapons with different name are not equal") {
            checkAll(
                Arb.string(), // name1
                Arb.string(), // name2
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name1, name2, damage, weight ->
                assume(name1 != name2)
                val bow1 = Bow(name1, damage, weight)
                val bow2 = Bow(name2, damage, weight)
                bow1::class shouldBe bow2::class
                bow1 shouldNotBeSameInstanceAs bow2
                bow1 shouldNotBe bow2
                bow1 shouldNotHaveSameHashCodeAs bow2
            }
        }
        test("Two weapons with different damage are not equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // damage1
                Arb.positiveInt(), // damage2
                Arb.positiveInt() // weight
            ) { name, damage1, damage2, weight ->
                assume(damage1 != damage2)
                val knife1 = Knife(name, damage1, weight)
                val knife2 = Knife(name, damage2, weight)
                knife1::class shouldBe knife2::class
                knife1 shouldNotBeSameInstanceAs knife2
                knife1 shouldNotBe knife2
                knife1 shouldNotHaveSameHashCodeAs knife2
            }
        }
        test("Two weapons with different weight are not equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // damage
                Arb.positiveInt(), // weight1
                Arb.positiveInt() // weight2
            ) { name, damage, weight1, weight2 ->
                assume(weight1 != weight2)
                val sword1 = Sword(name, damage, weight1)
                val sword2 = Sword(name, damage, weight2)
                sword1::class shouldBe sword2::class
                sword1 shouldNotBeSameInstanceAs sword2
                sword1 shouldNotBe sword2
                sword1 shouldNotHaveSameHashCodeAs sword2
            }
        }
    }
    context("Getters") {
        test("Get the name of a weapon") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // damage
                Arb.positiveInt(), // weight
                Arb.positiveInt() // magicDamage
            ) { name, damage, weight, magicDamage ->
                val staff = Staff(name, damage, weight, magicDamage)
                staff.getName() shouldBe name
            }
        }
        test("Get the damage of a weapon") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, damage, weight ->
                val knife = Knife(name, damage, weight)
                knife.getDamage() shouldBe damage
            }
        }
        test("Get the weight of a weapon") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, damage, weight ->
                val axe = Axe(name, damage, weight)
                axe.getWeight() shouldBe weight
            }
        }
    }
})
