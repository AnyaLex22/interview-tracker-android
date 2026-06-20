package com.lexie.interviewtracker.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.lexie.interviewtracker.data.local.dao.ApplicationDao
import com.lexie.interviewtracker.data.local.dao.InterviewNoteDao
import com.lexie.interviewtracker.data.local.entity.ApplicationEntity
import com.lexie.interviewtracker.data.local.entity.InterviewNoteEntity

@Database(
    entities = [
        ApplicationEntity::class,
        InterviewNoteEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun applicationDao(): ApplicationDao
    abstract fun interviewNoteDao(): InterviewNoteDao
}
