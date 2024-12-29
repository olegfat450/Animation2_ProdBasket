package com.example.animation2_prodbasket

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.RawContacts.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.io.Serializable


class Fragment1 : Fragment(),OnFragment {

   // private lateinit var onFragment: OnFragment

    var list: List<Base> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_1, container, false)



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         list = Base.list
        val adapter = ItemAdapter(list)
        val floatButton = view.findViewById<FloatingActionButton>(R.id.floatButton)
        val listTv = view.findViewById<RecyclerView>(R.id.listTv)
            listTv.layoutManager = LinearLayoutManager(this@Fragment1.context)

            //  onFragment = requireActivity() as OnFragment



                    listTv.adapter = adapter

                floatButton.setOnClickListener {

                    floatButton.animate().apply {  rotationBy(360f); duration = 1000 }.start()
                onFragment() }


         adapter.setOnItemClick(object : ItemAdapter.OnItemClick {

             @SuppressLint("NotifyDataSetChanged", "InflateParams")
             override fun onItemClick(position: Int) {

                 val builder = this@Fragment1.context?.let { AlertDialog.Builder(it) }
                 val inflater = this@Fragment1.layoutInflater
                 val dialogView = inflater.inflate(R.layout.edit_item,null)
                 val amount_item = dialogView.findViewById<EditText>(R.id.amount_item)
                 val add = dialogView.findViewById<TextView>(R.id.buttonAdd)
                 val div = dialogView.findViewById<TextView>(R.id.buttonDiv)


                 var amount = list[position].amount

                 amount_item.setText(amount.toString())

                 builder?.setView(dialogView)
                 builder?.setTitle("В корзину ")
                     ?.setPositiveButton("Добавить в корзину") { _,_ ->

                         try {list[position].amount = amount_item.text.toString().toInt()} catch (_:Exception) {return@setPositiveButton};adapter.notifyDataSetChanged()  }
                     ?.setNegativeButton("Удалить из корзины") {_,_ -> list[position].amount = 0;adapter.notifyDataSetChanged() }
                     ?.setNeutralButton("Отмена") { _,_ -> }
                 builder?.create()?.show()



                 add.setOnClickListener {  amount_item.setText((++amount).toString()) }
                 div.setOnClickListener { if (amount == 0) return@setOnClickListener else amount_item.setText((--amount).toString()) }


             }

         })



    }

    override fun onFragment() {




        val transaction = this.fragmentManager?.beginTransaction()
        val fragment = Fragment2()


        transaction?.replace(R.id.fragment_container,fragment)
        transaction?.addToBackStack(null)
        transaction?.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        transaction?.commit()
    }

}