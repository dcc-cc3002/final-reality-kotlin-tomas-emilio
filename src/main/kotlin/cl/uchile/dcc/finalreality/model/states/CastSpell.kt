package cl.uchile.dcc.finalreality.model.states

import cl.uchile.dcc.finalreality.model.character.GameCharacter

object CastSpell : TurnState {
    private lateinit var character: GameCharacter
    private lateinit var rival: GameCharacter
    var answer: Boolean = false

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
    private fun chooseRival(newRival: GameCharacter) {
        rival = newRival
    }
    fun playerConfirm() {
        answer = true
    }
}
