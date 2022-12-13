package cl.uchile.dcc.finalreality.model.states

import cl.uchile.dcc.finalreality.model.character.GameCharacter

object BeginTurn : TurnState {

    private lateinit var character: GameCharacter

    override fun stateAction() {
        character.applyEffect()
        if (character.isDied()) {
            character.removeFromQueue()
            character.setState(CharacterDied)
            EndTurn.makeReady()
        } else if (character.isParalyzed) {
            character.setState(EndTurn)
            character.isParalyzed = false
        } else {
            if (character.isPlayable()) {
                character.setState(PlayerDecision)
            } else {
                character.setState(RandomAttack)
            }
        }
    }

    override fun setCharacter(newCharacter: GameCharacter) {
        character = newCharacter
    }
    fun acceptOther(): Boolean {
        return EndTurn.isReady()
    }
}
