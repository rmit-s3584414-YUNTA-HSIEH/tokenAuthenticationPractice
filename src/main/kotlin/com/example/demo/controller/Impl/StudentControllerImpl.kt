package com.example.demo.controller.Impl


import com.example.demo.controller.StudentController
import com.example.demo.data.entity.Student
import com.example.demo.service.StudentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

    @RestController
    @RequestMapping("/api")
    class StudentControllerImpl(@Autowired val studentService: StudentService) : StudentController {
        /**
         * 取得 Student 所有資料
         */
        override fun getStudentData(): MutableList<Student> = studentService.findAllStudent()

        /**
         * 新增 Student 資料
         */
        override fun addStudentData(student: Student): Student = studentService.addStudent(student)

        /**
         * 利用姓名查詢學生資料
         */
        override fun getStudentByName(name: String): ResponseEntity<List<Student>>
                = studentService
            .findByStudentName(name)
            .let {
                return ResponseEntity(it, HttpStatus.OK)
            }

        /**
         * 修改學生全部資料
         */
        override fun updateStudent(id: Int, student: Student): ResponseEntity<Student?>
                = studentService
            .findByStudentId(id)
            .run {
                this ?: return ResponseEntity<Student?>(null, HttpStatus.NOT_FOUND)
            } .run {
                Student(
                    id = this.id,
                    name = student.name,
                    email = student.email
                )
            }
            .run {
                return ResponseEntity<Student?>(studentService.updateStudent(this), HttpStatus.OK)
            }

        /**
         * 修改學生信箱（欲更新部份資料）
         */
        override fun updateStudentEmail(id: Int, student: Student): ResponseEntity<Student?>
                = studentService
            .findByStudentId(id)
            .run {
                this ?: return ResponseEntity<Student?>(null, HttpStatus.NOT_FOUND)
            }
            .run {
                Student(
                    id = this.id,
                    name = this.name,
                    email = student.email
                )
            }
            .run {
                return ResponseEntity<Student?>(studentService.updateStudentEmail(this), HttpStatus.OK)
            }

        /**
         * 刪除學生資料
         */
        override fun deleteStudent(id: Int): ResponseEntity<Any>
                = studentService
            .findByStudentId(id)
            .run {
                this ?: return ResponseEntity<Any>(null, HttpStatus.NOT_FOUND)
            }
            .run {
                return ResponseEntity<Any>(studentService.deleteStudent(this), HttpStatus.NO_CONTENT)
            }

    }