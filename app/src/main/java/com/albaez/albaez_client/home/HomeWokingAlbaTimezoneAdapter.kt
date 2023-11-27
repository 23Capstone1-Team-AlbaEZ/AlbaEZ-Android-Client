package com.albaez.albaez_client.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.albaez.albaez_client.R
import com.albaez.albaez_client.model.BannerAlbaTimezone

class HomeWorkingAlbaTimezoneAdapter(private val timezoneList: List<BannerAlbaTimezone>) :
    RecyclerView.Adapter<HomeWorkingAlbaTimezoneAdapter.TimezoneViewHolder>() {

    class TimezoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val timezoneView: TextView = itemView.findViewById(R.id.tv_card_timezone)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TimezoneViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_working_alba_card, parent, false)
        return TimezoneViewHolder(view)
    }

    override fun onBindViewHolder(holder: TimezoneViewHolder, position: Int) {
        val timezoneData = timezoneList[position]

        // 각각의 RecyclerView 아이템에 데이터를 할당
        holder.timezoneView.text = "${timezoneData.albaDay} ${timezoneData.albaTime}"
    }

    override fun getItemCount(): Int {
        return timezoneList.size
    }
}