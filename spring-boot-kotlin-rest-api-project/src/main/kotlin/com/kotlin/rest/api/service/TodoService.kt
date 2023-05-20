package com.kotlin.rest.api.service

import com.kotlin.rest.api.dtos.TodoDto

interface TodoService {
    fun createTodo(todoDto: TodoDto): TodoDto
    fun getAllTodos(): List<TodoDto>
    fun getTodo(id: String): TodoDto
    fun deleteTodo(id: String): Unit
    fun updateTodo(id: String,todoDto: TodoDto): TodoDto
}