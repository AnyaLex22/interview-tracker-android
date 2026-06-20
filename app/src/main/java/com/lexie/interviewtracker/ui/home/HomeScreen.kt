package com.lexie.interviewtracker.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lexie.interviewtracker.model.JobApplication

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel,
    onAddClick: () -> Unit,
    onEditClick: (Long) -> Unit
) {
    val applications = viewModel.applications.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Interview Tracker")})
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Text("+")
            }
        }
    ) {padding ->

        LazyColumn(
            modifier = Modifier.padding(padding)
        ) {
            items(applications.value) {app  ->

                ApplicationCard(
                    app = app,
                    onClick = {onEditClick(app.id)}
                )
            }
        }
    }
}

@Composable
fun ApplicationCard(
    app: JobApplication,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(0.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier =  Modifier.padding(16.dp)) {
            Text(text = app.companyName, style = MaterialTheme.typography.titleMedium)
            Text(app.position)
            Text("Status: ${app.status}")
        }
    }
}