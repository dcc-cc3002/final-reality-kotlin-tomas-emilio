package cl.uchile.dcc.finalreality.model.states

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import java.util.concurrent.BlockingQueue

class CharacterCreation(
    val character: GameCharacter,
    private var turnsQueue: BlockingQueue<GameCharacter>
) :
    TurnState {
    override fun stateAction() {
        character.waitTurn()
        character.setState(WaitTurn(character, turnsQueue))
    }

    override fun setCharacter(newCharacter: GameCharacter) {
        // do nothing
    }
}
