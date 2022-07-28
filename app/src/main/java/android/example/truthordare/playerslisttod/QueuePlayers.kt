package android.example.truthordare.playerslisttod

import android.example.truthordare.models.Player
import java.util.*

object QueuePlayers {
    var queue: Queue<Player> = LinkedList()

    fun initQueue() {
        clearQueue()
        for (i in 0 until PlayersRepository.players.size) {
            queue.add(PlayersRepository.players[i])
        }
    }
    fun clearQueue() {
        queue.clear()
    }
}