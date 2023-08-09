package com.angelika.appnoteandroid14.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.angelika.appnoteandroid14.R
import com.angelika.appnoteandroid14.databinding.FragmentOnBoardPagingBinding
import com.angelika.appnoteandroid14.utils.PreferenceHelper

class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        getStarted()
    }

    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_PAGE_POSITION)) {
            0 -> {
                tvDescription.text = "Очень удобный функционал"
                animationView.setAnimation(R.raw.animation_first)
            }

            1 -> {
                tvDescription.text = "Быстрый, качественный продукт"
                animationView.setAnimation(R.raw.animation_second)
            }

            2 -> {
                tvDescription.text = "Куча функций и интересных фишек"
                animationView.setAnimation(R.raw.animation_third)
                tvStart.text = "Начать работу"
            }
        }
    }

    private fun getStarted() = with(binding) {
        val preferenceHelper = PreferenceHelper()
        preferenceHelper.prefUnit(requireContext())
        tvStart.setOnClickListener {
            preferenceHelper.saveBoolean = true
            findNavController().navigate(R.id.action_onBoardFragment_to_noteAppFragment)
        }
    }

    companion object {
        const val ARG_ONBOARD_PAGE_POSITION = "onboarding_page_position"
    }
}