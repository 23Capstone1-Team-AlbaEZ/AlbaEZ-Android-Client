package com.albaez.albaez_client.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.albaez.albaez_client.R
import com.albaez.albaez_client.model.WorkingAlbaCardBanner


class HomeWorkingAlbaCardAdapter : ListAdapter<WorkingAlbaCardBanner, HomeWorkingAlbaCardAdapter.HomeWorkingAlbaCardAdapterViewHolder>(BannerDiffCallbacks()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeWorkingAlbaCardAdapterViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.item_working_alba_card,parent,false)
        return HomeWorkingAlbaCardAdapterViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeWorkingAlbaCardAdapterViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class HomeWorkingAlbaCardAdapterViewHolder(view: View):RecyclerView.ViewHolder(view){

        private val workplaceNameView = view.findViewById<TextView>(R.id.tv_card_workplace_name)
//        private val albaTimezoneView = view.findViewById<TextView>(R.id.tv_card_timezone1)

        fun bind(banner: WorkingAlbaCardBanner?) {
            if (banner != null) {
//                workplaceNameView.text = banner.albaInfo.workplaceName
                workplaceNameView.text = "동작구 상도동 도미노ㅠㅣ자"
            }
//          albaTimezone1View.text = banner.albaTimezone[]
        }
    }
}


class BannerDiffCallbacks : DiffUtil.ItemCallback<WorkingAlbaCardBanner>(){
    override fun areItemsTheSame(oldItem: WorkingAlbaCardBanner, newItem: WorkingAlbaCardBanner): Boolean {
        return oldItem.albaInfo.workplaceID==newItem.albaInfo.workplaceID
    }

    override fun areContentsTheSame(oldItem: WorkingAlbaCardBanner, newItem: WorkingAlbaCardBanner): Boolean {
        return oldItem==newItem
    }
}
