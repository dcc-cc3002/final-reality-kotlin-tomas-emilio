package cl.uchile.dcc.finalreality.model.character

/**
 * This represents a character from the game.
 * A character can be controlled by the player or by the CPU (an enemy).
 *
 * @property name
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
    fun getName() : String
    fun getCurrentHp() : Int
    fun getMaxHp() : Int
    fun getDefense() : Int
    //fun setCurrentHp(hp:Int)
}
