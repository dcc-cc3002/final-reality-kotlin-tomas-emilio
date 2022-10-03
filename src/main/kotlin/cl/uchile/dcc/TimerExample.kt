package cl.uchile.dcc


import cl.uchile.dcc.finalreality.model.character.GameCharacter
import cl.uchile.dcc.finalreality.model.character.player.BlackMage
import cl.uchile.dcc.finalreality.model.character.player.Engineer
import cl.uchile.dcc.finalreality.model.character.player.Knight
import cl.uchile.dcc.finalreality.model.character.player.Thief
import cl.uchile.dcc.finalreality.model.character.player.WhiteMage
import cl.uchile.dcc.finalreality.model.weapons.Axe
import cl.uchile.dcc.finalreality.model.weapons.Bow
import cl.uchile.dcc.finalreality.model.weapons.Knife
import cl.uchile.dcc.finalreality.model.weapons.Staff
import cl.uchile.dcc.finalreality.model.weapons.Sword
import java.util.concurrent.LinkedBlockingQueue
import kotlin.random.Random

fun main() {
    val queue = LinkedBlockingQueue<GameCharacter>()
    for (i in 0 until 10) {
        // Gives a random speed to each character to generate different waiting times
        val weapon = Knife("", 0, Random.nextInt(1, 50))
        val character = Thief("$i", 10, 10, queue)
        character.equip(weapon)
        character.waitTurn()
    }
    // Waits for 6 seconds to ensure that all characters have finished waiting
    Thread.sleep(6000)
    while (!queue.isEmpty()) {
        // Pops and prints the names of the characters of the queue to illustrate the turns
        // order
        println(queue.poll())
    }

    val wm0 = WhiteMage("Gandalf", 10, 20, 30, queue)
    val wm1 = WhiteMage("Gandalf", 10, 20, 30, queue)
    val wm2 = WhiteMage("Saruman", 20, 200, 5, queue)
    println(wm0.equals(wm1))
    println(wm0.equals(wm2))
    println(wm0.hashCode())
    println(wm0.toString())
    println(wm0.getName())
    println(wm0.getDefense())
    println(wm0.getMaxHp())
    println(wm0.getCurrentHp())
    println(wm0.getMaxMp())
    println(wm0.getCurrentMp())

    val bm0 = BlackMage("bm0", 24, 41, 5, queue)
    val bm1 = BlackMage("bm0", 24, 41, 5, queue)
    val bm2 = BlackMage("Gandalf", 10, 10, 10, queue)
    println(bm0.equals(bm1))
    println(bm0.equals(bm2))
    println(bm0.hashCode())
    println(bm0.toString())
    println(bm0.getName())
    println(bm0.getDefense())
    println(bm0.getMaxHp())
    println(bm0.getCurrentHp())
    println(bm0.getMaxMp())
    println(bm0.getCurrentMp())

    val eng0 = Engineer("0",10,20,queue)
    val eng1 = Engineer("0",10,20,queue)
    val eng2 = Engineer("2",20,10,queue)
    println(eng0.equals(eng1))
    println(eng0.equals(eng2))
    println(eng0.hashCode())
    println(eng0.toString())
    println(eng0.getName())
    println(eng0.getDefense())
    println(eng0.getMaxHp())
    println(eng0.getCurrentHp())

    val knight0 = Knight("0",10,20,queue)
    val knight1 = Knight("0",10,20,queue)
    val knight2 = Knight("2",20,10,queue)
    println(knight0.equals(knight1))
    println(knight0.equals(knight2))
    println(knight0.hashCode())
    println(knight0.toString())
    println(knight0.getName())
    println(knight0.getDefense())
    println(knight0.getMaxHp())
    println(knight0.getCurrentHp())

    val thief0 = Thief("0",10,20,queue)
    val thief1 = Thief("0",10,20,queue)
    val thief2 = Thief("2",20,10,queue)
    println(thief0.equals(thief1))
    println(thief0.equals(thief2))
    println(thief0.hashCode())
    println(thief0.toString())
    println(thief0.getName())
    println(thief0.getDefense())
    println(thief0.getMaxHp())
    println(thief0.getCurrentHp())

    val axe0 = Axe("0",3,3)
    val axe1 = Axe("0",3,3)
    val axe2 = Axe("2",8,4)
    println(axe0.equals(axe1))
    println(axe0.equals(axe2))
    println(axe0.hashCode())
    println(axe0.toString())
    println(axe0.getName())
    println(axe0.getWeight())
    println(axe0.getDamage())

    val bow0 = Bow("0",3,3)
    val bow1 = Bow("0",3,3)
    val bow2 = Bow("2",8,4)
    println(bow0.equals(bow1))
    println(bow0.equals(bow2))
    println(bow0.hashCode())
    println(bow0.toString())
    println(bow0.getName())
    println(bow0.getWeight())
    println(bow0.getDamage())

    val knife0 = Knife("0",3,3)
    val knife1 = Knife("0",3,3)
    val knife2 = Knife("2",8,4)
    println(knife0.equals(knife1))
    println(knife0.equals(knife2))
    println(knife0.hashCode())
    println(knife0.toString())
    println(knife0.getName())
    println(knife0.getWeight())
    println(knife0.getDamage())

    val staff0 = Staff("0",3,3,2)
    val staff1 = Staff("0",3,3,2)
    val staff2 = Staff("2",8,4, 5)
    println(staff0.equals(staff1))
    println(staff0.equals(staff2))
    println(staff0.hashCode())
    println(staff0.toString())
    println(staff0.getName())
    println(staff0.getWeight())
    println(staff0.getDamage())
    println(staff0.getMagicDamage())

    val sword0 = Sword("0",3,3)
    val sword1 = Sword("0",3,3)
    val sword2 = Sword("2",8,4)
    println(sword0.equals(sword1))
    println(sword0.equals(sword2))
    println(sword0.hashCode())
    println(sword0.toString())
    println(sword0.getName())
    println(sword0.getWeight())
    println(staff0.getDamage())
}