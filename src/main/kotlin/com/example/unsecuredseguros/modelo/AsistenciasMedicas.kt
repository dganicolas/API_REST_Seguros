package com.example.unsecuredseguros.modelo

import jakarta.persistence.*
import org.hibernate.annotations.Check
import java.time.LocalDate
import java.time.LocalTime

@Entity
@Table(name = "asistencias_medicas")
data class AsistenciaMedica(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asistencia_medica")
    val idAsistenciaMedica: Int,

    @ManyToOne
    @JoinColumn(name = "id_seguro", nullable = false)
    val seguro: Seguro, // Relación con Seguro

    @Column(name = "breve_descripcion", nullable = false, length = 255)
    val breveDescripcion: String,

    @Column(name = "lugar", nullable = false, length = 255)
    val lugar: String,

    @Column(name = "explicacion", nullable = false)
    val explicacion: String,

    @Column(name = "tipo_asistencia", nullable = false, length = 100)
    val tipoAsistencia: String,

    @Column(name = "fecha", nullable = false)
    val fecha: LocalDate,

    @Column(name = "hora", nullable = false)
    val hora: LocalTime,

    @Column(name = "importe", nullable = false)
    @Check(constraints = "importe > 0")
    val importe: Double
)