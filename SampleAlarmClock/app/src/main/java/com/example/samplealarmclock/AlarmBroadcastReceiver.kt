package com.example.samplealarmclock

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AlarmBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val mainIntent = Intent(context, MainActivity::class.java)
            .putExtra("onReceive", true)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        //↑BroadCastReceiverからアクティビティを開くときは、Intentにこのフラグをつけておくべき
        context.startActivity(mainIntent)
//        Toast.makeText(context, "アラームを受信しました", Toast.LENGTH_SHORT)
//            .show()
    }
}
