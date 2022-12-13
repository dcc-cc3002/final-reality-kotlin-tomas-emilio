package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.model.effect.Effect
import cl.uchile.dcc.finalreality.model.states.TurnState
import cl.uchile.dcc.finalreality.model.states.WaitTurn

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 *    The name of the character.
 * @property maxHp
 *    The maximum health points of the character.
 * @property defense
 *    The defense of the character.
 * @property currentHp
 *    The current health points of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
interface GameCharacter {
    /**
     * Sets a scheduled executor to make this character (thread) wait for `speed / 10`
     * seconds before adding the character to the queue.
     */
    fun waitTurn()
    fun getName(): String
    fun getCurrentHp(): Int
    fun getMaxHp(): Int
    fun getDefense(): Int
    fun getWeight(): Int
    fun alterHp(n: Int)
    fun setState(state: TurnState)
    fun stateAction()
    fun isDied(): Boolean
    fun isPlayable(): Boolean
    fun applyEffect()
    fun removeFromQueue()

    fun attack(character: GameCharacter)

    var isParalyzed: Boolean

    val effects: Effect

    val waitTurn: WaitTurn
}
