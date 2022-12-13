package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter

interface WeaponInterface {
    fun getName(): String
    fun getDamage(): Int
    fun getWeight(): Int
    fun getMagicDamage(): Int
    fun canEquip(playerCharacter: PlayerCharacter)
    fun isMagic(): Boolean
}
