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

class KnightTest : FunSpec({
    context("Equip") {
        test("A knight can equip an axe") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.string(), // axeName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, defense, axeName, damage, weight ->
                val knight = Knight(name, maxHp, defense, LinkedBlockingQueue())
                val axe = Axe(axeName, damage, weight)
                knight.equip(axe)
                knight.equippedWeapon shouldBe axe
            }
        }

        test("A knight can't equip a bow") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.string(), // bowName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, defense, bowName, damage, weight ->
                val knight = Knight(name, maxHp, defense, LinkedBlockingQueue())
                val bow = Bow(bowName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    knight.equip(bow)
                }
                exception.message shouldBe "A Knight can´t use a Bow"
            }
        }

        test("A knight can equip a knife") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.string(), // knifeName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, defense, knifeName, damage, weight ->
                val knight = Knight(name, maxHp, defense, LinkedBlockingQueue())
                val knife = Knife(knifeName, damage, weight)
                knight.equip(knife)
                knight.equippedWeapon shouldBe knife
            }
        }

        test("A knight can't equip a staff") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.string(), // staffName
                Arb.positiveInt(), // damage
                Arb.positiveInt(), // weight
                Arb.positiveInt() // magicDamage
            ) { name, maxHp, defense, staffName, damage, weight, magicDamage ->
                val knight = Knight(name, maxHp, defense, LinkedBlockingQueue())
                val staff = Staff(staffName, damage, weight, magicDamage)
                val exception = shouldThrow<InvalidWeaponException> {
                    knight.equip(staff)
                }
                exception.message shouldBe "A Knight can´t use a Staff"
            }
        }

        test("A knight can equip a sword") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.string(), // swordName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, defense, swordName, damage, weight ->
                val knight = Knight(name, maxHp, defense, LinkedBlockingQueue())
                val sword = Sword(swordName, damage, weight)
                knight.equip(sword)
                knight.equippedWeapon shouldBe sword
            }
        }
    }
})
