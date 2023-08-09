package com.angelika.appnoteandroid14.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.angelika.appnoteandroid14.R
import com.angelika.appnoteandroid14.databinding.ActivityMainBinding
import com.angelika.appnoteandroid14.utils.PreferenceHelper

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initialize()
    }

    private fun initialize() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController =
            navHostFragment.navController

        val preferenceHelper = PreferenceHelper()
        preferenceHelper.prefUnit(this)
        val check = preferenceHelper.saveBoolean
        val navGraph =
            navController.navInflater.inflate(R.navigation.nav_graph)

        if (check == true) {
            navGraph.setStartDestination(R.id.noteAppFragment)
        } else {
            navGraph.setStartDestination(R.id.onBoardFragment)
        }
        navController.graph = navGraph
    }
}