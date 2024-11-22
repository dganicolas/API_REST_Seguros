package com.example.unsecuredseguros.controlador

import com.example.unsecuredseguros.exception.ValidationException
import com.example.unsecuredseguros.modelo.Seguro
import com.example.unsecuredseguros.servicio.SegurosServicio
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.jvm.Throws

@RestController
@RequestMapping("/seguros")
class SeguroControlador {

    @Autowired
    private lateinit var seguroService: SegurosServicio

    //GET /seguros:
    //Devuelve una lista de todos los seguros registrados.
    @GetMapping("/")
    fun getAll(): List<Seguro> {
        return seguroService.getAll()
    }

    //GET /seguros/{id}:
    //Devuelve un seguro por su identificador idSeguro. Si no existe, retorna un error 404.
    @GetMapping("/{id}")
    fun getById(
        @PathVariable id:String
    ):ResponseEntity<Seguro>?{
        // validacion minima
        if(id.isBlank() || id == "s"){
            //lanzo una excepcion
            throw ValidationException("El id no puede estar vacio")
        }else{
            return seguroService.getById(id)
        }
    }

    //POST /seguros:
    //Crea un nuevo seguro.Valida los campos siguiendo las restricciones mencionadas.
    @PostMapping("/seguros")
    fun newSecure(
    ){
        TODO()
    }
    //PUT /seguros/{id}:
    //Actualiza un seguro existente identificado por idSeguro.Aplica las validaciones antes de guardar los cambios.
    @PutMapping("/seguros/{id}")
    fun updateSecure(
        @PathVariable id:String
    ){
        TODO()
    }
    //DELETE /seguros/{id}:
    //Elimina un seguro identificado por idSeguro. Si no existe, retorna un error 404.
    @DeleteMapping("/seguros/{id}")
    fun deleteSecure(
        @PathVariable id:String
    ){
        TODO()
    }
}