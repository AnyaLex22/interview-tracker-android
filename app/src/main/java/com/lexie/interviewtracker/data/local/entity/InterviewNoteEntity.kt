package com.lexie.interviewtracker.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(
    tableName = "interview_notes",
    foreignKeys = [
        ForeignKey(
            entity = ApplicationEntity::class,
            parentColumns = ["id"],
            childColumns = ["applicationId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class InterviewNoteEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,

    val applicationId: Long,

    val title: String,
    val content: String,
    val createdAt: Long = System.currentTimeMillis()
)