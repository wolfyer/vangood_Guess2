package com.vangood.test0304

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.vangood.test0304.databinding.ActivityMaterialBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.ed_num
import kotlinx.android.synthetic.main.activity_material.*
import kotlinx.android.synthetic.main.content_material.*

class MaterialActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMaterialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMaterialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_material)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            AlertDialog.Builder(this)
                .setTitle("Replay Game")
                .setMessage("Are you sure?")
                .setPositiveButton(getString(R.string.ok), { dialog, which ->
                    secretNumber.reset()
                    counter.setText(secretNumber.count.toString())
                })
                .setNegativeButton("Cancel",null)
                .show()
        }
        counter.setText(secretNumber.count.toString())
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_material)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
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