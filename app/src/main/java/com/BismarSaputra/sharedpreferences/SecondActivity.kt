package com.BismarSaputra.sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.BismarSaputra.sharedpreferences.helper.Constant
import com.BismarSaputra.sharedpreferences.helper.PrefHelper
import kotlinx.android.synthetic.main.activity_dashboard.*

class SecondActivity : AppCompatActivity() {

    lateinit var prefHelper: PrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        prefHelper = PrefHelper(this)

        textUsername.text = prefHelper.getString( Constant.PREF_USERNAME )

        buttonLogout.setOnClickListener {
            prefHelper.clear()
            showMessage( "Keluar" )
            moveIntent()
        }
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}