package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.mage.WhiteMage
import cl.uchile.dcc.finalreality.model.weapons.Staff
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldHaveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import io.kotest.matchers.types.shouldNotHaveSameHashCodeAs
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.negativeInt
import io.kotest.property.arbitrary.positiveInt
import io.kotest.property.arbitrary.string
import io.kotest.property.assume
import io.kotest.property.checkAll
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

class AbstractCharacterTest : FunSpec({
    context("Equal") {
        test("Two characters with same attributes and same class are equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt() // defense
            ) { name, maxHp, defense ->
                val eng1 = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                val eng2 = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                eng1::class shouldBe eng2::class
                eng1 shouldNotBeSameInstanceAs eng2
                eng1 shouldBe eng2
                eng1 shouldHaveSameHashCodeAs eng2
            }
        }
        test("Two characters with same attributes but different class are not equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt() // defense
            ) { name, maxHp, defense ->
                val eng = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                val knight = Knight(name, maxHp, defense, LinkedBlockingQueue())
                val thief = Thief(name, maxHp, defense, LinkedBlockingQueue())
                eng::class shouldNotBe knight::class
                eng::class shouldNotBe thief::class
                knight::class shouldNotBe thief::class
                eng shouldNotBeSameInstanceAs knight
                eng shouldNotBeSameInstanceAs thief
                knight shouldNotBeSameInstanceAs thief
                eng shouldNotBe knight
                eng shouldNotBe thief
                knight shouldNotBe thief
                eng shouldNotHaveSameHashCodeAs knight
                eng shouldNotHaveSameHashCodeAs thief
                knight shouldNotHaveSameHashCodeAs thief
            }
        }
        test("Two characters with different name are not equal") {
            checkAll(
                Arb.string(), // name1
                Arb.string(), // name2
                Arb.positiveInt(), // maxHp
                Arb.positiveInt() // defense
            ) { name1, name2, maxHp, defense ->
                assume(name1 != name2)
                val knight1 = Knight(name1, maxHp, defense, LinkedBlockingQueue())
                val knight2 = Knight(name2, maxHp, defense, LinkedBlockingQueue())
                knight1::class shouldBe knight2::class
                knight1 shouldNotBeSameInstanceAs knight2
                knight1 shouldNotBe knight2
                knight1 shouldNotHaveSameHashCodeAs knight2
            }
        }
        test("Two characters with different maxHp are not equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp1
                Arb.positiveInt(), // maxHp2
                Arb.positiveInt() // defense
            ) { name, maxHp1, maxHp2, defense ->
                assume(maxHp1 != maxHp2)
                val thief1 = Thief(name, maxHp1, defense, LinkedBlockingQueue())
                val thief2 = Thief(name, maxHp2, defense, LinkedBlockingQueue())
                thief1::class shouldBe thief2::class
                thief1 shouldNotBeSameInstanceAs thief2
                thief1 shouldNotBe thief2
                thief1 shouldNotHaveSameHashCodeAs thief2
            }
        }
        test("Two characters with different defense are not equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense1
                Arb.positiveInt() // defense2
            ) { name, maxHp, defense1, defense2 ->
                assume(defense1 != defense2)
                val thief1 = Thief(name, maxHp, defense1, LinkedBlockingQueue())
                val thief2 = Thief(name, maxHp, defense2, LinkedBlockingQueue())
                thief1::class shouldBe thief2::class
                thief1 shouldNotBeSameInstanceAs thief2
                thief1 shouldNotBe thief2
                thief1 shouldNotHaveSameHashCodeAs thief2
            }
        }
    }
    context("Getters") {
        test("Get the name of a character") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
                Arb.positiveInt(), // attack
                Arb.positiveInt() // weight
            ) { name, maxHp, defense, weight, attack ->
                val enemy = Enemy(name, maxHp, defense, weight, attack, LinkedBlockingQueue())
                enemy.getName() shouldBe name
            }
        }
        test("Get the maxHp of a character") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt() // defense
            ) { name, maxHp, defense ->
                val eng = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                eng.getMaxHp() shouldBe maxHp
            }
        }
        test("Get the defense of a character") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt() // defense
            ) { name, maxHp, defense ->
                val eng = Engineer(name, maxHp, defense, LinkedBlockingQueue())
                eng.getDefense() shouldBe defense
            }
        }
    }
    context("Constructor") {
        test("A character can´t be initialized with zero or negative maxHp ") {
            checkAll(
                Arb.string(), // name
                Arb.int(max = 0), // maxHp
                Arb.positiveInt() // defense
            ) { name, maxHp, defense ->
                val exception = shouldThrow<InvalidStatValueException> {
                    Engineer(name, maxHp, defense, LinkedBlockingQueue())
                }
                exception.message shouldBe "The required condition is not met. 'Max Hp' ($maxHp must be at least 1)"
            }
        }
        test("A character can´t be initialized with negative defense ") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.negativeInt() // defense
            ) { name, maxHp, defense ->
                val exception = shouldThrow<InvalidStatValueException> {
                    Knight(name, maxHp, defense, LinkedBlockingQueue())
                }
                exception.message shouldBe "The required condition is not met. 'Defense' ($defense must be at least 0)"
            }
        }
    }
    context("Wait Turn") {
        test("The order of the turns of the character must be related to their weapon weight or enemy weight)") {
            val queue = LinkedBlockingQueue<GameCharacter>()
            val enemy = Enemy("", Random.nextInt(1, 30), 1, 1, 1, queue)
            val wm = WhiteMage("", 1, 1, 1, queue)
            val wmWeapon = Staff("", 1, Random.nextInt(1, 30), 1)
            wm.equip(wmWeapon)
            enemy.waitTurn()
            wm.waitTurn()
            Thread.sleep(4000)
            val first = queue.poll().getWeight()
            val second = queue.poll().getWeight()
            second shouldBeGreaterThan first
        }
    }
    context("Modify Hp") {
        test("Modifies the currentHp gives a value always between 0 and maxHp") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // defense
            ) { name, maxHp, defense ->
                val knight = Knight(name, maxHp, defense, LinkedBlockingQueue())
            }
        }
    }
})
