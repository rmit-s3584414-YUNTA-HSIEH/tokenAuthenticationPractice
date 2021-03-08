package com.example.demo.data.dao

import com.example.demo.data.entity.Student
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor


    interface StudentDao:  JpaRepository<Student, Long>, JpaSpecificationExecutor<Student> {

        /**
         * 查詢符合姓名條件的學生資料
         */
        fun findByName(name: String): List<Student>

        /**
         * 查詢符合 Id 條件的學生資料
         */
        fun findById(id: Int): Student?
    }
