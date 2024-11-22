package com.example.unsecuredseguros.modelo

import jakarta.persistence.*
import jdk.jfr.Timestamp
import org.hibernate.annotations.Check
import java.util.*

@Entity
@Table(name = "seguros")
data class Seguro(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Seguro")
    val idSeguro: Int,

    @Column(nullable = false, length = 10)
    val nif: String,

    @Column(nullable = false, length = 1000)
    val nombre: String,

    @Column(nullable = false, length = 1000)
    val ape1: String,

    @Column(length = 1000)
    val ape2: String?,

    @Column(nullable = false)
    @Check(constraints = "edad >= 0")
    val edad: Int,
    @Column(nullable = false, name = "num_hijos")
    @Check(constraints = "num_hijos >= 0")
    val numHijos: Int,

    @Column(name = "fecha_creacion", nullable = false)
    @Timestamp
    val fechaCreacion: Date,

    @Column(nullable = false, length = 10)
    val sexo: String,

    @Column(nullable = false)
    val casado: Boolean,

    @Column(nullable = false)
    val embarazada: Boolean
)