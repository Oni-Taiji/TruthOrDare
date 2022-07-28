package android.example.truthordare.fragments

import android.content.Context
import android.example.truthordare.R
import android.example.truthordare.databinding.FragmentPlayersBinding
import android.example.truthordare.models.Player
import android.example.truthordare.repository.Repository
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import android.example.truthordare.playerslisttod.PlayerAdapter
import android.example.truthordare.playerslisttod.PlayersRepository
import android.example.truthordare.playerslisttod.QueuePlayers

class PlayersFragment : Fragment(R.layout.fragment_players) {
    private var _binding: FragmentPlayersBinding? = null
    private val binding get() = _binding!!
    private var data: ArrayList<Player> = PlayersRepository.players
    private val adapter = PlayerAdapter(data) {
        index -> onDeletePlayer(index)
    }

    fun onDeletePlayer(index: Int) {
        data.removeAt(index)
        adapter.setPlayers(data)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPlayersBinding.bind(view)
        initRcViewPlayers()
    }

    private fun initRcViewPlayers() {
        binding.apply {
            rvTodPlayers.adapter = adapter
            btnAddPlayer.setOnClickListener {
                if (PlayersRepository.players.size < 10) {
                    val player = Player()
                    PlayersRepository.players.add(player)
                    adapter.notifyItemInserted(PlayersRepository.players.size)
                }
            }
            btnPlayTod.setOnClickListener {
                if (adapter.playersToDList.size < 2) {
                    alertDialogLessThanTwoPlayers()
                } else if (checkPlayerName()) {
                    alertDialogNamelessPlayers()
                } else {
                    QueuePlayers.initQueue()
                    findNavController().navigate(
                        R.id.action_playersFragment_to_choiceFragment
                    )
                }
            }
            imGoToMenu.setOnClickListener {
                Repository.endOfPlay()
                QueuePlayers.clearQueue()
                findNavController().navigate(R.id.menuFragment)
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true)
            {
                override fun handleOnBackPressed() {
                    Repository.endOfPlay()
                    QueuePlayers.clearQueue()
                    findNavController().navigate(R.id.menuFragment)

                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            callback
        )
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    private fun alertDialogLessThanTwoPlayers() {
        val builder = this.context?.let { AlertDialog.Builder(it) }
        builder?.setTitle(R.string.alert_dialog_title)
        builder?.setMessage(R.string.alert_dialog_less_than_two_players)
        builder?.setNegativeButton(R.string.alert_dialog_btn) { _, _ -> }
        builder?.show()
    }

    private fun alertDialogNamelessPlayers() {
        val builder = this.context?.let { AlertDialog.Builder(it) }
        builder?.setTitle(R.string.alert_dialog_title)
        builder?.setMessage(R.string.alert_dialog_unnamed_players)
        builder?.setNegativeButton(R.string.alert_dialog_btn) { _, _ -> }
        builder?.show()
    }

    private fun checkPlayerName(): Boolean {
        for (i in 0 until adapter.playersToDList.size) {
            if (adapter.playersToDList[i].name == "") {
                return true
            }
        }
        return false
    }

}