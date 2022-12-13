package cl.uchile.dcc.finalreality.model.weapons

import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter

class Staff(
    name: String,
    damage: Int,
    weight: Int,
    private val magicDamage: Int
) : AbstractWeapon(name, damage, weight) {

    override fun canEquip(playerCharacter: PlayerCharacter) {
        playerCharacter.equipStaff(this)
    }

    override fun getMagicDamage(): Int {
        return magicDamage
    }

    /**
     * A staff is a magic weapon, this function is useful for spells logic because a mage
     * can´t throw a spell if haven´t a staff (the only magic weapon)
     *
     * @return true for the staff
     */
    override fun isMagic(): Boolean {
        return true
    }
}
