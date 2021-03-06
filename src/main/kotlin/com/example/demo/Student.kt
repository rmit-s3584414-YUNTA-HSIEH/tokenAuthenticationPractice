package com.example.demo

import javax.persistence.*

@Entity
@Table
data class Student(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column
    val name: String = "",

    @Column
    val email: String = ""
)
