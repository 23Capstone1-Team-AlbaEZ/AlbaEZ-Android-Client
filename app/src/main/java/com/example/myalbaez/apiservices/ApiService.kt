package com.example.myalbaez.apiservices


import com.example.myalbaez.schema.AccessTokenResponse
import com.example.myalbaez.schema.AdjustScheduleRequest
import com.example.myalbaez.schema.AlarmRequest
import com.example.myalbaez.schema.AlarmResponse
import com.example.myalbaez.schema.AuthorizationCodeRequest
import com.example.myalbaez.schema.GigJobPostRequest
import com.example.myalbaez.schema.GigJobPostResponse
import com.example.myalbaez.schema.MemberRequest
import com.example.myalbaez.schema.MemberResponse
import com.example.myalbaez.schema.PostRequest
import com.example.myalbaez.schema.PostResponse
import com.example.myalbaez.schema.ScheduleAdjustResponse
import com.example.myalbaez.schema.ScheduleAdjustmentResponse
import com.example.myalbaez.schema.ScheduleRequest
import com.example.myalbaez.schema.ScheduleResponse
import com.example.myalbaez.schema.SingleScheduleRequest
import com.example.myalbaez.schema.WorkplaceRequest
import com.example.myalbaez.schema.WorkplaceResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @POST("/api/auth/kakao")
    fun authenticateWithKakao(@Body request: AuthorizationCodeRequest): Call<AccessTokenResponse>

    @POST("/workplace/new")
    fun createWorkplace(@Body request: WorkplaceRequest): Call<WorkplaceResponse>

    @POST("/member/new")
    fun createMember(@Body request: MemberRequest): Call<MemberResponse>

    @POST("/workplace/schedule/new")
    fun createWorkplaceSchedule(@Body request: ScheduleRequest): Call<ScheduleResponse>

    @POST("/workplace/schedule/update")
    fun updateWorkplaceSchedule(@Body request: SingleScheduleRequest): Call<ScheduleResponse>

    @GET("/user/search/schedule/{userID}")
    fun searchUserSchedule(@Path("userID") userID: Int): Call<List<ScheduleResponse>>

    @POST("/inform/write")
    fun writeInform(@Body request: PostRequest): Call<PostResponse>

    @GET("/inform/{id}")
    fun getInform(@Path("id") id: Int): Call<PostResponse>

    @POST("/workplace/schedule/adjust")
    fun adjustWorkplaceSchedule(@Body request: AdjustScheduleRequest): Call<ScheduleAdjustResponse>

    @PATCH("/workplace/schedule/adjust/member/{memberID}")
    fun adjustMemberSchedule(@Path("memberID") memberID: Int, @Body request: AdjustScheduleRequest): Call<ScheduleAdjustResponse>

    @POST("/workplace/schedule/post")
    fun postWorkplaceSchedule(@Body request: GigJobPostRequest): Call<GigJobPostResponse>

    @GET("/workplace/schedule/adjust/{memberId}")
    fun getMemberAdjustments(@Path("memberId") memberId: Int): Call<List<ScheduleAdjustmentResponse>>

    @PATCH("/workplace/schedule/adjust/admin/{memberID}")
    fun adminAdjustMemberSchedule(@Path("memberID") memberID: Int, @Body request: AdjustScheduleRequest): Call<ScheduleAdjustResponse>

    @GET("/gigjob/home/{userID}")
    fun getGigJobHome(@Path("userID") userID: Int): Call<List<GigJobPostResponse>>

    @GET("/gigjob/search/{userID}")
    fun searchGigJobs(@Path("userID") userID: Int): Call<List<GigJobPostResponse>>

    @GET("/user/search/workplace/{userID}")
    fun searchUserWorkplaces(@Path("userID") userID: Int): Call<List<WorkplaceResponse>>

    @GET("/workplace/schedule/{workplaceID}")
    fun getWorkplaceSchedule(@Path("workplaceID") workplaceID: Int): Call<List<ScheduleResponse>>

    @GET("/member/schedule/{memberID}")
    fun getMemberSchedule(@Path("memberID") memberID: Int): Call<List<ScheduleResponse>>

    @POST("/alarm/new")
    fun createAlarm(@Body request: AlarmRequest): Call<List<AlarmResponse>>

    @GET("/alarm/{userID}")
    fun getUserAlarms(@Path("userID") userID: Int): Call<List<AlarmResponse>>

    @GET("/alarm/check/{alarmID}")
    fun checkAlarm(@Path("alarmID") alarmID: Int): Call<List<AlarmResponse>>
}