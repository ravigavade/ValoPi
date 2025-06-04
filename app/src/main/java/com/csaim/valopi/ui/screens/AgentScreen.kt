package com.csaim.valopi.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.csaim.valopi.viewModel.AgentViewModel

@Composable
fun AgentScreen(viewModel: AgentViewModel= viewModel()) {

    val agents = viewModel.agents.collectAsState().value
    LaunchedEffect(Unit) {
        viewModel.fetchAgents()
    }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize()
    ) {

        LazyColumn {
            items(agents) { agent ->
                Text(agent.displayName)
            }
        }

    }




}