package com.example.unsecuredseguros.exception

class NotFoundException(mensaje:String)
    :Exception("Not Found Exception (404) $mensaje") {
}