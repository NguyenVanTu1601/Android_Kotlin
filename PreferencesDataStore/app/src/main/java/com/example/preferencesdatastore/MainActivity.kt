package com.example.preferencesdatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.preferencesdatastore.ViewModel.MainViewModel
import com.example.preferencesdatastore.databinding.ActivityMainBinding

// là dạng cải tiến của sharedPreference , nhưng có vẻ khá phức tạp, nếu ko thực sự cần thì chắc chưa cần sử dụng đâu :))
class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel : MainViewModel
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.readData.observe(
            this, {
                    myName->
                binding.txtName.text = myName
            }

        )

        binding.btnSave.setOnClickListener {
            val myName = binding.edtName.text.toString()
            mainViewModel.saveData(myName)
        }
    }
}