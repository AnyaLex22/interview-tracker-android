package com.lexie.interviewtracker.ui.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lexie.interviewtracker.data.local.entity.ApplicationEntity
import com.lexie.interviewtracker.model.JobApplication
import com.lexie.interviewtracker.repository.ApplicationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class EditViewModel(
    private val repository: ApplicationRepository
) : ViewModel() {

    private val _application = MutableStateFlow<JobApplication?>(null)
    val application = _application.asStateFlow()

    fun loadApplication(id: Long) {
        viewModelScope.launch {
            val entity = repository.getApplication(id)
            _application.value = entity?.let {
                JobApplication(
                    id = it.id,
                    companyName = it.companyName,
                    position = it.role,
                    dateApplied = it.appliedDate.toString(),
                    status = it.status
                )
            }
        }
    }

    fun updateApplication(
        id: Long,
        company: String,
        position: String,
        date: String,
        status: String
    ) {
        viewModelScope.launch {
            repository.updateApplication(
                ApplicationEntity(
                    id = id,
                    companyName = company,
                    role = position,
                    status = status,
                    appliedDate = System.currentTimeMillis()
                )
            )
        }
    }
}
