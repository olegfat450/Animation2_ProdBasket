package com.example.animation2_prodbasket

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class ItemAdapter (private val list: List<Base>): RecyclerView.Adapter<ItemAdapter.UserViewHolder>() {

    private var onItemClick: OnItemClick? = null

    interface OnItemClick { fun onItemClick ( position: Int )}


    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val image = view.findViewById<ImageView>(R.id.imageTv)
        val title = view.findViewById<TextView>(R.id.titleText)
        val price = view.findViewById<TextView>(R.id.priceText)
        val basket = view.findViewById<ImageView>(R.id.imageBasket)
        val amount = view.findViewById<TextView>(R.id.amountText)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return UserViewHolder(view)
    }

    override fun getItemCount() = list.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        holder.image.setImageResource(list[position].image)


        holder.title.setText("Продукт: ${list[position].title}")
        holder.price.setText("Цена: ${list[position].price}")

        if ( list[position].amount > 0 ) { holder.basket.setAlpha(1f); holder.amount.setText("${list[position].amount} шт")} else {
                                            holder.basket.setAlpha(0.1f); holder.amount.setText("") }

         holder.itemView.setOnClickListener { if ( onItemClick != null ) onItemClick!!.onItemClick(position) }


    }
    fun setOnItemClick ( onItemClick: OnItemClick ) { this.onItemClick = onItemClick }
}