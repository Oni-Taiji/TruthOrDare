package android.example.truthordare.fragments

import android.content.Context
import android.example.truthordare.R
import android.example.truthordare.databinding.FragmentGameBinding
import android.example.truthordare.repository.Repository
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import android.example.truthordare.playerslisttod.QueuePlayers

class GameFragment : Fragment(R.layout.fragment_game) {
    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val dareString = "Действие"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGameBinding.bind(view)

        with(binding) {
            val args by navArgs<GameFragmentArgs>()
            tvTitleMode.text = args.truthOrDare
            tvTaskOrQuestion.text = args.questionsActions
            tvTitlePlayerName.text = args.playerName

            btnRefresh.setOnClickListener {
                refresh(tvTitleMode.text.toString())
            }
            btnContinue.setOnClickListener {
                findNavController().navigate(R.id.choiceFragment)
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

    override fun onDestroy() {
        _binding= null
        super.onDestroy()
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

    private fun refresh(choice: String) {
        if (choice == dareString) {
            binding.tvTaskOrQuestion.text = Repository.getAction()
        } else {
            binding.tvTaskOrQuestion.text = Repository.getQuestion()
        }
    }

}