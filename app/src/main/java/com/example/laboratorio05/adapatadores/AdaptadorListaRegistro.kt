package com.example.laboratorio05.adapatadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.laboratorio05.R
import com.example.laboratorio05.clases.Registro

class AdaptadorListaRegistro (context: Context?, val listaRegistro: List<Registro>?) : BaseAdapter() {

    private var layoutInflater: LayoutInflater

    init {
        layoutInflater = LayoutInflater.from(context)
    }


    override fun getCount(): Int {
        return  listaRegistro!!.size
    }

    override fun getItem(position: Int): Any {
        return  listaRegistro!![position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var  vista = convertView

        if(vista == null ){
            //llamamos al layout que queremos carga
            vista = layoutInflater.inflate(R.layout.elemento_lista_registro, parent, false )

            val objRegistro = getItem(position) as Registro

            //creamos los controles de los elememntos de la lista
        }

        return  vista!!
    }
}