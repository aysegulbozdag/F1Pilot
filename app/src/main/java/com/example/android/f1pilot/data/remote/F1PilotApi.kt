package com.example.android.f1pilot.data.remote

import com.example.android.f1pilot.data.model.F1Pilot
import com.example.android.f1pilot.data.model.F1PilotDetail
import com.example.android.f1pilot.data.model.F1PilotList
import retrofit2.http.GET
import retrofit2.http.Path

interface F1PilotApi {
    @GET("oguzayan/kuka/drivers")
    suspend fun getF1PilotList(): F1PilotList

    @GET("oguzayan/kuka/driverDetail/{id}")
    suspend fun getF1PilotDetail(
        @Path("id") id:Int,
    ): F1PilotDetail
}