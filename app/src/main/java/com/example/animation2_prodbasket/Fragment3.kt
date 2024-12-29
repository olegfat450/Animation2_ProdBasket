package com.example.animation2_prodbasket

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


class Fragment3 : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_3, container, false)

         val checkTv = view.findViewById<TextView>(R.id.checkTv)


        val check = arguments?.getString("check")
         val formatDate = SimpleDateFormat("dd MMMM yyyy     HH : mm", Locale.getDefault())

          checkTv.setText("Чек от ${formatDate.format(Date())}\n\n")

        checkTv.append(check)




        return view
    }



}