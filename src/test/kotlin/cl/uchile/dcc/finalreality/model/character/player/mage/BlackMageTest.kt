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

class BlackMageTest : FunSpec({
    context("Equip") {
        test("A black mage can´t equip an axe") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt(), // defense
                Arb.string(), // axeName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, maxMp, defense, axeName, damage, weight ->
                val bm = BlackMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val axe = Axe(axeName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    bm.equip(axe)
                }
                exception.message shouldBe "A Black Mage can´t use an Axe"
            }
        }

        test("A black mage can´t equip a bow") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt(), // defense
                Arb.string(), // bowName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, maxMp, defense, bowName, damage, weight ->
                val bm = BlackMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val bow = Bow(bowName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    bm.equip(bow)
                }
                exception.message shouldBe "A Black Mage can´t use a Bow"
            }
        }

        test("A black mage can equip a knife") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt(), // defense
                Arb.string(), // knifeName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, maxMp, defense, knifeName, damage, weight ->
                val bm = BlackMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val knife = Knife(knifeName, damage, weight)
                bm.equip(knife)
                bm.equippedWeapon shouldBe knife
            }
        }

        test("A black mage can equip a staff") {
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
                val bm = BlackMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val staff = Staff(staffName, damage, weight, magicDamage)
                bm.equip(staff)
                bm.equippedWeapon shouldBe staff
            }
        }

        test("A black mage can´t equip a sword") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt(), // defense
                Arb.string(), // swordName
                Arb.positiveInt(), // damage
                Arb.positiveInt() // weight
            ) { name, maxHp, maxMp, defense, swordName, damage, weight ->
                val bm = BlackMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val sword = Sword(swordName, damage, weight)
                val exception = shouldThrow<InvalidWeaponException> {
                    bm.equip(sword)
                }
                exception.message shouldBe "A Black Mage can´t use a Sword"
            }
        }
    }
})
