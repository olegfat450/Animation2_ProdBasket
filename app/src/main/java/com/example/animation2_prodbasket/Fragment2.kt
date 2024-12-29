package com.example.animation2_prodbasket

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.SurfaceControl.Transaction
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Fragment2 : Fragment(),OnFragment {

   var basket: MutableList<Base> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button = view.findViewById<FloatingActionButton>(R.id.floatButton)

                button.setOnClickListener {

                    if (basket.isEmpty()) return@setOnClickListener
                    button.animate().apply {  rotationBy(360f); duration = 1000 }.start(); onFragment() }


              basket = Base.list.filter { it.amount != 0 }.toMutableList()




        val adapter = ItemAdapter(basket)
        val listTv = view.findViewById<RecyclerView>(R.id.listTv)
            listTv.layoutManager = LinearLayoutManager(this.context)

        listTv.adapter = adapter


        adapter.setOnItemClick(object: ItemAdapter.OnItemClick {

            @SuppressLint("NotifyDataSetChanged")
            override fun onItemClick(position: Int) {

                val builder = this@Fragment2.context?.let { AlertDialog.Builder(it) }

                builder?.setTitle("Удалить из корзины?")
                    ?.setNegativeButton("Нет") { _, _ -> }
                    ?.setPositiveButton("Да") { _,_ ->  basket.removeAt(position); adapter.notifyDataSetChanged() }

                builder?.create()?.show()


            }
        } )


    }


    override fun onFragment(){

        var check: String = ""; var sum: Double = 0.0
         basket.forEach { val s = it.price * it.amount; check += "${it.title}:  ${it.price} x ${it.amount} = $s\n" ; sum += s }

            check += "\nИТОГО: ${sum}"

        val bundle = Bundle()
        bundle.putString("check",check)


        val transaction = this.fragmentManager?.beginTransaction()
            val fragment = Fragment3()
        fragment.arguments = bundle
        transaction?.replace(R.id.fragment_container,fragment)
       transaction?.addToBackStack(null)
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction?.commit()

    }


}











