package cl.uchile.dcc.finalreality.model.states

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.GameCharacter

object RandomAttack : TurnState {

    private lateinit var character: GameCharacter
    private lateinit var rival: GameCharacter

    override fun stateAction() {
        character.attack(rival)
        character.setState(EndTurn)
    }

    override fun setCharacter(newCharacter: GameCharacter) {
        character = newCharacter as Enemy
    }
    private fun chooseRival(newRival: GameCharacter) {
        rival = newRival
    }
}
