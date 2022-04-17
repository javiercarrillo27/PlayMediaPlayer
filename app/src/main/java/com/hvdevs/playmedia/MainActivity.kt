package com.hvdevs.playmedia

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputEditText
import com.hvdevs.playmedia.databinding.ActivityMainBinding
import com.hvdevs.playmedia.databinding.FragmentLoginBinding
import com.hvdevs.playmedia.utilities.IOnBackPressed



class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragment_container)
        navHost?.let { navFragment ->
            navFragment.childFragmentManager.primaryNavigationFragment?.let { fragment ->
                (fragment as? IOnBackPressed)?.onBackPressed()?.not()?.let { isCanceled: Boolean ->
                    Toast.makeText(this, "onBackPressed $isCanceled", Toast.LENGTH_SHORT).show()
                    if (!isCanceled) {
                        super.onBackPressed()
                    }
                }
            }
        }
    }
}