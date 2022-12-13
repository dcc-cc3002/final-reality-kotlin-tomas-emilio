package cl.uchile.dcc.finalreality.model.states

import cl.uchile.dcc.finalreality.model.character.GameCharacter

interface TurnState {
    fun stateAction()
    fun setCharacter(newCharacter: GameCharacter)
}
