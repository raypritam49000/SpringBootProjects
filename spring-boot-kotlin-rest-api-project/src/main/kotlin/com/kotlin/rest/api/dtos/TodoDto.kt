package com.kotlin.rest.api.dtos

data class TodoDto(
    var id: String? = null,
    var title: String,
    var content: String,
    var complete: Boolean
) {
    constructor() : this("", "", "", false)
}