package cl.uchile.dcc.finalreality.model.spell

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.mage.MageInterface
import cl.uchile.dcc.finalreality.model.effect.Effect
import cl.uchile.dcc.finalreality.model.effect.Poisoned

object Poison : Spell {
    override val cost: Int = 40
    override fun castFromTo(mage: MageInterface, receiver: GameCharacter): Effect? {
        return mage.castPoison(this, receiver)
    }
    override fun applySpell(receiver: GameCharacter, magicDamage: Int): Poisoned? {
        return Poisoned(receiver, magicDamage)
    }
}
