package com.kotlin.rest.api.exceptions

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class RestControllerAdvice {

    @ExceptionHandler(value = [ResourceNotFoundException::class])
    fun handleNotFoundException(ex: ResourceNotFoundException): ResponseEntity<Map<Any?, Any?>> {
//        //val map: Map<Any?, Any?> = mapOf<Any?, Any?>()
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//            .body(mapOf("statusCode" to 404, "message" to ex.message, "isSuccess" to true))

        val hashMap = HashMap<Any?, Any?>()
        hashMap["statusCode"] = 404
        hashMap["message"] = ex.message
        hashMap["isSuccess"] = true
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(hashMap)
    }

}