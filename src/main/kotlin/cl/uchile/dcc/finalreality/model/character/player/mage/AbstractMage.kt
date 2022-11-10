package cl.uchile.dcc.finalreality.model.character.player.mage

import cl.uchile.dcc.finalreality.exceptions.Require
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.AbstractPlayerCharacter
import java.util.Objects
import java.util.concurrent.BlockingQueue

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

    override fun getCurrentMp(): Int {
        return currentMp
    }

    override fun getMaxMp(): Int {
        return maxMp
    }

    override fun equals(other: Any?): Boolean {
        if (other !is AbstractMage) return false
        return super.equals(other) &&
            maxMp == other.maxMp
    }

    override fun hashCode() = Objects.hash(this::class, this.getName(), this.getMaxHp(), maxMp, this.getDefense())

    override fun toString() = super.toString().dropLast(2) +
        ", maxMp: $maxMp }"
}
