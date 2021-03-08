package com.example.demo.service


import com.example.demo.data.entity.Student

interface StudentService {

    /**
     * 查詢所有學生資料
     */
    fun findAllStudent(): MutableList<Student>

    /**
     * 新增學生資料
     */
    fun addStudent(student: Student): Student

    /**
     * 查詢符合姓名條件的學生資料
     */
    fun findByStudentId(id: Int): Student?

    /**
     * 查詢符合姓名條件的學生資料
     */
    fun findByStudentName(name: String): List<Student>

    /**
     * 更新學生整個資料
     */
    fun updateStudent(student: Student): Student

    /**
     * 更新學生信箱資料
     */
    fun updateStudentEmail(student: Student): Student

    /**
     * 刪除學生資料
     */
    fun deleteStudent(student: Student): Unit
}