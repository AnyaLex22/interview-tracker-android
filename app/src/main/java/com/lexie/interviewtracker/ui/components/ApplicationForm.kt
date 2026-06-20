package com.lexie.interviewtracker.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.lexie.interviewtracker.model.JobApplication

@Composable
fun ApplicationForm(
    title: String,
    initialData: JobApplication? = null,
    onSubmit: (String, String, String, String) -> Unit
) {
    var company by remember { mutableStateOf(initialData?.companyName ?: "") }
    var position by remember { mutableStateOf(initialData?.position ?: "") }
    var date by remember { mutableStateOf(initialData?.dateApplied ?: "") }
    var status by remember { mutableStateOf(initialData?.status ?: "Applied") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(text = title, style = MaterialTheme.typography.headlineMedium)
        
        OutlinedTextField(
            value = company,
            onValueChange = { company = it },
            label = { Text("Company") },
            modifier = Modifier.fillMaxWidth()
        )
        
        OutlinedTextField(
            value = position,
            onValueChange = { position = it },
            label = { Text("Position") },
            modifier = Modifier.fillMaxWidth()
        )
        
        OutlinedTextField(
            value = date,
            onValueChange = { date = it },
            label = { Text("Date Applied") },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownStatusSelector(
            selected = status,
            onSelected = { status = it }
        )
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Button(
            onClick = { onSubmit(company, position, date, status) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save")
        }
    }
}

@Composable
fun DropdownStatusSelector(
    selected: String,
    onSelected: (String) -> Unit
) {
    val options = listOf(
        "Applied",
        "Screening",
        "Interview",
        "Technical",
        "Offer",
        "Rejected"
    )

    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            label = { Text("Status") },
            readOnly = true,
            modifier = Modifier.fillMaxWidth().clickable { expanded = true }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    text = { Text(option) },
                    onClick = {
                        onSelected(option)
                        expanded = false
                    }
                )
            }
        }
    }
}
