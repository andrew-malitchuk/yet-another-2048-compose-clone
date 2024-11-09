package dev.ya2048cc.app

import android.app.Application
import dev.ya2048cc.app.di.initKoin
import org.koin.android.ext.koin.androidContext

class Application : Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin{
            androidContext(this@Application)
        }
    }
}