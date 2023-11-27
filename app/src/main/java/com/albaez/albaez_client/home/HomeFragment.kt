package com.albaez.albaez_client.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.albaez.albaez_client.AssetLoader
import com.albaez.albaez_client.R
import com.albaez.albaez_client.model.BannerAlbaTimezone
import com.albaez.albaez_client.model.HomeData
import com.google.gson.Gson

class HomeFragment : Fragment() {

    private val assetLoader = AssetLoader()
    private lateinit var timezoneAdapter: HomeWorkingAlbaTimezoneAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val workplaceName = view.findViewById<TextView>(R.id.tv_card_workplace_name)


        val viewPager = view.findViewById<ViewPager2>(R.id.viewpager_working_alba_card)
        /*val viewpagerIndicator = view.findViewById<TabLayout>(R.id.viewpager_alba_card_indicator)*/


        val homeJsonString = assetLoader.getJsonString(requireContext(), "home.json")
        Log.d("homeData", homeJsonString ?: "")

        if (!homeJsonString.isNullOrEmpty()) {
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString, HomeData::class.java)

            /*val pagerAdapter = CustomPagerAdapter(requireContext(),homeData.workingAlbaCard)
            viewPager.adapter = pagerAdapter*/

            viewPager.adapter=HomeWorkingAlbaCardAdapter().apply {
                submitList(homeData.workingAlbaCard)
            }


            /*// RecyclerView 설정
            val timezoneRecyclerView: RecyclerView = view.findViewById(R.id.tv_card_timezone)
            timezoneRecyclerView.layoutManager = LinearLayoutManager(context)

            val timezoneList: List<BannerAlbaTimezone> = homeData.workingAlbaCard.flatMap { it.albaTimezone }
            val homeWorkingAlbaTimezoneAdapter = HomeWorkingAlbaTimezoneAdapter(timezoneList) // RecyclerView 초기화
            timezoneRecyclerView.adapter=homeWorkingAlbaTimezoneAdapter // RecyclerView 할당*/

        }

        /*viewpager.offscreenPageLimit = 3

        TabLayoutMediator(viewpagerIndicator,viewpager,object:TabLayoutMediator.TabConfigurationStrategy){
            onConfigurTa
        }*/
    }
}
