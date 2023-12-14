package scheduleData

data class GSdata(
    val gsID: Int? = null,
    val date: Int? = null,
    val startTime: Int? = null,
    val endTime: Int? = null,
    val memberIDs: Array<Int>? = null,
    val role: Array<String>? =null
)
