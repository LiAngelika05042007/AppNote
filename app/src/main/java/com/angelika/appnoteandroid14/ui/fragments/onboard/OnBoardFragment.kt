package com.angelika.appnoteandroid14.ui.fragments.onboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.angelika.appnoteandroid14.databinding.FragmentOnBoardBinding
import com.angelika.appnoteandroid14.ui.adapters.OnBoardAdapter

class OnBoardFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListeners()
    }

    private fun initialize() {
        binding.noteViewPager.apply {
            adapter = OnBoardAdapter(this@OnBoardFragment)
            binding.wormDotsIndicator.attachTo(binding.noteViewPager)
        }
    }

    private fun setupListeners() = with(binding.noteViewPager) {
        binding.noteViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.tvSkip.isInvisible = currentItem == 2
            }
        })

        binding.tvSkip.setOnClickListener {
            if (currentItem < 2) {
                setCurrentItem(currentItem + 1, true)
            }
        }
    }
}