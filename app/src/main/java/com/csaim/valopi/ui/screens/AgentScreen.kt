package com.csaim.valopi.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
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
            .statusBarsPadding()
    ) {

        LazyColumn {
                items(agents) { agent ->
                    Card(
                        colors = CardDefaults.cardColors(
                            containerColor = Color(0xFF0F1923) // a Valorant red-ish tone
                        ),
                        modifier = Modifier
                            .padding(6.dp)
                            .fillParentMaxWidth()

                    ) {
                        Row( //entire card as a row
                            modifier = Modifier
                                .fillMaxSize()
                        ) {
                            Row ( //left container
                                modifier = Modifier
    //                                .padding(16.dp)
                                    .height(200.dp)

                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxHeight()
                                ) {
//                                    AsyncImage( // background image
//                                        model = agent.background,
//                                        contentDescription = null,
//                                        modifier = Modifier
//                                        //                                        .matchParentSize() // Fill the whole Box
//                                    )

                                    Column (
                                        modifier = Modifier
//                                            .background(Color.Blue)
                                            .fillMaxHeight()
                                            .padding(8.dp),
                                        horizontalAlignment = Alignment.CenterHorizontally,
                                        verticalArrangement = Arrangement.SpaceEvenly
                                    ){
                                        AsyncImage( // agent images
                                            model = agent.displayIcon,
                                            contentDescription = agent.displayName,
                                            modifier = Modifier
                                                .height(80.dp)

                                        )
                                        agent.role?.displayIcon?.let { iconUrl ->
                                            AsyncImage(
                                                model = iconUrl,
                                                contentDescription = "${agent.displayName} role icon",
                                                modifier = Modifier.height(80.dp)
                                            )
                                        }


                                    }
                                }

                            }
                            Row(//outer most right container
                                modifier = Modifier
//                                    .background(Color.Gray)
                                    .fillMaxWidth()
                            ) {

                                Column( //right column
                                    modifier = Modifier
//                                        .background(Color.Gray)
                                        .fillMaxSize()
                                        .height(200.dp)
                                ) {
                                    Row( //upper right column
                                        modifier = Modifier
//                                            .background(Color.Red)
                                            .fillMaxWidth()
                                            .weight(1f),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            modifier = Modifier
                                                .padding(16.dp),
                                            text = agent.displayName,
                                            fontSize = 39.sp,
                                            color = Color.White
                                        )
                                    }

                                    Divider()

                                    Row ( //lower right column
                                        modifier = Modifier
//                                            .background(Color.Green)
                                            .fillMaxWidth()
                                            .horizontalScroll(rememberScrollState())
                                            .weight(1f),
                                        horizontalArrangement = Arrangement.Center,
                                    ) {
                                        agent.abilities.forEach { ability ->
                                            Card(
                                                modifier = Modifier
                                                    .padding(8.dp),


                                            ) {
                                                Column(
                                                    modifier = Modifier
                                                        .background(Color(0xFFFD4556))
                                                        .padding(4.dp),
                                                    horizontalAlignment = Alignment.CenterHorizontally
                                                ) {
                                                    AsyncImage( // ability images
                                                        model = ability.displayIcon,
                                                        contentDescription = agent.displayName,
                                                        modifier = Modifier
                                                            .height(60.dp)

                                                    )
                                                    Text(text = ability.displayName, color = Color.White)
                                                }

                                            }
//
                                        }
                                    }
                                }


                            }
                        }
                    }
                }
        }

    }




}