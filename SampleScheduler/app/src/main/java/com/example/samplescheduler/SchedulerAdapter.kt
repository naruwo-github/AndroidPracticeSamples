package com.example.samplescheduler

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import io.realm.OrderedRealmCollection
import io.realm.RealmRecyclerViewAdapter

class SchedulerAdapter(data: OrderedRealmCollection<Schedule>) : RealmRecyclerViewAdapter<Schedule, SchedulerAdapter.ViewHolder>(data, true) {

    init {
        //これをtrueにし、getItemIdでidを返すようにすることで、RecyclerViewを高速で描画できるようになる
        setHasStableIds(true)
    }

    class ViewHolder(cell: View) : RecyclerView.ViewHolder(cell) {
        val date: TextView = cell.findViewById(android.R.id.text1)
        val title: TextView = cell.findViewById(android.R.id.text2)
    }

    //セルが必要になるたび、呼び出される
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SchedulerAdapter.ViewHolder {
        //内部ではViewHolderのインスタンスを生成して返す
        val inflater = LayoutInflater.from(parent.context)
        //inflateメソッドにより、ビューにレイアウトXMLを適用している
        val view = inflater.inflate(android.R.layout.simple_list_item_2, parent, false)
        return ViewHolder(view)
    }

    //ViewHolderで保持しているビューに対し、実際に表示する画像や文字などのコンテンツの設定を行う
    override fun onBindViewHolder(holder: SchedulerAdapter.ViewHolder, position: Int) {
        val schedule: Schedule? = getItem(position)
        holder.date.text = DateFormat.format("yyyy/MM/dd", schedule?.date)
        holder.title.text = schedule?.title
    }

    override fun getItemId(position: Int): Long {
        return getItem(position)?.id ?: 0
    }
}