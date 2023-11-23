package com.albaez.albaez_client.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.albaez.albaez_client.AssetLoader
import com.albaez.albaez_client.R
import com.albaez.albaez_client.model.HomeData
import com.google.gson.Gson

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewpager = view.findViewById<ViewPager2>(R.id.viewpager_working_alba_card)
        val viewpagerIndicator = view.findViewById<TableLayout>(R.id.viewpager_alba_card_indicator)

        val assetLoader = AssetLoader()
        val homeJsonString = assetLoader.getJsonString(requireContext(),"home.json")
        Log.d("homeData", homeJsonString ?:"")

        if(!homeJsonString.isNullOrEmpty()){
            val gson = Gson()
            val homeData = gson.fromJson(homeJsonString,HomeData::class.java)

            viewpager.adapter = HomeWorkingAlbaCardAdapter().apply{
                submitList(homeData.workingAlbaCard)
            }
        }
    }
}