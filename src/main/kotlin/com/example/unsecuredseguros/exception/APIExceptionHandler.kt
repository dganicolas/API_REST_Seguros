package com.example.unsecuredseguros.exception

import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class APIExceptionHandler {

    @ExceptionHandler(
        IllegalArgumentException::class,
        NumberFormatException::class,
        ValidationException::class
    )
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun handleBadResquest(
        request: HttpServletRequest,
        e: Exception
    ): ErrorParaCliente {
        return ErrorParaCliente(e.message , request.requestURI)
    }

    @ExceptionHandler(
        NotFoundException::class
    )//las clase que se quieren controlar
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody// la respuesta la convierte a JSON
    fun handleNotFound(
        request: HttpServletRequest,
        e: Exception
    ): ErrorParaCliente {
        return ErrorParaCliente(e.message , request.requestURI)
    }
}