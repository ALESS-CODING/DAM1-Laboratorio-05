package com.example.laboratorio05.interfaces

import com.example.laboratorio05.clases.Registro

interface IRegistro {

    fun mostrarRegistro(): List<Registro>
    fun registrarRegistro( registro: Registro): Boolean
    fun actualizarRegistro( registro: Registro, codigo: Long): Boolean
    fun eliminarRegistro (codigo: Long): Boolean
}