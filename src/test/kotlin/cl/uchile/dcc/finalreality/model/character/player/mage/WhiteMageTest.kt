package cl.uchile.dcc.finalreality.model.character.player.mage

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

class WhiteMageTest : FunSpec({
    context("Equip") {
        test("A white mage can´t equip an axe") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt(), // defense
                Arb.string(), // axeName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, maxMp, defense, axeName, damage, weight ->
                val wm = WhiteMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val axe = Axe(axeName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    wm.equip(axe)
                }
                exception.message shouldBe "A White Mage can´t use an Axe"
            }
        }

        test("A white mage can't equip a bow") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt(), // defense
                Arb.string(), // bowName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, maxMp, defense, bowName, damage, weight ->
                val wm = WhiteMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val bow = Bow(bowName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    wm.equip(bow)
                }
                exception.message shouldBe "A White Mage can´t use a Bow"
            }
        }

        test("A white mage can´t equip a knife") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt(), // defense
                Arb.string(), // knifeName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, maxMp, defense, knifeName, damage, weight ->
                val wm = WhiteMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val knife = Knife(knifeName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    wm.equip(knife)
                }
                exception.message shouldBe "A White Mage can´t use a Knife"
            }
        }

        test("A white mage can equip a staff") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt(), // defense
                Arb.string(), // staffName
                Arb.positiveInt(), // damage
                Arb.positiveInt(), // weight
                Arb.positiveInt() // magicDamage
            ) { name, maxHp, maxMp, defense, staffName, damage, weight, magicDamage ->
                val wm = WhiteMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val staff = Staff(staffName, damage, weight, magicDamage)
                wm.equip(staff)
                wm.equippedWeapon shouldBe staff
            }
        }

        test("A white mage can´t equip a sword") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt(), // defense
                Arb.string(), // swordName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, maxMp, defense, swordName, damage, weight ->
                val wm = WhiteMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val sword = Sword(swordName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    wm.equip(sword)
                }
                exception.message shouldBe "A White Mage can´t use a Sword"
            }
        }
    }
})
