package com.example.demo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import java.util.*

interface StudentDao:  JpaRepository<Student, Long>, JpaSpecificationExecutor<Student>{
    fun findByName(name: String): Student?
}