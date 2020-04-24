package com.example.samplealarmclock

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class TimeAlertDialog : DialogFragment() {
    interface Listener {
        fun getUp()
        fun snooze()
    }
    private var listener: Listener? = null

    //フラグメントのonAttachメソッドは、アクティビティからフラグメントが呼ばれた時に呼び出される
    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is Listener -> listener = context
        }
    }

    //内部でダイアログを作成し、戻り値として返す
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        var builder = AlertDialog.Builder(requireActivity())
        builder.setMessage("時間になりました！")
        builder.setPositiveButton("起きる") { dialog, which ->
            listener?.getUp()
        }
        builder.setNegativeButton("あと5分") { dialog, which ->
            listener?.snooze()
        }
        return builder.create()
    }
}