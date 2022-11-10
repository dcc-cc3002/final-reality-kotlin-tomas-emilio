/*
 * "Final Reality" (c) by R8V and ~Your name~
 * "Final Reality" is licensed under a
 * Creative Commons Attribution 4.0 International License.
 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by/4.0/>.
 */
package cl.uchile.dcc.finalreality.model.character.player

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import cl.uchile.dcc.finalreality.model.weapons.WeaponInterface

/**
 * A character controlled by the user.
 *
 * @property equippedWeapon
 *    the weapon that the character is currently using
 * @author <a href="https://www.github.com/r8vnhill">R8V</a>
 * @author ~Your name~
 */
interface PlayerCharacter : GameCharacter {
    val equippedWeapon: WeaponInterface

    /**
     * Equips a weapon to the character.
     */
    fun equip(weapon: WeaponInterface)
    fun equipAxe(axe: Axe)
    fun equipBow(bow: Bow)
    fun equipKnife(knife: Knife)
    fun equipStaff(staff: Staff)
    fun equipSword(sword: Sword)
}
