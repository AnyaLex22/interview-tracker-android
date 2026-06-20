package com.lexie.interviewtracker.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lexie.interviewtracker.model.JobApplication
import com.lexie.interviewtracker.repository.ApplicationRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class HomeViewModel(
    private val repository: ApplicationRepository
) : ViewModel() {
    val applications = flow { emit(repository.getApplications()) }
        .map { entities ->
            entities.map {
                JobApplication(
                    id = it.id,
                    companyName = it.companyName,
                    position = it.role,
                    dateApplied = it.appliedDate.toString(),
                    status = it.status
                )
            }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )
}
