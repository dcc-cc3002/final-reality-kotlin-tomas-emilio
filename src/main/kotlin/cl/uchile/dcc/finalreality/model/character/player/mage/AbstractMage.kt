package cl.uchile.dcc.finalreality.model.character.player.mage

import cl.uchile.dcc.finalreality.exceptions.InvalidSpellException
import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter
import cl.uchile.dcc.finalreality.model.effect.Effect
import cl.uchile.dcc.finalreality.model.spell.Spell
import java.util.Objects
import java.util.concurrent.BlockingQueue

/**
 * Abstract mage
 *
 * @constructor
 *
 * @param name          the mage's name
 * @param maxHp         the mage's maximum health points
 * @param maxMp         the mage's maximum mana points
 * @param defense       the mage's defense
 * @param turnsQueue    the queue with the characters waiting for their turn
 * @constructor Creates a new mage
 *
 * @property currentMp The current mana points of the character.
 * @property currentHp The current health points of the character.
 */
abstract class AbstractMage(
    name: String,
    maxHp: Int,
    maxMp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : AbstractPlayerCharacter(name, maxHp, defense, turnsQueue), MageInterface {
    private val maxMp: Int = Require.Stat(maxMp, "Max Mp") atLeast 1

    private var currentMp: Int = maxMp
        set(value) {
            field = Require.Stat(value, "Current Mp") inRange 0..maxMp
        }

    /**
     * Get current mp
     *
     * @return returns the actual mana points of this mage
     */
    override fun getCurrentMp(): Int {
        return currentMp
    }

    /**
     * Get max mp
     *
     * @return return the maximum mana points of this mage
     */
    override fun getMaxMp(): Int {
        return maxMp
    }

    /**
     * Get magic damage
     *
     * @return the magic damage of this mage in relation with their equipped weapon
     */
    override fun getMagicDamage(): Int {
        return this.equippedWeapon.getMagicDamage()
    }

    override fun equals(other: Any?): Boolean {
        if (other !is AbstractMage) return false
        return super.equals(other) &&
            maxMp == other.maxMp
    }

    override fun hashCode() = Objects.hash(this::class, this.getName(), this.getMaxHp(), maxMp, this.getDefense())

    override fun toString() = super.toString().dropLast(2) +
        ", maxMp: $maxMp }"

    /**
     * Alter the mana points respecting the rules of minimum(0) and maximum(maxMp)
     *
     * @param n the amount to add to the currentMp, n can be a negative number
     */
    fun alterMp(n: Int) {
        if (currentMp + n <= 0) {
            currentMp = 0
        } else if (currentMp + n >= maxMp) {
            currentMp = maxMp
        } else {
            currentMp += n
        }
    }
    protected fun canPaySpell(spell: Spell): Boolean {
        return (spell.cost <= currentMp)
    }
    fun castSpell(spell: Spell, character: GameCharacter): Effect? {
        if (equippedWeapon.isMagic()) {
            return spell.castFromTo(this, character)
        } else {
            throw InvalidSpellException("A mage need a magic weapon to cast any spell")
        }
    }
}
