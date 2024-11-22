package com.example.unsecuredseguros.exception

class ValidationException(mensaje:String)
    :Exception("Error en la validacion(400) $mensaje") {

}