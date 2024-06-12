package com.example.laboratorio05.clases

class Distrito {

    var codigo: Long = 0
    var nombre: String = ""
    var estado: Boolean? = null

    constructor()
    constructor(codigo: Long, nombre: String, estado: Boolean?) {
        this.codigo = codigo
        this.nombre = nombre
        this.estado = estado
    }


}