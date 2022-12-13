package cl.uchile.dcc.finalreality.model.spell

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.mage.MageInterface
import cl.uchile.dcc.finalreality.model.effect.Effect

interface Spell {
    val cost: Int
    fun castFromTo(mage: MageInterface, receiver: GameCharacter): Effect?
    fun applySpell(receiver: GameCharacter, magicDamage: Int): Effect?
}
