package com.lexie.interviewtracker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.lexie.interviewtracker.data.local.entity.InterviewNoteEntity


@Dao
interface InterviewNoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: InterviewNoteEntity): Long

    @Update
    suspend fun update(note: InterviewNoteEntity)

    @Delete
    suspend fun delete(note: InterviewNoteEntity)

    @Query("SELECT * FROM interview_notes WHERE applicationId = :applicationId ORDER BY createdAt DESC")
    suspend fun getNotesForApplication(applicationId: Long): List<InterviewNoteEntity>
}