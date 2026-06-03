package com.example.donapps.message.tutorial

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.donapps.databinding.ActivityTutorialMessageBinding

class TutorialMessageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialMessageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTutorialMessageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup ViewPager dengan adapter
        val fragmentsList: List<Fragment> = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )
        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        binding.tutorialMessageViewPager.adapter = adapter

        // Hubungkan DotsIndicator
        binding.dotIndicator.attachTo(binding.tutorialMessageViewPager)
    }
}
