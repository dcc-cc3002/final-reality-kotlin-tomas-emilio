package cl.uchile.dcc.finalreality.model.spell

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.mage.MageInterface
import cl.uchile.dcc.finalreality.model.effect.Effect
import cl.uchile.dcc.finalreality.model.effect.Paralyzed

object Paralysis : Spell {
    override val cost: Int = 25
    override fun castFromTo(mage: MageInterface, receiver: GameCharacter): Effect? {
        return mage.castParalysis(this, receiver)
    }
    override fun applySpell(receiver: GameCharacter, magicDamage: Int): Paralyzed? {
        return Paralyzed(receiver)
    }
}
