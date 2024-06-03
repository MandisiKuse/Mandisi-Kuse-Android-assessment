package com.glucode.about_you

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.glucode.about_you.viewmodels.AboutYouViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: AboutYouViewModel by viewModels()
    companion object {
        val IMAGE_REQUESTED_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpObservers()

        val navController = findNavController(R.id.fragment_host)
        setupActionBarWithNavController(navController)
    }

    private fun setUpObservers() {
        with(viewModel) {

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragment_host).navigateUp() || super.onSupportNavigateUp()
    }

    private fun onImageClick() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, IMAGE_REQUESTED_CODE)
    }
}