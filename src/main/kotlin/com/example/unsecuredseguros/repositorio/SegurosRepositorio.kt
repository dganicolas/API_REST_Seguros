package com.example.unsecuredseguros.repositorio

import com.example.unsecuredseguros.modelo.Seguro
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SegurosRepositorio: JpaRepository<Seguro, Int> {
}