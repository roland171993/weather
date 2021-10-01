package com.keyopstech.city.presentation.citylist

import android.content.Context
import android.widget.ListView
import com.keyopstech.city.domaine.model.City
import com.keyopstech.city.domaine.usecase.GetCityListUseCase
import com.keyopstech.utils.Utils
import com.keyopstech.weather.R
import javax.inject.Inject


class CityListPresenter @Inject constructor(private val getCityListUseCase: GetCityListUseCase) {
    private var view: CityListView? = null
    private var context:Context? = null
    private var cities:ArrayList<City>? = null


    fun loadData(){
        this.cities = getCityListUseCase.execute()
        context?.let {
            view?.let { viewNonNull ->
                val listView:ListView? = viewNonNull.getListView()
                listView?.let {
                    cities?.let {
                        var cityAdapter = CityAdapter(cities!!, context!!)
                        listView.adapter = cityAdapter
                        listView.setOnItemClickListener { _, _, position, _ ->
                            // Go To Weather Detail Activity(Screen)
                            if(!Utils.isOnline(context!!)){
                                Utils.showToast(context!!, R.string.error_no_internet)
                            }else{
                                val citySelected:City? = cityAdapter.getItem(position) as City // The item that was clicked
                                citySelected?.let {
                                    it.name?.let { name -> view!!.goToDetail(name) }
                                }

                            }

                        }
                    }
                }


            }
        }

    }
    fun onViewCreated(view: CityListView, context: Context) {
        this.view = view
        this.context = context
    }

    fun onViewDestroyed() {
        view = null
    }

    fun getCityList():ArrayList<City>?{
        return this.cities
    }
}