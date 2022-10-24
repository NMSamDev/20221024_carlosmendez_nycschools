package com.example.a20221024_carlosmendez_nycschools.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class School(
    @PrimaryKey val dbn: String,
    val school_name: String,
    val overview_paragraph: String,
    val location: String,
    val phone_number: String,
    val website: String,
    val school_email: String,
    val total_students: String,
    val start_time: String,
    val end_time: String,
    val school_sports: String,
    val extracurricular_activities: String,
    val academicopportunities1: String,
    val academicopportunities2: String,
    val ell_programs: String,
    val neighborhood: String
)
