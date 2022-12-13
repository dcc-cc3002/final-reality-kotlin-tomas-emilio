package cl.uchile.dcc.finalreality.model.character.player.mage

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.effect.Effect
import cl.uchile.dcc.finalreality.model.spell.Spell

interface MageInterface {
    fun getMaxMp(): Int
    fun getCurrentMp(): Int
    fun getMagicDamage(): Int
    fun castFire(spell: Spell, receiver: GameCharacter): Effect?
    fun castHeal(spell: Spell, receiver: GameCharacter): Effect?
    fun castParalysis(spell: Spell, receiver: GameCharacter): Effect?
    fun castPoison(spell: Spell, receiver: GameCharacter): Effect?
    fun castThunder(spell: Spell, receiver: GameCharacter): Effect?
}
