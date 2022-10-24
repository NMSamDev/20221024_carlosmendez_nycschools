package com.example.a20221024_carlosmendez_nycschools.data.data_source

import androidx.room.Query
import com.example.a20221024_carlosmendez_nycschools.domain.model.SatResult
import kotlinx.coroutines.flow.Flow

interface SatResultDao {
    @Query("SELECT * FROM sat_result")
    fun getSatResults(): Flow<List<SatResult>>

    @Query("SELECT * FROM sat_result WHERE dbn = :dbn")
    fun getSatResult(dbn: String): SatResult?
}