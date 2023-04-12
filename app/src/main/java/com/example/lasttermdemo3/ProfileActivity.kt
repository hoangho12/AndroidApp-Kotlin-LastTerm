package com.example.lasttermdemo3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_home.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        btnHome.setOnClickListener{
            loadingProgress.visibility = View.GONE
            loadingProgress.animate().setDuration(200).alpha(1f).withEndAction{
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }

        btnCart.setOnClickListener{
            loadingProgress.visibility = View.GONE
            loadingProgress.animate().setDuration(200).alpha(1f).withEndAction{
                val intent = Intent(this, CartActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }

        btnFavor.setOnClickListener{
            loadingProgress.visibility = View.GONE
            loadingProgress.animate().setDuration(200).alpha(1f).withEndAction{
                val intent = Intent(this, FavoriteActivity::class.java)
                startActivity(intent)
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            }
        }
    }
}