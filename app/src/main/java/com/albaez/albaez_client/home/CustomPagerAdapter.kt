package com.albaez.albaez_client.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import com.albaez.albaez_client.R
import com.albaez.albaez_client.model.BannerAlbaTimezone
import com.albaez.albaez_client.model.WorkingAlbaCardBanner

class CustomPagerAdapter(private val context: Context, private val homeDataList: List<WorkingAlbaCardBanner>) : PagerAdapter() {

    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_working_alba_card, parent, false)
        return ViewHolder(view)
    }*/

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.item_working_alba_card, container, false)

        // 현재 페이지에 해당하는 데이터 추출
        val currentWorkingAlbaCard = homeDataList[position]
        val timezoneList: List<BannerAlbaTimezone> = currentWorkingAlbaCard.albaTimezone

        // TextView 동적 생성 및 추가
        val textViewContainer: TextView = view.findViewById(R.id.tv_card_timezone)
        for (timezone in timezoneList) {
            val textView = TextView(context)
            textView.text = "${timezone.albaDay} ${timezone.albaTime}"
            // 적절한 속성 설정 (e.g., textSize, textColor 등)
            textViewContainer.append(textView.text)
        }

        container.addView(view)
        return view
    }

    override fun getCount(): Int {
        return homeDataList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    /*class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)*/
}
