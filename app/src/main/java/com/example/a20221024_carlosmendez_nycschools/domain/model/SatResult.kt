package com.example.a20221024_carlosmendez_nycschools.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sat_result")
data class SatResult(
    @PrimaryKey val dbn: String,
    val school_name: String,
    val num_of_sat_test_takers: String,
    val sat_critical_reading_avg_score: String,
    val sat_math_avg_score: String,
    val sat_writing_avg_score: String
)
