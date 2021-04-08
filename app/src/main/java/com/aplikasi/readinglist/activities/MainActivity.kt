package com.aplikasi.readinglist.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import com.aplikasi.readinglist.R
import com.aplikasi.readinglist.data.Account
import com.aplikasi.readinglist.data.EXTRA_ACCOUNT_REGISTER
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header.*

class MainActivity : BaseActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.Item1 -> Toast.makeText(applicationContext,
                        "Clicked Item 1", Toast.LENGTH_SHORT).show()
                R.id.Item2 -> Toast.makeText(applicationContext,
                        "Clicked Item 2", Toast.LENGTH_SHORT).show()
                R.id.Item3 -> Toast.makeText(applicationContext,
                        "Clicked Item 3", Toast.LENGTH_SHORT).show()
            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            val akun = intent.getParcelableExtra<Account>(EXTRA_ACCOUNT_REGISTER)
            accountPengguna.text = "${akun?.Email}"
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}
