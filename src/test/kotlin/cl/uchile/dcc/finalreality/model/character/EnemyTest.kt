package cl.uchile.dcc.finalreality.model.character

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldBeIn
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

class EnemyTest : FunSpec({

    context("Wait Turn") {
        test("A enemy must added to the queue before a time delay") {
            val queue = LinkedBlockingQueue<GameCharacter>()
            val enemy = Enemy("", Random.nextInt(1, 50), 1, 1, 1, queue)
            enemy.waitTurn()
            queue.shouldBeEmpty()
            Thread.sleep(6000)
            enemy shouldBeIn queue
        }
    }
})
