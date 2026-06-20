package com.lexie.interviewtracker.repository

import com.lexie.interviewtracker.data.local.dao.ApplicationDao
import com.lexie.interviewtracker.data.local.entity.ApplicationEntity

class ApplicationRepository(
    private val dao: ApplicationDao
) {

    suspend fun addApplication(app: ApplicationEntity) =
        dao.insert(app)

    suspend fun updateApplication(app: ApplicationEntity) =
        dao.update(app)

    suspend fun deleteApplication(app: ApplicationEntity) =
        dao.delete(app)

    suspend fun getApplications() =
        dao.getAllApplications()

    suspend fun getApplication(id: Long) =
        dao.getApplicationById(id)
}
