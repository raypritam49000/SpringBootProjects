package com.kotlin.rest.api.service

import com.kotlin.rest.api.dtos.TodoDto
import com.kotlin.rest.api.entities.Todo
import com.kotlin.rest.api.exceptions.ResourceNotFoundException
import com.kotlin.rest.api.repository.TodoRepository
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoServiceImpl(
    @Autowired var todoRepository: TodoRepository,
    @Autowired var mapper: ModelMapper
) : TodoService {


    override fun createTodo(todoDto: TodoDto): TodoDto {
        val todo: Todo = mapper.map(todoDto, Todo::class.java)
        val createdTodo: Todo = todoRepository.save(todo);
        return mapper.map(createdTodo, TodoDto::class.java)
    }

    override fun getAllTodos(): List<TodoDto> {
        return todoRepository.findAll().stream().map { todo ->
            mapper.map(todo, TodoDto::class.java)
        }.toList()
    }

    override fun getTodo(id: String): TodoDto {
        val todo: Todo = todoRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Todo with ID $id not found") }
        return mapper.map(todo, TodoDto::class.java)
    }

    override fun deleteTodo(id: String): Unit {
        val todo: Todo = todoRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Todo with ID $id not found") }
        todoRepository.delete(todo)
    }

    override fun updateTodo(id: String, todoDto: TodoDto): TodoDto {
        val todo: Todo = todoRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Todo with ID $id not found") }

        todo.title = todoDto.title
        todo.content = todoDto.content
        todo.complete = todoDto.complete

        val updateTodo: Todo = todoRepository.save(todo)

        return mapper.map(updateTodo, TodoDto::class.java)
    }
}