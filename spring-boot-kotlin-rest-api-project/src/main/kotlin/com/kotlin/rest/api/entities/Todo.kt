package com.kotlin.rest.api.entities

import jakarta.persistence.*

@Entity
@Table(name="todo")
data class Todo(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    var id : String? = null,
    var title: String,
    var content : String,
    var complete : Boolean
)