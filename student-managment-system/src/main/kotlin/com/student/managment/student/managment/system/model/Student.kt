package com.student.managment.student.managment.system.model

import jakarta.persistence.*

@Entity
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,
    val email: String,
    val course: String
)
