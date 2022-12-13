package cl.uchile.dcc.finalreality.model.spell

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.mage.MageInterface
import cl.uchile.dcc.finalreality.model.effect.Effect
import cl.uchile.dcc.finalreality.model.effect.Paralyzed
import kotlin.random.Random

object Thunder : Spell {
    override val cost: Int = 15

    override fun castFromTo(mage: MageInterface, receiver: GameCharacter): Effect? {
        return mage.castThunder(this, receiver)
    }
    override fun applySpell(receiver: GameCharacter, magicDamage: Int): Paralyzed? {
        val damage: Int = magicDamage - receiver.getDefense()
        if (damage > 0) {
            receiver.alterHp(-magicDamage)
        }
        return if (Random.nextDouble() < 0.3) {
            Paralyzed(receiver)
        } else {
            null
        }
    }
}
