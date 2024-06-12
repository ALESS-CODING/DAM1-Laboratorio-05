package com.example.laboratorio05.adapatadores

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
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
            val lblCodigo = vista!!.findViewById<TextView>(R.id.lblCodigo)
            val lblNombre = vista!!.findViewById<TextView>(R.id.lblNombre)
            val lblApellido = vista!!.findViewById<TextView>(R.id.lblApellido)
            val lblDni = vista!!.findViewById<TextView>(R.id.lblDni)
            val lblFechaNacimiento = vista!!.findViewById<TextView>(R.id.lblFechaNacimiento)
            val lblDireccion = vista!!.findViewById<TextView>(R.id.lblDireccion)
            val lblDistrito = vista!!.findViewById<TextView>(R.id.lblDistrito)
            val lblTelefono = vista!!.findViewById<TextView>(R.id.lblTelefono)
            val lblCorreo = vista!!.findViewById<TextView>(R.id.lblCorreo)
            val lblSexo = vista!!.findViewById<TextView>(R.id.lblSexo)
            val lblEstado = vista!!.findViewById<TextView>(R.id.lblEstado)

            //agregamos los avlores
            lblCodigo.text = objRegistro.codigo.toString()
            lblNombre.text = objRegistro.nombre
            lblApellido.text = objRegistro.apellidos
            lblDni.text = objRegistro.dni
            lblFechaNacimiento.text = objRegistro.fecha.toString()
            lblDireccion.text = objRegistro.direccion
            lblDistrito.text = objRegistro.distrito!!.nombre
            lblTelefono.text = objRegistro.telefono
            lblCorreo.text = objRegistro.correo
            lblSexo.text = objRegistro.sexo

            if(objRegistro.estado){
                lblEstado.text = "Habilitado"
            }else{
                lblEstado.text = "Deshabilitado"
            }





        }

        return  vista!!
    }
}