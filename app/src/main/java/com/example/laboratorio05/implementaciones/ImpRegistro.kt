package com.example.laboratorio05.implementaciones

import com.example.laboratorio05.clases.Registro
import com.example.laboratorio05.interfaces.IRegistro

class ImpRegistro : IRegistro{
    val listaRegistro = ArrayList<Registro> ()

    override fun mostrarRegistro(): List<Registro> {
        return  listaRegistro;
    }

    override fun registrarRegistro(r: Registro): Boolean {
        val objRegistro = Registro()
        objRegistro.codigo = r.codigo
        objRegistro.nombre = r.nombre
        objRegistro.apellidos = r.apellidos
        objRegistro.dni = r.dni
        objRegistro.fecha = r.fecha
        objRegistro.distrito = r.distrito
        objRegistro.direccion = r.direccion
        objRegistro.telefono = r.telefono
        objRegistro.celular = r.celular
        objRegistro.sexo = r.sexo
        objRegistro.correo = r.correo
        objRegistro.estado = r.estado
        listaRegistro.add(objRegistro)

        if(listaRegistro.isNotEmpty()){
            return true
        }
        else return false
    }

    override fun actualizarRegistro(registro: Registro, codigo: Long): Boolean {
        TODO("Not yet implemented")
    }

    override fun eliminarRegistro(codigo: Long): Boolean {
        TODO("Not yet implemented")
    }

}