package com.vangood.test0304

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.vangood.test0304.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    val secretNumber = SecretNumber()
    fun go(view: View){
        val n = ed_num.text.toString().toInt()
        println("number: $n")
        Log.d("MainActivity","number:" + n)
        val diff = secretNumber.validate(n)
        var message = getString(R.string.win)+n
        if (diff < 0){
            message = getString(R.string.big)
        } else if (diff > 0){
            message = getString(R.string.small)
        }
        //Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.mess))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok),null)
            .show()

    }
}