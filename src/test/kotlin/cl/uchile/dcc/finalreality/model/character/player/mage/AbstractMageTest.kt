package cl.uchile.dcc.finalreality.model.character.player.mage

import cl.uchile.dcc.finalreality.exceptions.InvalidStatValueException
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import io.kotest.matchers.types.shouldHaveSameHashCodeAs
import io.kotest.matchers.types.shouldNotBeSameInstanceAs
import io.kotest.matchers.types.shouldNotHaveSameHashCodeAs
import io.kotest.property.Arb
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.positiveInt
import io.kotest.property.arbitrary.string
import io.kotest.property.assume
import io.kotest.property.checkAll
import java.util.concurrent.LinkedBlockingQueue

class AbstractMageTest : FunSpec({
    context("Equal") {
        test("Two mages with same attributes and same class are equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt() // defense
            ) { name, maxHp, maxMp, defense ->
                val wm1 = WhiteMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val wm2 = WhiteMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                wm1::class shouldBe wm2::class
                wm1 shouldNotBeSameInstanceAs wm2
                wm1 shouldBe wm2
                wm1 shouldHaveSameHashCodeAs wm2
            }
        }
        test("Two mages with same attributes but different class are not equal") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt() // defense
            ) { name, maxHp, maxMp, defense ->
                val wm = WhiteMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                val bm = BlackMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                wm::class shouldNotBe bm::class
                wm shouldNotBeSameInstanceAs bm
                wm shouldNotBe bm
                wm shouldNotHaveSameHashCodeAs bm
            }
        }
        test("Two mages with different maxMp") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp1
                Arb.positiveInt(), // maxMp2
                Arb.positiveInt() // defense
            ) { name, maxHp, maxMp1, maxMp2, defense ->
                assume(maxMp1 != maxMp2)
                val bm1 = BlackMage(name, maxHp, maxMp1, defense, LinkedBlockingQueue())
                val bm2 = BlackMage(name, maxHp, maxMp2, defense, LinkedBlockingQueue())
                bm1::class shouldBe bm2::class
                bm1 shouldNotBeSameInstanceAs bm2
                bm1 shouldNotBe bm2
                bm1 shouldNotHaveSameHashCodeAs bm2
            }
        }
    }
    context("Getters") {
        test("Get the maxMp of a mage") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.positiveInt(), // maxMp
                Arb.positiveInt() // defense
            ) { name, maxHp, maxMp, defense ->
                val bm = BlackMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                bm.getMaxMp() shouldBe maxMp
            }
        }
    }
    context("Constructor") {
        test("A mage can´t be initialized with zero or negative maxMp ") {
            checkAll(
                Arb.string(), // name
                Arb.positiveInt(), // maxHp
                Arb.int(max = 0), // maxMp
                Arb.positiveInt() // defense
            ) { name, maxHp, maxMp, defense ->
                val exception = shouldThrow<InvalidStatValueException> {
                    WhiteMage(name, maxHp, maxMp, defense, LinkedBlockingQueue())
                }
                exception.message shouldBe "The required condition is not met. 'Max Mp' ($maxMp must be at least 1)"
            }
        }
    }
})
