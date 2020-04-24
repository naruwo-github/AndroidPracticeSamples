package com.example.samplescheduler

import android.app.Application
import io.realm.Realm

//Applicationクラスを継承している
class SampleSchedulerApplication : Application() {
    //ApplicationクラスのonCreateは、アクティビティより先に呼ばれる
    //そのためこの中でRealmを初期化する
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}