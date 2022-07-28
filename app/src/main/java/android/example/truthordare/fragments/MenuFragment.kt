package android.example.truthordare.fragments

import android.content.Context
import android.example.truthordare.R
import android.example.truthordare.databinding.FragmentMenuBinding
import android.example.truthordare.repository.Repository
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class MenuFragment : Fragment(R.layout.fragment_menu) {
    private var _binding : FragmentMenuBinding ?= null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Repository.endOfPlay()
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMenuBinding.bind(view)

        binding.btnStartGame.setOnClickListener {
            findNavController().navigate(R.id.playersFragment)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    activity?.finish()
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