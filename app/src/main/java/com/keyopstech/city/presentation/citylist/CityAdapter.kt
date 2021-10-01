package com.keyopstech.city.presentation.citylist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.keyopstech.city.domaine.model.City
import com.keyopstech.weather.R
import kotlinx.android.synthetic.main.row_city.view.*


class CityAdapter:BaseAdapter {
    private var cities = ArrayList<City>()
    private var context:Context?= null

    constructor(listCity:ArrayList<City>, context:Context):super(){
        this.cities = listCity
        this.context = context
    }

    override fun getCount(): Int {
        return cities.size
    }

    override fun getItem(item: Int): Any {
        return cities[item];
    }

    override fun getItemId(index: Int): Long {
        return index.toLong()
    }

    override fun getView(index: Int, view: View?, p2: ViewGroup?): View {
        val cityView = LayoutInflater.from(context).inflate(R.layout.row_city,null)
        val myCity = cities[index]
        cityView.nameTextView.text = myCity.name
        myCity.image?.let {
            cityView.flagImageView.setImageDrawable(context?.getDrawable(it))
        }

        return cityView
    }
}