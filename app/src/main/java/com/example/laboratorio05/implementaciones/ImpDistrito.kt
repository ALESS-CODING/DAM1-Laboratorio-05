package com.example.laboratorio05.implementaciones

import com.example.laboratorio05.interfaces.IDistrito

class ImpDistrito: IDistrito {
    override fun CargarComboDitrito(): List<String> {
        return  listOf("Seleccione el distrito","Agustino", "San Miguel",
            "Ancon", "Chorrillos", "Ate", "Barranco", "Ventanilla", "La Victoria", "")
    }
}