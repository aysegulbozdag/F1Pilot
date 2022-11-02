package com.example.android.f1pilot.data.repository

import com.example.android.f1pilot.data.model.F1PilotDetail
import com.example.android.f1pilot.data.model.F1PilotList
import com.example.android.f1pilot.data.remote.F1PilotApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton
import com.example.android.f1pilot.util.Result

@Singleton
class F1PilotListRepo @Inject constructor(private val api: F1PilotApi) {
    suspend fun getF1PilotList() : Flow<Result<F1PilotList>> {
        return flow{
            emit(Result.loading())
            val character = api.getF1PilotList()
            emit(Result.success(character))
        }.flowOn(Dispatchers.IO)
    }

    suspend fun getF1PilotDetail(id :Int) : Flow<Result<F1PilotDetail>> {
        return flow{
            emit(Result.loading())
            val character = api.getF1PilotDetail(id)
            emit(Result.success(character))
        }.flowOn(Dispatchers.IO)
    }
}