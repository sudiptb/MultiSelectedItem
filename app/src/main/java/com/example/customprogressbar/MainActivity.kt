package com.example.customprogressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.customprogressbar.databinding.ActivityMainBinding
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.btn.setOnClickListener {
            val checkValue = if (binding.check.isChecked){
                "Y"
            }else{
                "N"
            }
            binding.text.visibility = View.VISIBLE
            binding.text.text = checkValue

        }

    }

    private fun delay(time: Long){
        try {
            Thread.sleep(time)
        }catch (e: Exception){
            Log.d("main", "${e.message}")
        }
    }
}