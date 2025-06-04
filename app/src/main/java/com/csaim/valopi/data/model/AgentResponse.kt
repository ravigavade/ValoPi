package com.csaim.valopi.data.model

import kotlinx.coroutines.flow.MutableStateFlow

data class AgentResponse(
    val data: List<Agent>
)

data class Agent(
    val displayName:String,
    val displayIcon: String,
    val background: String,
    val role: Role,
    val abilities: List<Ability>

)

data class Role(
    val displayName: String,
    val displayIcon: String
)

data class Ability(
    val displayName: String,
    val displayIcon: String
)
