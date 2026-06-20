package com.lexie.interviewtracker.ui.add

import androidx.compose.runtime.Composable
import com.lexie.interviewtracker.ui.components.ApplicationForm

@Composable
fun AddApplicationScreen(
    viewModel: AddViewModel,
    onSave: () -> Unit
) {
    ApplicationForm(
        title = "Add Application",
        onSubmit = { company, position, date, status ->
            viewModel.addApplication(company, position, date, status)
            onSave()
        }
    )
}