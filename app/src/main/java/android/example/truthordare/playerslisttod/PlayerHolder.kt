package android.example.truthordare.playerslisttod

import android.example.truthordare.databinding.ItemPlayerBinding
import android.example.truthordare.models.Player
import android.text.Editable
import android.text.TextWatcher
import androidx.recyclerview.widget.RecyclerView

class PlayerHolder(
    private val binding: ItemPlayerBinding,
    private val onPlayerDelete: (Int) -> Unit
): RecyclerView.ViewHolder(binding.root) {

    fun onBind(playerToD: Player, index: Int) {
        with(binding) {
            etPlayerName.setText(playerToD.name)
            etPlayerName.addTextChangedListener(object : TextWatcher {

                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                }

                override fun afterTextChanged(p0: Editable?) {
                    playerToD.name = etPlayerName.text.toString()
                }
            })

            imDeletePlayer.setOnClickListener {
                onPlayerDelete(index)
            }
        }
    }

}