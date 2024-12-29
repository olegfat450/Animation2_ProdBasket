package com.example.animation2_prodbasket

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity(){

                   private lateinit var  main: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        main = findViewById(R.id.main)
       val button = findViewById<Button>(R.id.button)

        button.setOnClickListener { startActivity(Intent(this,WorkActivity::class.java)) }

         val animation: AnimationDrawable = main.background as AnimationDrawable

            animation.setEnterFadeDuration(2000)
            animation.setExitFadeDuration(2000)

        animation.start() }





}