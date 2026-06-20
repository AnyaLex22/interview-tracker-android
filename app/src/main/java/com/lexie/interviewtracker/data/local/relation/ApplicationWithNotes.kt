package com.lexie.interviewtracker.data.local.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.lexie.interviewtracker.data.local.entity.ApplicationEntity
import com.lexie.interviewtracker.data.local.entity.InterviewNoteEntity

data class ApplicationWithNotes(

    @Embedded
    val application: ApplicationEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "applicationId"
    )
    val notes: List<InterviewNoteEntity>
)