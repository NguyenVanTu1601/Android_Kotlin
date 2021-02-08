package com.example.protodatastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
// Là một loại mở rộng của SharedPreference , là  1 dạng tương tự nhưng ổn định hơn PreferenceDataStore
// https://www.youtube.com/watch?v=5_Jy8Alcp14
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}