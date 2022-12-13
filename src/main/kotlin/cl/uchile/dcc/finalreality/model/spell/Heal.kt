package cl.uchile.dcc.finalreality.model.spell

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.mage.MageInterface
import cl.uchile.dcc.finalreality.model.effect.Effect

object Heal : Spell {
    override val cost: Int = 15
    override fun castFromTo(mage: MageInterface, receiver: GameCharacter): Effect? {
        return mage.castHeal(this, receiver)
    }

    override fun applySpell(receiver: GameCharacter, magicDamage: Int): Effect? {
        val bonus: Int = receiver.getMaxHp() * 3 / 10
        receiver.alterHp(bonus)
        return null
    }
}
