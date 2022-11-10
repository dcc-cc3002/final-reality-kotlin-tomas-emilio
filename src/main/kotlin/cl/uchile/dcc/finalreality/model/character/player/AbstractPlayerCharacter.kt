package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.AbstractCharacter
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import cl.uchile.dcc.finalreality.model.weapons.WeaponInterface
import java.util.concurrent.BlockingQueue

/**
 * A class that holds all the information of a player-controlled character in the game.
 *
 * @param name        the character's name
 * @param maxHp       the character's maximum health points
 * @param defense     the character's defense
 * @param turnsQueue  the queue with the characters waiting for their turn
 * @constructor Creates a new playable character.
 *
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
abstract class AbstractPlayerCharacter(
    name: String,
    maxHp: Int,
    defense: Int,
    turnsQueue: BlockingQueue<GameCharacter>
) : AbstractCharacter(name, maxHp, defense, turnsQueue), PlayerCharacter {

    private lateinit var _equippedWeapon: WeaponInterface
    override val equippedWeapon: WeaponInterface
        get() = _equippedWeapon

    override fun equip(weapon: WeaponInterface) {
        weapon.canEquip(this)
    }

    override fun equipAxe(axe: Axe) {
        _equippedWeapon = axe
    }
    override fun equipBow(bow: Bow) {
        _equippedWeapon = bow
    }
    override fun equipKnife(knife: Knife) {
        _equippedWeapon = knife
    }
    override fun equipStaff(staff: Staff) {
        _equippedWeapon = staff
    }
    override fun equipSword(sword: Sword) {
        _equippedWeapon = sword
    }
    override fun getWeight(): Int {
        return equippedWeapon.getWeight()
    }
}
