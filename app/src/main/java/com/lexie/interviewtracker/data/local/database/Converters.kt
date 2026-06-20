package com.lexie.interviewtracker.data.local.database

import androidx.room.TypeConverter
import com.lexie.interviewtracker.data.local.entity.ApplicationStatus

class Converters {

    // Convert Enum → String (to store in DB)
    @TypeConverter
    fun fromApplicationStatus(status: ApplicationStatus): String {
        return status.name
    }

    // Convert String → Enum (when reading from DB)
    @TypeConverter
    fun toApplicationStatus(value: String): ApplicationStatus {
        return ApplicationStatus.valueOf(value)
    }
}