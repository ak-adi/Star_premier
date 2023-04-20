package com.example.starpremier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.starpremier.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupBottomNavigation()

    }

    private fun setupBottomNavigation() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId)
            {
                R.id.home -> {true}
                R.id.news -> {val intent = Intent(this, NewsActivity::class.java)
                    startActivity(intent)
                    true}
                R.id.account -> {val intent = Intent(this, AccountActivity::class.java)
                    startActivity(intent)
                    true}
                R.id.casting -> {val intent = Intent(this, CastingActivity::class.java)
                    startActivity(intent)
                    true}
                R.id.setting -> {val intent = Intent(this, SettingActivity::class.java)
                    startActivity(intent)
                    true}

                else -> false

            }
        }

        binding.bottomNavigation.selectedItemId = R.id.home

    }

    override fun onBackPressed() {
        var bottomNav = binding.bottomNavigation
        val currentItemId : Int = bottomNav.selectedItemId
        if (currentItemId == R.id.home) {
            super.onBackPressed()
        }
        else{
            val newIconList = listOf(
                R.drawable.home, R.drawable.setting, R.drawable.casting,
                R.drawable.investigation, R.drawable.user
            )
            val menu = bottomNav.menu
            for (i in 0 until menu.size()) {
                val item = menu.getItem(i)
                if (item.itemId == currentItemId) {
                    item.setIcon(newIconList[i])
                }
            }
            bottomNav.selectedItemId = R.id.home
        }
    }
}