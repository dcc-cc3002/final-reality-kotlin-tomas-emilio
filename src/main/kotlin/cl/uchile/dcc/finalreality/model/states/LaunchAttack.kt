package cl.uchile.dcc.finalreality.model.states

import cl.uchile.dcc.finalreality.model.character.GameCharacter

object LaunchAttack : TurnState {

    var answer: Boolean = false

    private lateinit var character: GameCharacter
    private lateinit var rival: GameCharacter

    override fun stateAction() {
        if (answer) {
            character.attack(rival)
            character.setState(EndTurn)
        } else {
            character.setState(PlayerDecision)
        }
    }

    override fun setCharacter(newCharacter: GameCharacter) {
        character = newCharacter
    }
    fun playerConfirm() {
        answer = true
    }

    private fun chooseRival(newRival: GameCharacter) {
        rival = newRival
    }
}
