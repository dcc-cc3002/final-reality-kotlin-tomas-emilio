package cl.uchile.dcc.finalreality.model.states

import cl.uchile.dcc.finalreality.model.character.GameCharacter

object PlayerDecision : TurnState {

    private lateinit var character: GameCharacter
    private lateinit var decision: TurnState

    override fun stateAction() {
        character.setState(decision)
    }

    override fun setCharacter(newCharacter: GameCharacter) {
        character = newCharacter
    }
    fun decision(state: TurnState) {
        decision = state
    }
}
