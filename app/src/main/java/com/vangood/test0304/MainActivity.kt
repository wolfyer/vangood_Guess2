package com.vangood.test0304

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.vangood.test0304.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    val secretNumber = SecretNumber()
    fun go(view: View){
        val n = binding.edNum.text.toString().toInt()
        println("number: $n")
        Log.d("MainActivity","number:" + n)
        val diff = secretNumber.validate(n)
        var message = "win! the secret number is $n"
        if (diff < 0){
            message = "Bigger"
        } else if (diff > 0){
            message = "Smaller"
        }
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()

    }
}