package android.example.truthordare.fragments

import android.content.Context
import android.example.truthordare.R
import android.example.truthordare.databinding.FragmentChoiceBinding
import android.example.truthordare.models.Player
import android.example.truthordare.repository.Repository
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import android.example.truthordare.playerslisttod.QueuePlayers


class ChoiceFragment : Fragment(R.layout.fragment_choice) {
    private var _binding: FragmentChoiceBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentChoiceBinding.bind(view)

        with(binding) {

            val playerToD: Player = QueuePlayers.queue.poll()
            tvTitlePlayerName.text = playerToD.name
            QueuePlayers.queue.add(playerToD)

            btnTruth.setOnClickListener {
                val playerName = playerToD.name
                val questionTOD = Repository.getQuestion()
                val action = ChoiceFragmentDirections.actionChoiceFragmentToGameFragment(
                    btnTruth.text.toString(),
                    questionTOD,
                    playerName
                )
                findNavController().navigate(action)
            }
            btnDare.setOnClickListener {
                val playerName = playerToD.name
                val actionTOD = Repository.getAction()
                val action = ChoiceFragmentDirections.actionChoiceFragmentToGameFragment(
                    btnDare.text.toString(),
                    actionTOD,
                    playerName
                )
                findNavController().navigate(action)
            }
            imPlayers.setOnClickListener {
                findNavController().navigate(R.id.playersFragment)
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
                    findNavController().navigate(R.id.playersFragment)
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

}