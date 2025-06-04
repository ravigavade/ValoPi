package com.csaim.valopi.data.repository

import com.csaim.valopi.data.model.AgentResponse
import com.csaim.valopi.data.remote.AgentApi
import com.csaim.valopi.data.remote.AgentApiService

class AgentRepository {

    suspend fun getAgents():AgentResponse{
        return AgentApi.service.getAgents()
    }
}