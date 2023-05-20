package com.kotlin.rest.api.controllers

import com.kotlin.rest.api.dtos.TodoDto
import com.kotlin.rest.api.service.TodoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/todos")
class TodoController(@Autowired var todoService: TodoService) {

    @GetMapping("/")
    fun getAllTodos(): List<TodoDto> = todoService.getAllTodos()

    @GetMapping("/{id}")
    fun getTodo(@PathVariable("id") id: String): TodoDto = todoService.getTodo(id)

    @DeleteMapping("/{id}")
    fun deleteTodo(@PathVariable("id") id: String): Map<String, Any> {
        todoService.deleteTodo(id)
        return mapOf(
            "status" to "OK",
            "statusCode" to 200,
            "message" to "Todo has deleted successfully",
            "isSuccess" to true
        )
    }

    @PostMapping("/")
    fun createTodo(@RequestBody todoDto: TodoDto): TodoDto = todoService.createTodo(todoDto)

    @PutMapping("/{id}")
    fun updateTodo(@PathVariable("id") id: String, @RequestBody todoDto: TodoDto): TodoDto =
        todoService.updateTodo(id, todoDto)

}