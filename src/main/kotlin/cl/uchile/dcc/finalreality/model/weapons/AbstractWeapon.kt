package cl.uchile.dcc.finalreality.model.weapons

import java.util.Objects

abstract class AbstractWeapon(
    private val name: String,
    private val damage: Int,
    private val weight: Int
): WeaponInterface {

    override fun getName(): String {
        return name
    }

    override fun getDamage(): Int {
        return damage
    }

    override fun getWeight(): Int {
        return weight
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
}