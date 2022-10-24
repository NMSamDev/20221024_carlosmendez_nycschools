package com.example.a20221024_carlosmendez_nycschools.data.data_source

import androidx.room.Dao
import androidx.room.Query
import com.example.a20221024_carlosmendez_nycschools.domain.model.School
import kotlinx.coroutines.flow.Flow

// I wanted to implement a Room database to store the data from the API calls, but I ran out of time.

@Dao
interface SchoolDao {

    @Query("SELECT * FROM school")
    fun getNotes(): Flow<List<School>>

    @Query("SELECT * FROM school WHERE dbn = :dbn")
    fun getSchool(dbn: String): School?
}