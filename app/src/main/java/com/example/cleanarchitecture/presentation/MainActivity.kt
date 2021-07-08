package com.example.cleanarchitecture.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.cleanarchitecture.R
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.pbreakers.mobile.androidtest.udacity.utils.LoadingState

class MainActivity : AppCompatActivity() {
    private val userViewModel by viewModel<UserViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel.data.observe(this, Observer {
            it.forEach { githubUser ->
                Toast.makeText(baseContext, githubUser.login, Toast.LENGTH_SHORT).show()
            }
        })

        userViewModel.loadingState.observe(this, Observer {
            when (it.status) {
                LoadingState.Status.FAILED -> Toast.makeText(this, it.msg, Toast.LENGTH_SHORT).show()
                LoadingState.Status.RUNNING -> Toast.makeText(this, "Loading", Toast.LENGTH_SHORT).show()
                LoadingState.Status.SUCCESS -> Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
            }
        })
    }
}