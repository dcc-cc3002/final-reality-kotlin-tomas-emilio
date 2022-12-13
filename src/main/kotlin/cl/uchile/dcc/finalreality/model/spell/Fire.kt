package cl.uchile.dcc.finalreality.model.spell

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.mage.MageInterface
import cl.uchile.dcc.finalreality.model.effect.Burned
import cl.uchile.dcc.finalreality.model.effect.Effect
import kotlin.random.Random

object Fire : Spell {

    override val cost: Int = 15
    override fun castFromTo(mage: MageInterface, receiver: GameCharacter): Effect? {
        return mage.castFire(this, receiver)
    }
    override fun applySpell(receiver: GameCharacter, magicDamage: Int): Burned? {
        val damage: Int = magicDamage - receiver.getDefense()
        if (damage > 0) {
            receiver.alterHp(-magicDamage)
        }
        return if (Random.nextDouble() < 0.2) {
            Burned(receiver, magicDamage)
        } else {
            null
        }
    }
}
