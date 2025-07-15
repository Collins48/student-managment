package com.student.managment.student.managment.system.service

import com.student.managment.student.managment.system.model.Student
import com.student.managment.student.managment.system.repository.StudentRepository
import org.springframework.stereotype.Service


@Service
class StudentService (private  val studentRepository: StudentRepository){

    fun getAllStudents(): List<Student> = studentRepository.findAll()

    fun getStudentById(id: Long): Student? = studentRepository.findById(id).orElse(null)

    fun  addStudent(student: Student): Student = studentRepository.save(student)

    fun updateStudent(id: Long, updateStudent: Student): Student?{
        val exisiting = studentRepository.findById(id)

        return if (exisiting.isPresent){
            val studentToUpdate = exisiting.get().copy(
                name = updateStudent.name,
                email = updateStudent.email,
                course = updateStudent.course
            )
            studentRepository.save(studentToUpdate)
        }else{
            null
        }
    }
    fun deleteStudent(id: Long): Boolean{
        return  if (studentRepository.existsById(id)){
            studentRepository.deleteById(id)
            true
        }else{
            false
        }
    }
}