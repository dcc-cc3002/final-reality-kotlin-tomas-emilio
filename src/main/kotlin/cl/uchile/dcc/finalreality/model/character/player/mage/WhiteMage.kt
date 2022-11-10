/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player.mage

import cl.uchile.dcc.finalreality.exceptions.InvalidWeaponException
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Sword
import java.util.concurrent.BlockingQueue

/**
 * A White Mage is a type of [AbstractMage] that can cast white magic.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param maxMp       the character's maximum magic points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new Black Mage.
 *
 * @property currentMp The current MP of the character.
 * @property currentHp The current HP of the character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
class WhiteMage(
    name: String,
    maxHp: Int,
    maxMp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : AbstractMage(name, maxHp, maxMp, defense, turnsQueue) {
    override fun equipAxe(axe: Axe) {
        throw InvalidWeaponException("A White Mage can´t use an Axe")
    }
    override fun equipBow(bow: Bow) {
        throw InvalidWeaponException("A White Mage can´t use a Bow")
    }
    override fun equipKnife(knife: Knife) {
        throw InvalidWeaponException("A White Mage can´t use a Knife")
    }
    override fun equipSword(sword: Sword) {
        throw InvalidWeaponException("A White Mage can´t use a Sword")
    }
}
