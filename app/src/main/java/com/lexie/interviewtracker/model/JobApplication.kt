package com.lexie.interviewtracker.model

data class JobApplication(
    val id: Long = 0,
    val companyName: String,
    val position: String,
    val dateApplied: String,
    val status: String
)
