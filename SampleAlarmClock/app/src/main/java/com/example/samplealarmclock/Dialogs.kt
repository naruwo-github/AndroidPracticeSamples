package com.example.samplealarmclock

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.DatePicker
import androidx.fragment.app.DialogFragment
import java.util.*

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

class DatePickerFragment : DialogFragment(), DatePickerDialog.OnDateSetListener {
    interface OnDateSelectedListener {
        fun onSelected(year: Int, month: Int, date: Int)
    }

    private var listener: OnDateSelectedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        when (context) {
            is OnDateSelectedListener -> listener = context
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val date = c.get(Calendar.DAY_OF_MONTH)
        return DatePickerDialog(requireActivity(), this, year, month, date)
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        listener?.onSelected(year, month, dayOfMonth)
    }

}