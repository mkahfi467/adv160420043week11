package com.example.adv160420043week4.view

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.adv160420043week4.R
import com.example.adv160420043week4.util.createNotificationChannel
import com.example.adv160420043week4.util.showNotification
import com.google.android.material.floatingactionbutton.FloatingActionButton
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    // WEEK 7
    init {
        instance = this
    }
    companion object {
        var instance:MainActivity ?= null
    }
    // END WEEK 7

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // WEEK 7
        createNotificationChannel(this, NotificationManagerCompat.IMPORTANCE_DEFAULT, false, getString(R.string.app_name), "App notification channel.")

        val fab = findViewById<FloatingActionButton>(R.id.fabBtnNotif)
        fab.setOnClickListener {
            val observable = Observable.timer(5, TimeUnit.SECONDS).apply {
                subscribeOn(Schedulers.io())
                observeOn(AndroidSchedulers.mainThread())
                subscribe {
                    Log.d("ObserverMessages", "Five second")
                    showNotification("Dummy", "A new notification created", R.drawable.baseline_email_24)
                }
            }
        }

        val observable = Observable.just("a stream of data","hellow","world")

        val observer = object : Observer<String> {
            override fun onSubscribe(d: Disposable) {
                Log.d("Messages", "begin subscribe")
            }

            override fun onError(e: Throwable) {
                Log.e("Messages", "error: ${e!!.message.toString()}")
            }

            override fun onComplete() {
                Log.d("Messages", "complete")
            }

            override fun onNext(t: String) {
                Log.d("Messages", "data: $t")
            }

        }

        observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(observer)

        // END WEEK 7
    }
}