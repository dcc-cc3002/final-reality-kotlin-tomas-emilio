package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter

class Staff(
    name: String,
    damage: Int,
    weight: Int,
    val magicDamage: Int
) : AbstractWeapon(name, damage, weight) {

    override fun canEquip(playerCharacter: PlayerCharacter) {
        playerCharacter.equipStaff(this)
    }
}
