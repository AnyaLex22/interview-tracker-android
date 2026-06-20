package com.lexie.interviewtracker.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lexie.interviewtracker.data.local.entity.ApplicationEntity
import com.lexie.interviewtracker.repository.ApplicationRepository
import kotlinx.coroutines.launch

class AddViewModel(
    private val repository: ApplicationRepository
) : ViewModel() {
    fun addApplication(
        company: String,
        position: String,
        date: String,
        status: String
    ) {
        viewModelScope.launch {
            repository.addApplication(
                ApplicationEntity(
                    companyName = company,
                    role = position,
                    status = status,
                    appliedDate = System.currentTimeMillis()
                )
            )
        }
    }
}
