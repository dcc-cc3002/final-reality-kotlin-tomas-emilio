package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter
import java.util.Objects
import java.util.concurrent.BlockingQueue
import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.TimeUnit

/**
 * An abstract class that holds the common behaviour of all the characters in the game.
 *
 * @property name
 *    The name of the character.
 * @property maxHp
 *    The maximum health points of the character.
 * @property defense
 *    The defense of the character.
 * @property turnsQueue
 *    The queue with the characters waiting for their turn.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
abstract class AbstractCharacter(
    private val name: String,
    maxHp: Int,
    defense: Int,
    var turnsQueue: BlockingQueue<GameCharacter>,
) : GameCharacter {

    private val maxHp: Int = Require.Stat(maxHp, "Max Hp") atLeast 1
    private var currentHp: Int = maxHp
        set(value) {
            field = Require.Stat(value, "Current Hp") inRange 0..maxHp
        }
    private val defense: Int = Require.Stat(defense, "Defense") atLeast 0

    override fun getName() : String{
        return name
    }
    override fun getCurrentHp() : Int{
        return currentHp
    }
    override fun getMaxHp() : Int{
        return maxHp
    }
    override fun getDefense() : Int{
        return defense
    }

    private lateinit var scheduledExecutor: ScheduledExecutorService

    override fun waitTurn() {
        scheduledExecutor = Executors.newSingleThreadScheduledExecutor()
        when (this) {
            is PlayerCharacter -> {
                scheduledExecutor.schedule(
                    /* command = */ ::addToQueue,
                    /* delay = */ (this.equippedWeapon.getWeight() / 10).toLong(),
                    /* unit = */ TimeUnit.SECONDS
                )
            }

            is Enemy -> {
                scheduledExecutor.schedule(
                    /* command = */ ::addToQueue,
                    /* delay = */ (this.weight / 10).toLong(),
                    /* unit = */ TimeUnit.SECONDS
                )
            }
        }
    }

    /**
     * Adds this character to the turns queue.
     */
    private fun addToQueue() {
        turnsQueue.put(this)
        scheduledExecutor.shutdown()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AbstractCharacter) return false
        if (this::class != other::class) return false
        return defense == other.defense &&
            name == other.name &&
            maxHp == other.maxHp
    }

    override fun hashCode() = Objects.hash(this::class, name, maxHp, defense)

    override fun toString() = this::class.simpleName +
        " { " +
        "name: '$name', " +
        "maxHp: $maxHp, " +
        "defense: $defense, " +
        "currentHp: $currentHp " +
        "}"
}
