package com.example.unsecuredseguros.controlador

import com.example.unsecuredseguros.exception.ValidationException
import com.example.unsecuredseguros.modelo.Seguro
import com.example.unsecuredseguros.servicio.SegurosServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

//Operaciones CRUD:
//
//Seguro:
//
//Crear un seguro.
//Consultar un seguro por su identificador.
//Listar todos los seguros.
//Actualizar un seguro existente.
//Eliminar un seguro (debe eliminar también las asistencias asociadas).
@RestController
@RequestMapping("/")
class SeguroControlador {

    @Autowired
    private lateinit var seguroService: SegurosServicio

    //GET /seguros:
    //Devuelve una lista de todos los seguros registrados. realizado pero no comprobado
    @GetMapping("/seguros")
    fun getAll(): ResponseEntity<List<Seguro>> {
        return seguroService.getAll()
    }

    //GET /seguros/{id}:
    //Devuelve un seguro por su identificador idSeguro.
    //Si no existe, retorna un error 404. realizado, pero no comprobado
    @GetMapping("/seguros/{id}")
    fun getById(
        @PathVariable id: String
    ): ResponseEntity<Seguro>? {
        // validacion minima
        if (id.isBlank() || id == "s") {
            //lanzo una excepcion
            throw ValidationException("El id no puede estar vacio")
        } else {
            return seguroService.getById(id)
        }
    }

    //POST /seguros:
    //Crea un nuevo seguro.Valida los campos siguiendo las restricciones mencionadas
    // . realizado pero no comprobado
    @PostMapping("/seguros")
    fun newSecure(
        @RequestBody seguro: Seguro
    ): ResponseEntity<Seguro>  {
        return seguroService.newSecure(seguro)
    }

    //PUT /seguros/{id}:
    //Actualiza un seguro existente identificado por idSeguro.Aplica las validaciones antes de guardar los cambios.
    @PutMapping("/seguros/{id}")
    fun updateSecure(
        @PathVariable id: String,
        @RequestBody seguro:Seguro
    ) {
        seguroService.updateSecure(id,seguro)
    }

    //DELETE /seguros/{id}:
    //Elimina un seguro identificado por idSeguro. Si no existe, retorna un error 404.
    @DeleteMapping("/seguros/{id}")
    fun deleteSecure(
        @PathVariable id: String
    ) {
        TODO()
    }
}