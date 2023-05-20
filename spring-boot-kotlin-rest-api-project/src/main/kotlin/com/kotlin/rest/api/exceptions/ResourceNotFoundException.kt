package com.kotlin.rest.api.exceptions

class ResourceNotFoundException : RuntimeException {

    constructor() : super()

    constructor(message: String?) : super(message)
}