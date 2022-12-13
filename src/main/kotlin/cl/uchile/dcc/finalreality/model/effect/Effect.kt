package cl.uchile.dcc.finalreality.model.effect

/**
 * Effects are designed with composite pattern, this is the "component"
 *
 */
interface Effect {
    /**
     * Apply the effect to the affected character with the respective power
     */
    fun applyEffect()
}
