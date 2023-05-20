package com.kotlin.rest.api.repository

import com.kotlin.rest.api.entities.Todo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TodoRepository : JpaRepository<Todo,String> {
}