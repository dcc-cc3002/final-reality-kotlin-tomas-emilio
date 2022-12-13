package cl.uchile.dcc.finalreality.controller

import cl.uchile.dcc.finalreality.model.character.Enemy
import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.PlayerCharacter
import java.util.concurrent.LinkedBlockingQueue

class GameController {
    private val turnsQueue = LinkedBlockingQueue<GameCharacter>()
    private val playerCharacters: MutableList<PlayerCharacter> = mutableListOf<PlayerCharacter>()
    private val enemyCharacters: MutableList<Enemy> = mutableListOf<Enemy>()
}
