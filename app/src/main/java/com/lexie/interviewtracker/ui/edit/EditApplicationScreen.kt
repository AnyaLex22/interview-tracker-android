package com.lexie.interviewtracker.ui.edit

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.lexie.interviewtracker.ui.components.ApplicationForm

@Composable
fun EditApplicationScreen(
    viewModel: EditViewModel,
    applicationId: Long,
    onSave: () -> Unit
) {
    LaunchedEffect(applicationId) {
        viewModel.loadApplication(applicationId)
    }

    val app = viewModel.application.collectAsState()

    if (app.value != null) {
        ApplicationForm(
            title = "Edit Application",
            initialData = app.value!!,
            onSubmit = { company, position, date, status ->
                viewModel.updateApplication(
                    app.value!!.id,
                    company,
                    position,
                    date,
                    status
                )
                onSave()
            }
        )
    }
}