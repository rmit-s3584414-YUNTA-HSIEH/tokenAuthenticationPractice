package com.example.demo.controller


import com.example.demo.data.entity.Student
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

interface StudentController{
    @GetMapping("/students")
    fun getStudentData(): MutableList<Student>

    @PostMapping("/students")
    fun addStudentData(@RequestBody student: Student) : Student

    @PostMapping("/students/search")
    fun getStudentByName(@RequestParam name: String) : ResponseEntity<List<Student>>

    @PutMapping("/students/{id}")
    fun updateStudent(@PathVariable id: Int, @RequestBody student: Student) : ResponseEntity<Student?>

    @PatchMapping("/students/{id}")
    fun updateStudentEmail(@PathVariable id: Int, @RequestBody student: Student): ResponseEntity<Student?>

    @DeleteMapping("/students/{id}")
    fun deleteStudent(@PathVariable id: Int): ResponseEntity<Any>
}