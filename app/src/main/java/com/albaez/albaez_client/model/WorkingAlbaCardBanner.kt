package com.albaez.albaez_client.model

data class HomeData(
    val workingAlbaCard: List<WorkingAlbaCardBanner>
)
data class WorkingAlbaCardBanner(
    val albaInfo: BannerAlbaInfo,
    val albaTimezone:List<BannerAlbaTimezone>
)

data class BannerAlbaInfo(
    val workplaceName : String,
    val userRole: String,
    val workplaceID: String
)

data class BannerAlbaTimezone(
    val albaDay:String,
    val albaTime:String
)