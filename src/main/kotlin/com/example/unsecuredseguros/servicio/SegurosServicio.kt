package com.example.unsecuredseguros.servicio

import com.example.unsecuredseguros.exception.NotFoundException
import com.example.unsecuredseguros.exception.ValidationException
import com.example.unsecuredseguros.modelo.Seguro
import com.example.unsecuredseguros.repositorio.SegurosRepositorio
import com.example.unsecuredseguros.utils.DniValidator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*
import kotlin.jvm.Throws


@Service
class SegurosServicio {
    @Autowired
    private lateinit var segurosRepository: SegurosRepositorio

    fun getAll(): ResponseEntity<List<Seguro>> {
        val seguros = segurosRepository.findAll()
        return if (seguros.isEmpty()) {
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.ok(seguros)
        }
    }

    fun getById(id: String):
            ResponseEntity<Seguro> {
        val seguroId =
            id.toIntOrNull() ?: throw ValidationException("El parámetro id debe ser un número entero válido.")

        val seguro = segurosRepository.findById(seguroId).orElseThrow {
            NotFoundException("El asegurado con ID $id no se encontró.")
        }

        return ResponseEntity.ok(seguro)
    }
    
    fun newSecure(seguro: Seguro): ResponseEntity<Seguro> {
        if (checkSecure(seguro)) {
            return ResponseEntity.ok(segurosRepository.save(seguro))
        }
        throw IllegalArgumentException(
            "teoricamente no tienes que ver este error xd, si lo ves hazmelo saber xd"
        )
    }

    fun checkSecure(seguro: Seguro): Boolean {
        if (!DniValidator.validateDNI(seguro.nif)) {
            throw ValidationException("El NIF es invalido")
        }

        if (seguro.nombre.isBlank()) {
            throw ValidationException("El campo nombre no puede estar vacío.")
        }

        if (seguro.ape1.isBlank()) {
            throw ValidationException("El campo ape1 no puede estar vacío.")
        }

        if (seguro.edad <= 0) {
            throw ValidationException("El campo edad debe ser mayor que 0.")
        }

        if (seguro.edad < 18) {
            throw ValidationException("No es posible ser menor de edad para hacer un seguro.")
        }

        if (!seguro.casado && seguro.numHijos > 0) {
            throw ValidationException("Un seguro no puede registrar hijos si no está casado.")
        }

        if (seguro.sexo == "Hombre" && seguro.embarazada) {
            throw ValidationException("El campo embarazada no puede ser true si el asegurado es hombre.")
        }
        return true
    }

    fun updateSecure(id: String, seguro: Seguro) {
        if(checkSecure(seguro)){
            var idElegido = 0;
            try {
                idElegido = id.toInt()
            }catch (e:NumberFormatException){
                throw ValidationException("El id debe de ser un numero.")
            }
            if (segurosRepository.existsById(idElegido)){
                segurosRepository.save(seguro)
            }

        }
    }
}