package cl.uchile.dcc.finalreality.model.states

import cl.uchile.dcc.finalreality.model.character.GameCharacter
import java.util.concurrent.BlockingQueue

class WaitTurn(
    val character: GameCharacter,
    private var turnsQueue: BlockingQueue<GameCharacter>
) : TurnState {

    override fun stateAction() {
        if (character.isDied()) {
            character.removeFromQueue()
            character.setState(CharacterDied)
        } else if (character === turnsQueue.peek()) {
            if (BeginTurn.acceptOther()) {
                getFirstOfQueue()
                character.setState(BeginTurn)
                EndTurn.makeNotReady()
            }
        }
    }

    private fun getFirstOfQueue(): GameCharacter {
        return turnsQueue.take()
    }

    override fun setCharacter(newCharacter: GameCharacter) {
        // do nothing
    }
}
