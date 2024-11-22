package com.example.unsecuredseguros.servicio

import com.example.unsecuredseguros.exception.NotFoundException
import com.example.unsecuredseguros.modelo.Seguro
import com.example.unsecuredseguros.repositorio.SegurosRepositorio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import java.util.*


@Service
class SegurosServicio {
    @Autowired
    private lateinit var segurosRepository: SegurosRepositorio

    fun getAll(): List<Seguro>{
        return segurosRepository.findAll()
    }

    fun getById(id:String):
            ResponseEntity<Seguro>? {
        // LOGICA DE NEGOCIO

        //BUSCO EL SEGURO EL SEGURO POR LE ID
        val seguro: Seguro? =  null // el seguro no se ha encontrado

        //DEBERIAMOS RESPONDER DE ESTADO 404
        if (seguro == null){
            throw NotFoundException("el seguro con id $id no ha sido encontrado.")
        }
        return null
        //return segurosRepository.findById(id.toInt()).get()
    }
}