package cl.uchile.dcc.finalreality.model.weapons

class Staff(
    name: String,
    damage: Int,
    weight: Int,
    private val magicDamage: Int,
) : AbstractWeapon(name, damage, weight){
    fun getMagicDamage(): Int {
        return magicDamage
    }


}