package android.example.truthordare.playerslisttod

import android.example.truthordare.databinding.ItemPlayerBinding
import android.example.truthordare.models.Player
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class PlayerAdapter(
    val playersToDList: ArrayList<Player>,
    private val onPlayerDelete: (Int) -> Unit
) : RecyclerView.Adapter<PlayerHolder>() {

    private var listPlayers = playersToDList

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PlayerHolder = PlayerHolder(
        binding = ItemPlayerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        onPlayerDelete
    )

    override fun onBindViewHolder(holder: PlayerHolder, position: Int) {
        holder.onBind(playersToDList[position], position)
    }

    override fun getItemCount(): Int {
        return listPlayers.size
    }

    fun setPlayers(players: ArrayList<Player>) {
        listPlayers = players
        notifyDataSetChanged()
    }

}