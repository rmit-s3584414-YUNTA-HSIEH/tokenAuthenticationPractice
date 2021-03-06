package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.env.Environment
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.util.*

@RestController
@RequestMapping("/api")
class StudentController(@Autowired val studentDao: StudentDao) {
    /**
     * 取得 Student 所有資料
     */
    @GetMapping("/students")
    fun getStudentData(): MutableList<Student> {
        return studentDao.findAll()
    }

    /**
     * 新增 Student 資料
     */
    @PostMapping("/students")
    fun addStudentData(@RequestBody student: Student): Student {
        return studentDao.save(student)
    }

    /**
     * 查詢指定姓名的學生資料
     */
    @PostMapping("/students/search")
    fun getStudentByName(@RequestParam name: String): Student? {
        return studentDao.findByName(name)
    }


}

