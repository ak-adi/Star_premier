package com.example.starpremier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starpremier.databinding.ActivityCastingBinding

class CastingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCastingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_casting)
        binding = ActivityCastingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId)
            {
                R.id.home -> {val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true}
                R.id.news -> {val intent = Intent(this, NewsActivity::class.java)
                    startActivity(intent)
                    true}
                R.id.account -> {val intent = Intent(this, AccountActivity::class.java)
                    startActivity(intent)
                    true}
                R.id.casting -> {
                    true}
                R.id.setting -> {val intent = Intent(this, SettingActivity::class.java)
                    startActivity(intent)
                    true}

                else -> false

            }
        }
        binding.bottomNavigation.selectedItemId = R.id.casting
    }
    override fun onBackPressed() {
        var bottomNav = binding.bottomNavigation
        val currentItemId : Int = bottomNav.selectedItemId
        if (currentItemId == R.id.casting) {
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
            bottomNav.selectedItemId = R.id.casting
        }
    }
}