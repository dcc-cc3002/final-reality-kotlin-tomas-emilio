package cl.uchile.dcc.finalreality.model.character

import cl.uchile.dcc.finalreality.exceptions.Require
import java.util.concurrent.BlockingQueue

/**
 * A class that holds all the information of a single enemy of the game.
 *
 * @param name The name of this enemy.
 * @property weight The weight of this enemy.
 * @param turnsQueue The queue with the characters waiting for their turn.
 * @param maxHp The maximum health points of this enemy.
 * @param defense The defense of this enemy.
 *
 * @constructor Creates a new enemy with a name, a weight and the queue with the characters ready to
 *  play.
 *
 * @author <a href="https://github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
class Enemy(
    name: String,
    weight: Int,
    maxHp: Int,
    defense: Int,
    private val attack: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : AbstractCharacter(name, maxHp, defense, turnsQueue) {
    private val weight = Require.Stat(weight, "Weight") atLeast 1
    override fun getWeight(): Int {
        return weight
    }

    /**
     * Attack to other character
     * an enemy can attack any character in the game, include allies and enemies
     *
     * @param character the character who this character attacks
     *
     */
    override fun attack(character: GameCharacter) {
        val damage: Int = attack - character.getDefense()
        if (damage > 0) {
            character.alterHp(-damage)
        }
    }

    override fun isPlayable(): Boolean {
        return false
    }
}
