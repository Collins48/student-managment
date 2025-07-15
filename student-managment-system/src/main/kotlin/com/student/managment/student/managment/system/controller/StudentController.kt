package com.student.managment.student.managment.system.controller

import com.student.managment.student.managment.system.model.Student
import com.student.managment.student.managment.system.service.StudentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/students")
class StudentController (private val studentService: StudentService){

    @GetMapping
    fun getAllStudents(): List<Student> = studentService.getAllStudents()

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<Student> {
        val student = studentService.getStudentById(id)
        return if (student != null) ResponseEntity.ok(student)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun addStudent(@RequestBody student: Student): ResponseEntity<Student>{
        val savedStudent = studentService.addStudent(student)
        return ResponseEntity.ok(savedStudent)
    }
    @PutMapping("/{id}")
    fun updateStudent(@PathVariable id: Long, @RequestBody student: Student): ResponseEntity<Student>{
        val updated = studentService.updateStudent(id, student)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteMapping(@PathVariable id:Long,): ResponseEntity<String>{
        return if (studentService.deleteStudent(id)){
            ResponseEntity.ok("Student deleted successfully")
        }else{
            ResponseEntity.notFound().build()
        }
    }
}
