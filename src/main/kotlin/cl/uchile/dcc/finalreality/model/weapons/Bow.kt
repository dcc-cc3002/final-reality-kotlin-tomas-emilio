package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter

class Bow(
    name: String,
    damage: Int,
    weight: Int
) : AbstractWeapon(name, damage, weight) {
    override fun canEquip(playerCharacter: PlayerCharacter) {
        playerCharacter.equipBow(this)
    }
}
