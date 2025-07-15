package com.student.managment.student.managment.system.repository

import com.student.managment.student.managment.system.model.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface  StudentRepository : JpaRepository<Student, Long>