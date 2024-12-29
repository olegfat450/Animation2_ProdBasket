package com.example.animation2_prodbasket

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentTransaction
import java.io.Serializable
import java.util.ArrayList

class WorkActivity : AppCompatActivity() {

     private lateinit var toolbar: Toolbar

     var list: MutableList<Base> = mutableListOf()


    @SuppressLint("MissingInflatedId", "CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_work)

        toolbar = findViewById(R.id.toolbar)
        toolbar.setTitleTextColor(Color.CYAN)
        toolbar.title = "НАШ Магазин"
        toolbar.setBackgroundColor(Color.BLUE)
        setSupportActionBar(toolbar)

        if ( savedInstanceState == null ) {supportFragmentManager.beginTransaction().add(R.id.fragment_container,Fragment1()).commit()}








    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit,menu)
        return super.onCreateOptionsMenu(menu) }

    @SuppressLint("SuspiciousIndentation")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val builder = AlertDialog.Builder(this)

             builder.setTitle("Выход из программы")
                 .setPositiveButton("Да") { _,_ -> finishAffinity() }
                 .setNegativeButton("Нет") { _,_ -> }
        builder.create().show()

        return super.onOptionsItemSelected(item)
    }


}