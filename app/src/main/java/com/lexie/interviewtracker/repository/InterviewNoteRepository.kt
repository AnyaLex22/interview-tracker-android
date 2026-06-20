package com.lexie.interviewtracker.repository

import com.lexie.interviewtracker.data.local.dao.InterviewNoteDao
import com.lexie.interviewtracker.data.local.entity.InterviewNoteEntity

class InterviewNoteRepository(
    private val dao: InterviewNoteDao
) {

    suspend fun addNote(note: InterviewNoteEntity) =
        dao.insert(note)

    suspend fun updateNote(note: InterviewNoteEntity) =
        dao.update(note)

    suspend fun deleteNote(note: InterviewNoteEntity) =
        dao.delete(note)

    suspend fun getNotes(applicationId: Long) =
        dao.getNotesForApplication(applicationId)
}