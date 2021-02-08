package com.example.sharedpreferences


import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.sharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var PREF_NAME = "login"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)

        if (checkLoginPref()){
            Log.d("login","get infor from share preference!")
            var intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLogin.setOnClickListener {

            var username : String = binding.edtUserName.text.toString()
            var password : String = binding.edtPassword.text.toString()

            if (username.equals("banggia1601") && password.equals("160199")){
                saveInfo()
                var intent : Intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
                Log.d("login","success")
                finish()
            }
        }



    }
    private fun saveInfo(){
        var sharePref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        var editor = sharePref.edit()
        editor.putBoolean("login_success",true)
        editor.apply()

    }

    private fun checkLoginPref() : Boolean{
        var sharePref = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        return sharePref.getBoolean("login_success", false)
    }
}