package cl.uchile.dcc.finalreality.model.effect

import cl.uchile.dcc.finalreality.model.character.GameCharacter

/**
 * Composite effect: Effects are designed with composite pattern, this is the "composite"
 *
 * the tree of the composite have height 3, the top class have a list of composite effects of a specific
 * character and their children have a list of a concrete effects who affects the father. The purpose
 * of this implementation is because the effects need to be applied for character, and not all the
 * effects at the same time.
 *
 * @param character the character who is affected for the effects
 * @constructor Create a new Composite effect
 */
class CompositeEffect(private val character: GameCharacter) : Effect {

    private val effects: MutableList<Effect> = mutableListOf<Effect>()

    /**
     * Apply the effect for all the items in the list
     *
     */
    override fun applyEffect() {
        for (e: Effect in effects) {
            e.applyEffect()
        }
    }

    fun add(effect: Effect) {
        effects.add(effect)
    }
    fun remove(effect: Effect) {
        effects.remove(effect)
    }
}
