package com.example.myalbaez.schema

import java.time.LocalDate
import java.time.LocalDateTime

data class AuthorizationRequest(
    val authorizationCode: String
)

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val grantType: String,
    val expiresIn: Int
)

data class AuthorizationCodeRequest(
    val authorizationCode: String
)

data class AccessTokenResponse(
    val accessToken: String,
    val refreshToken: String,
    val grantType: String,
    val expiresIn: Int
)


data class WorkplaceRequest(
    val workplaceID: Int,
    val name: String,
    val address: String,
    val invitationCode: Int
)

data class WorkplaceResponse(
    val workplaceID: Int,
    val name: String,
    val address: String,
    val invitationCode: Int
)


data class MemberRequest(
    val invitationCode: Int,
    val userID: Int,
    val role: String,
    val salary: Int
)

data class MemberResponse(
    val memberID: Int,
    val workplaceID: Int,
    val userID: Int,
    val role: String,
    val privilege: Boolean,
    val salary: Int,
    val startday: LocalDateTime,
    val endday: LocalDateTime?
)
data class ScheduleRequest(
    val memberIDList: List<Int>,
    val week: Int,
    val day: String,
    val startTime: String,
    val endTime: String
)

data class ScheduleResponse(
    val scheduleId: Int,
    val memberID: Int,
    val week: Int,
    val day: String,
    val startTime: String,
    val endTime: String
)
data class SingleScheduleRequest(
    val scheduleID: Int,
    val day: String,
    val startTime: String,
    val endTime: String
)

data class MultipleSchedulesResponse(
    val scheduleId: Int,
    val memberID: Int,
    val week: Int,
    val day: String,
    val startTime: String,
    val endTime: String
)
data class Workplace(
    val workplaceName: String,
    val workplaceID: Int,
    val scheduleList: List<Schedule>
)

data class Schedule(
    val scheduleId: Int,
    val memberID: Int,
    val week: Int,
    val day: String,
    val startTime: String,
    val endTime: String
)

data class PostRequest(
    val content: String,
    val title: String,
    val workplaceID: Int
)

data class PostResponse(
    val informID: Int,
    val workplace: WorkplaceDetail,
    val postTime: LocalDateTime,
    val title: String,
    val content: String
)

data class WorkplaceDetail(
    val workplaceID: Int,
    val name: String,
    val address: String,
    val invitationCode: Int
)

data class AdjustScheduleRequest(
    val scheduleID: Int,
    val adjustToMembers: List<Int>
)

data class ScheduleAdjustResponse(
    val scheduleAdjustId: Int,
    val scheduleID: Int,
    val status: Boolean,
    val adjustToMembers: List<Int>
)


data class GigJobPostRequest(
    val scheduleAdjustID: Int,
    val content: String,
    val expirationDate: String
)

data class GigJobPostResponse(
    val gigjobPostID: Int,
    val scheduleAdjustID: Int,
    val workplaceName: String,
    val address: String,
    val content: String,
    val day: String,
    val startTime: String,
    val endTime: String,
    val postDate: LocalDateTime,
    val expirationDate: LocalDateTime
)
data class ScheduleAdjustmentResponse(
    val scheduleAdjustId: Int,
    val scheduleID: Int,
    val memberID: Int,
    val startTime: String,
    val endTime: String,
    val adjustMembers: List<Int>
)

data class WorkplacePrivilegeResponse(
    val workplace: WorkplaceDetail,
    val privilege: Boolean
)
data class WeeklyRoleCountsResponse(
    val week: Int,
    val day: String,
    val startTime: String,
    val endTime: String,
    val roleCounts: List<RoleCount>
)

data class RoleCount(
    val role: String,
    val count: Int
)
data class AlarmRequest(
    val memberIdList: List<Int>,
    val content: String
)

data class AlarmResponse(
    val alarmID: Int,
    val userID: Int,
    val workplaceID: Int,
    val status: Boolean,
    val content: String
)