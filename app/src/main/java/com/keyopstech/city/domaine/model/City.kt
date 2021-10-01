package com.keyopstech.city.domaine.model

import android.graphics.drawable.AnimatedImageDrawable
import androidx.annotation.DrawableRes

class City {
    var name:String?=null
    @DrawableRes var image: Int? = null


    constructor(name:String ="",imageDrawable: Int){
        this.name = name
        this.image = imageDrawable
    }


}