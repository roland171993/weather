package com.keyopstech

import android.app.Application
import com.keyopstech.di.AppModule
import com.keyopstech.di.DaggerAppComponent
import com.keyopstech.utils.Constant
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class App: Application(), HasAndroidInjector {

    @Inject
    lateinit var mInjector: DispatchingAndroidInjector<Any>

    override fun androidInjector(): AndroidInjector<Any> {
        return mInjector
    }

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent
            .builder()
            .appModule(AppModule(Constant.BASE_URL))
            .build()
            .inject(this)
    }
}