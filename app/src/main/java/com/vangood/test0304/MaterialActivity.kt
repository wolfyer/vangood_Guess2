package com.vangood.test0304

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.vangood.test0304.databinding.ActivityMaterialBinding
import kotlinx.android.synthetic.main.activity_main.ed_num
import kotlinx.android.synthetic.main.activity_material.*


class MaterialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMaterialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)



        binding.fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("Replay Game")
                .setMessage("Are you sure?")
                .setPositiveButton(getString(R.string.ok)){ dialog, which ->
                    secretNumber.reset()
                    counter.setText(secretNumber.count.toString())
                }
                .setNegativeButton("Cancel",null)
                .show()
        }
        counter.setText(secretNumber.count.toString())
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
        counter.setText(secretNumber.count.toString())
        //Toast.makeText(this,message,Toast.LENGTH_LONG).show()
        AlertDialog.Builder(this)
            .setTitle(getString(R.string.mess))
            .setMessage(message)
            .setPositiveButton(getString(R.string.ok),null)
            .show()

    }

}