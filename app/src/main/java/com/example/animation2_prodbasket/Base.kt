package com.example.animation2_prodbasket

import android.os.Parcelable
import com.google.android.material.internal.ParcelableSparseIntArray
import java.io.Serializable

class Base(val title: String, val price: Double, val image: Int, var amount: Int) {

    companion object{

        val p1 = Base("Сахар 'Мистраль' 1кг",65.0,R.drawable.p1,0)
        val p2 = Base("Соль 'Экстра' В/С 1кг",32.0,R.drawable.p2,0)
        val p3 = Base("Мука пшеничная 'Макфа' В/С 1кг",55.5,R.drawable.p3,0)
        val p4 = Base("Уксус столовый 70% 250мл",25.5,R.drawable.p4,0)
        val p5 = Base("Масло сливочное 82.5% 200гр",195.0,R.drawable.p5,0)
        val p6 = Base("Масло подсолнечное 'Злато' 1л",155.5,R.drawable.p6,0)
        val p7 = Base("Майонез 'Янта' провансаль 250гр",115.0,R.drawable.p7,0)
        val p8 = Base("Масло подсолнечное 'Слобода' 0.9л",125.5,R.drawable.p8,0)
        val p9 = Base("Майонез 'Кальве' 125гр",85.0,R.drawable.p9,0)
        val p10 = Base("Кетчуп томатный 'HEINZ' 800гр",65.0,R.drawable.p10,0)
        val p11 = Base("Лечо 'Махеев' 50гр",65.0,R.drawable.p11,0)

        val list = listOf(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11)







    }

}