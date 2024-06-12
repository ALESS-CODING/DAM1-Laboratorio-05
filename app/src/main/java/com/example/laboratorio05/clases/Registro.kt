package com.example.laboratorio05.clases

import java.time.LocalDate
import java.util.Date

class Registro {

    var codigo: Long = 0
    var nombre: String = ""
    var apellidos : String =""
    var dni: String = ""
    var fecha: LocalDate? = null
    var direccion: String = ""
    var telefono: String = ""
    var celular: String = ""
    var correo: String = ""
    var sexo: String = ""
    var estado: Boolean = false
    var distrito: Distrito ? = null

    constructor()
    constructor(
        codigo: Long,
        nombre: String,
        apellidos: String,
        dni: String,
        fecha: LocalDate?,
        direccion: String,
        telefono: String,
        celular: String,
        correo: String,
        sexo: String,
        estado: Boolean,
        distrito: Distrito?
    ) {
        this.codigo = codigo
        this.nombre = nombre
        this.apellidos = apellidos
        this.dni = dni
        this.fecha = fecha
        this.direccion = direccion
        this.telefono = telefono
        this.celular = celular
        this.correo = correo
        this.sexo = sexo
        this.estado = estado
        this.distrito = distrito
    }


}