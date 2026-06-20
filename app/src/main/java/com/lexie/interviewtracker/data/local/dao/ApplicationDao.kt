package com.lexie.interviewtracker.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.lexie.interviewtracker.data.local.entity.ApplicationEntity

@Dao
interface ApplicationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(application: ApplicationEntity): Long

    @Update
    suspend fun update(application: ApplicationEntity)

    @Delete
    suspend fun delete(application: ApplicationEntity)

    @Query("SELECT * FROM applications ORDER BY appliedDate DESC")
    suspend fun getAllApplications(): List<ApplicationEntity>

    @Query("SELECT * FROM applications WHERE id = :id")
    suspend fun getApplicationById(id: Long): ApplicationEntity?
}