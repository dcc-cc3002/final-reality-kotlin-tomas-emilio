package cl.uchile.dcc.finalreality.model.states

import cl.uchile.dcc.finalreality.model.character.GameCharacter

object EndTurn : TurnState {

    private var ready: Boolean = true
    private lateinit var character: GameCharacter

    fun makeNotReady() {
        ready = false
    }
    fun makeReady() {
        ready = true
    }

    fun isReady(): Boolean {
        return ready
    }

    override fun stateAction() {
        character.waitTurn()
        character.setState(character.waitTurn)
    }

    override fun setCharacter(newCharacter: GameCharacter) {
        character = newCharacter
    }
}
