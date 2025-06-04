package com.csaim.valopi.data.remote

import com.csaim.valopi.data.model.AgentResponse
import retrofit2.http.GET

interface AgentApiService {
    @GET("v1/agents")
    suspend fun getAgents(): AgentResponse
}