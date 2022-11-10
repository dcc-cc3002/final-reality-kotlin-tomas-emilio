package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.positiveInt
import io.kotest.property.arbitrary.string
import io.kotest.property.checkAll
import java.util.concurrent.LinkedBlockingQueue

class EngineerTest : FunSpec({
    context("Equip") {
        test("An engineer can equip an axe") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp{
                Arb.positiveInt(), // defense
                Arb.string(), // axeName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, defense, axeName, damage, weight ->
                val eng = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                val axe = Axe(axeName, damage, weight)
                eng.equip(axe)
                eng.equippedWeapon shouldBe axe
            }
        }

        test("An engineer can equip a bow") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.string(), // bowName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, defense, bowName, damage, weight ->
                val eng = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                val bow = Bow(bowName, damage, weight)
                eng.equip(bow)
                eng.equippedWeapon shouldBe bow
            }
        }

        test("An engineer can't equip a knife") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.string(), // knifeName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, defense, knifeName, damage, weight ->
                val eng = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                val knife = Knife(knifeName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    eng.equip(knife)
                }
                exception.message shouldBe "An Engineer can´t use a Knife"
            }
        }

        test("An engineer can't equip a staff") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.string(), // staffName
                Arb.positiveInt(), // damage
                Arb.positiveInt(), // weight
                Arb.positiveInt() // magicDamage
            ) { name, maxHp, defense, staffName, damage, weight, magicDamage ->
                val eng = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                val staff = Staff(staffName, damage, weight, magicDamage)
                val exception = shouldThrow<InvalidWeaponException> {
                    eng.equip(staff)
                }
                exception.message shouldBe "An Engineer can´t use a Staff"
            }
        }

        test("An engineer can´t equip a sword") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.string(), // swordName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, defense, swordName, damage, weight ->
                val eng = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                val sword = Sword(swordName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    eng.equip(sword)
                }
                exception.message shouldBe "An Engineer can´t use a Sword"
            }
        }
    }
})
