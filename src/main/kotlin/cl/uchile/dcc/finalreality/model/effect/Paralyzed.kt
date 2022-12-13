package cl.uchile.dcc.finalreality.model.effect

import cl.uchile.dcc.finalreality.model.character.GameCharacter

/**
 * Paralyzed: Effects are designed with composite pattern, this is one of the "leafs"
 *
 * @param character          the character who is affected with the effect
 *
 * @constructor Creates a new Paralyzed effect
 */
class Paralyzed(val character: GameCharacter) : Effect {
    /**
     * Apply the effect to the character
     *
     */
    /**
     * Apply the effect to the affected character with the respective power
     */
    override fun applyEffect() {
        character.isParalyzed = true
    }
}
