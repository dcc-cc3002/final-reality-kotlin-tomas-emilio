package cl.uchile.dcc.finalreality.model.effect

import cl.uchile.dcc.finalreality.model.character.GameCharacter

/**
 * Burned: Effects are designed with composite pattern, this is one of the "leafs"
 *
 * @param character          the character who is affected with the effect
 * @param magicDamage        the magic damage from the mage who cast the respective spell
 *
 * @property damage the damage applied for the effect
 *
 * @constructor Creates a new Burned effect
 */
class Burned(
    val character: GameCharacter,
    private val magicDamage: Int
) : Effect {
    val damage = magicDamage / 2

    /**
     * Apply the effect to  the character
     *
     */
    override fun applyEffect() {
        character.alterHp(-damage)
    }
}
