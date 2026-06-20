package com.lexie.interviewtracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "applications")
data class ApplicationEntity(
    @PrimaryKey (autoGenerate = true)
    val id: Long = 0,

    val companyName: String,
    val role: String,
    val status: String, //Applied, Interviewing, Offer, Rejected
    val appliedDate: Long = System.currentTimeMillis()
)