package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapons.Knife
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldBeIn
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

class AbstractPlayerCharacterTest : FunSpec({

    context("Wait Turn") {
        test("A player character must added to the queue before a time delay") {
            val queue = LinkedBlockingQueue<GameCharacter>()
            val thief = Thief("", 1, 1, queue)
            val knife = Knife("", 1, Random.nextInt(1, 50))
            thief.equip(knife)
            thief.waitTurn()
            queue.shouldBeEmpty()
            Thread.sleep(6000)
            thief shouldBeIn queue
        }
    }
})
