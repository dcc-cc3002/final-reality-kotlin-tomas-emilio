package cl.uchile.dcc.finalreality.model.weapons

import java.util.Objects

abstract class AbstractWeapon(
    private val name: String,
    private val damage: Int,
    private val weight: Int
) : WeaponInterface {

    override fun getName(): String {
        return name
    }

    override fun getDamage(): Int {
        return damage
    }

    override fun getWeight(): Int {
        return weight
    }

    override fun getMagicDamage(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is AbstractWeapon) return false
        if (this::class != other::class) return false
        return name == other.name &&
            damage == other.damage &&
            weight == other.weight
    }

    override fun hashCode() = Objects.hash(this::class, name, damage, weight)

    override fun toString() = this::class.simpleName +
        " { name: $name, damage: $damage, weight: $weight }"

    /**
     * A weapon is magic if have magic damage, this function is useful for spells logic because a mage
     * can´t throw a spell if haven´t a staff (the only magic weapon)
     *
     * @return false for all the weapons, except the staff
     */
    override fun isMagic(): Boolean {
        return false
    }
}
