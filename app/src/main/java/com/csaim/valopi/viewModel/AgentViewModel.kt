package com.csaim.valopi.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.csaim.valopi.data.model.Agent
import com.csaim.valopi.data.model.AgentResponse
import com.csaim.valopi.data.repository.AgentRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AgentViewModel:ViewModel() {

    val repository = AgentRepository()

    private val _agents = MutableStateFlow<List<Agent>>(emptyList())
    val agents: StateFlow<List<Agent>> = _agents

    fun fetchAgents(){
        viewModelScope.launch {
            try {
                val response = repository.getAgents()
                _agents.value = response.data
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }




}