package com.example.jolboldu_hw_diroom.ui.fragment.onBoard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.jolboldu_hw_diroom.R
import com.example.jolboldu_hw_diroom.databinding.FragmentOnBoardBinding


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
        setupListener()
        btnGetStarted()

    }

    private fun initialize() {
        binding.viewPager2.adapter = OnBoardViewPagerAdapter(this)
    }

    private fun setupListener() = with(binding.viewPager2) {
        binding.btnViewPagerStart.setOnClickListener {
            findNavController().navigate(R.id.noteFragment)
        }
    }

    private fun btnGetStarted() = with(binding) {
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> btnViewPagerStart.visibility = View.GONE
                    1 -> btnViewPagerStart.visibility = View.GONE
                    2 -> btnViewPagerStart.visibility = View.VISIBLE
                }
                super.onPageSelected(position)
            }
        })
    }

}