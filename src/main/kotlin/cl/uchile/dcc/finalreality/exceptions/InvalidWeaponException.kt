package cl.uchile.dcc.finalreality.exceptions
/**
 * This error is used to represent a character who equips a not equippable weapon for their class.
 *
 * @constructor Creates a new `InvalidWeaponException` with a `description` of the
 * error.
 *
 */
class InvalidWeaponException(description: String) :
    Exception(description)
