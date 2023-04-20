package com.example.starpremier

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starpremier.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityNewsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_news)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bottomNavigation.setOnNavigationItemSelectedListener {item ->
            when(item.itemId)
            {
                R.id.home -> {val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true}
                R.id.news -> {
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
        binding.bottomNavigation.selectedItemId = R.id.news
    }
    override fun onBackPressed() {
        var bottomNav = binding.bottomNavigation
        val currentItemId : Int = bottomNav.selectedItemId
        if (currentItemId == R.id.news) {
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
            bottomNav.selectedItemId = R.id.news
        }
    }

}