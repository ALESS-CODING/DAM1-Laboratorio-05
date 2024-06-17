package com.example.laboratorio05

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import androidx.annotation.RequiresApi
import com.example.laboratorio05.Utilidad.Util
import com.example.laboratorio05.adapatadores.AdaptadorComboDistrito
import com.example.laboratorio05.adapatadores.AdaptadorListaRegistro
import com.example.laboratorio05.clases.Distrito
import com.example.laboratorio05.clases.Registro
import com.example.laboratorio05.implementaciones.ImpDistrito
import com.example.laboratorio05.implementaciones.ImpRegistro
import com.example.laboratorio05.interfaces.IDistrito
import com.example.laboratorio05.interfaces.IRegistro
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    //declarando controles

    private lateinit var txtNombres : EditText
    private lateinit var txtApellidos : EditText
    private lateinit var txtDni : EditText
    private lateinit var txtFechaNacimiento : EditText
    private lateinit var txtDireccion : EditText
    private lateinit var cmbDistrito : Spinner
    private lateinit var txtTelefono : EditText
    private lateinit var txtCelular : EditText
    private lateinit var txtCorreo : EditText
    private lateinit var rgSexo : RadioGroup
    private lateinit var rbM : RadioButton
    private lateinit var rbF : RadioButton
    private lateinit var rbOtros : RadioButton
    private lateinit var chkEstado : CheckBox

    private lateinit var btnRegistrar : Button
    private lateinit var btnActualizar : Button
    private lateinit var btnEliminar : Button
    private lateinit var btnSalir : Button
    private lateinit var lstRegistro : ListView

    //Declrando variables
    var codigo: Long = 0
    var nombre: String = ""
    var apellidos : String =""
    var dni: String = ""
    var distrito : String = ""
    var fecha: LocalDate? = null
    var direccion: String = ""
    var telefono: String = ""
    var celular: String = ""
    var correo: String = ""
    var sexo: String = ""
    var estado: Boolean = false

    var calendar = Calendar.getInstance()

    //creamos la lista de refistro
    lateinit var listaRegistro : List<Registro>

    //declarando objetos
    val util:Util = Util()
    val distritos:IDistrito= ImpDistrito()
    val registro : Registro = Registro()
    val objDistrito: Distrito = Distrito()

    //imlementaciones la interface
    var registros:IRegistro = ImpRegistro ()

    //Agregamos un adaptador, es para el combo
    var adaptadorComboDistrito: ArrayAdapter<String>? = null
    var adaptadorListaRegistro: AdaptadorListaRegistro? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaRegistro = registros.mostrarRegistro()
        adaptadorListaRegistro = AdaptadorListaRegistro(this, listaRegistro)

        //Creamos los controles
        cmbDistrito = findViewById(R.id.cboDistrito)
        txtNombres = findViewById(R.id.txtNom)
        txtApellidos = findViewById(R.id.txtApe)
        txtDni = findViewById(R.id.txtDni)
        txtDireccion = findViewById(R.id.txtDir)
        txtFechaNacimiento = findViewById(R.id.txtFec)
        txtTelefono = findViewById(R.id.txtTel)
        txtCelular = findViewById(R.id.txtCel)
        txtCorreo = findViewById(R.id.txtCorreo)
        rgSexo = findViewById(R.id.rgSexo)
        rbM = findViewById(R.id.rbM)
        rbF = findViewById(R.id.rbF)
        rbOtros = findViewById(R.id.rbO)
        chkEstado = findViewById(R.id.chkEstado)
        lstRegistro = findViewById(R.id.lstRegistro)


        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnActualizar = findViewById(R.id.btnActualizar)
        btnEliminar = findViewById(R.id.btnEliminar)
        btnSalir = findViewById(R.id.btnSalir)

        //creamosun adapatador para el combo
        adaptadorComboDistrito = ArrayAdapter(this, android.R.layout.simple_spinner_item, distritos.CargarComboDitrito())

        //asignamos  el adaptador al spiner
        cmbDistrito.adapter = adaptadorComboDistrito



        //validando datos
        btnRegistrar.setOnClickListener {
            if(txtNombres.getText().isBlank()){
                util.MensajeAlerta(this, "Validacion de datos", "Ingrese el nombre ",
                    false, "Aceptar")
                txtNombres.requestFocus()
            }else if(txtApellidos.getText().isBlank()){
                util.MensajeAlerta(this, "Validacion de datos", "Ingrese su apellido",
                    false, "Aceptar")
                txtApellidos.requestFocus()
            }else if(txtDni.getText().isBlank()){
                util.MensajeAlerta(this, "Validacion de datos", "Ingrese el dni",
                    false, "Aceptar")
                txtDni.requestFocus()
            }else if(txtFechaNacimiento.getText().isBlank()){
                util.MensajeAlerta(this, "Validacion de datos", "Ingrese su fecha nacimineto",
                    false, "Aceptar")
                txtFechaNacimiento.requestFocus()
            }else if(txtDireccion.getText().isBlank()){
                util.MensajeAlerta(this, "Validacion de datos", "Ingrese la direccion",
                    false, "Aceptar")
                txtDireccion.requestFocus()
            }else if (cmbDistrito.selectedItemPosition == 0){
                util.MensajeAlerta(this, "Validacion de datos", "Seleccione un distrito ",
                    false, "Aceptar")
                cmbDistrito.requestFocus()
            }else if (txtTelefono.getText().isBlank()){
                util.MensajeAlerta(this, "Validacion de datos", "Ingrese el telefono",
                    false, "Aceptar")
                txtTelefono.requestFocus()
            }else if (txtCelular.getText().isBlank()){
                util.MensajeAlerta(this, "Validacion de datos", "Ingrese su celular",
                    false, "Aceptar")
                txtCelular.requestFocus()
            }else if (txtCorreo.getText().isBlank()){
                util.MensajeAlerta(this, "Validacion de datos", "Ingrese el correo",
                    false, "Aceptar")
                txtCorreo.requestFocus()
            }else if (!rbM.isChecked && !rbF.isChecked && !rbOtros.isChecked){
                util.MensajeAlerta(this, "Validacion de datos", "Seleccione el sexo",
                    false, "Aceptar")
                rbOtros.isChecked = true
            }else{
                codigo++
                nombre = txtNombres.text.toString()
                apellidos = txtApellidos.text.toString()
                dni = txtDni.text.toString()
                fecha = LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
                direccion = txtDireccion.text.toString()
                distrito = cmbDistrito.selectedItem.toString()
                telefono = txtTelefono.text.toString()
                celular = txtCelular.text.toString()
                correo = txtCorreo.text.toString()

                if (rbM.isChecked){
                    sexo = "Masculino"
                }else if(rbF.isChecked){
                    sexo = "Feminino"
                }else sexo = "Otros"


                if(chkEstado.isChecked){
                    estado = true
                }else estado = false
                registro.codigo = codigo
                registro.nombre = nombre
                registro.apellidos = apellidos
                registro.dni = dni
                registro.fecha = fecha
                registro.direccion = direccion
                registro.telefono = telefono
                registro.celular = celular
                registro.correo = correo
                registro.sexo = sexo
                registro.estado = estado
                objDistrito.nombre = distrito
                registro.distrito = objDistrito
                registros.registrarRegistro(registro)
                util.MensajeAlerta(this,
                    "Registro de datos",
                    "Se registro el distrito",
                    false,
                    "Aceptar")
                adaptadorListaRegistro!!.notifyDataSetChanged()
                lstRegistro.adapter = adaptadorListaRegistro
                Limpiar()
            }
        }

        txtFechaNacimiento.setOnClickListener {
            selectedDate ()
        }
    }

    private fun selectedDate() {
        val txtFecha = findViewById<EditText>(R.id.txtFec)

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val listener = DatePickerDialog.OnDateSetListener { datePicker, year, month, dayOfMonth ->
            calendar.set(year, month, dayOfMonth)
            txtFecha.setText("$dayOfMonth-$month-$year")
        }
        DatePickerDialog(this, listener, year, month, dayOfMonth).show()
    }

    //creamos una funcion para limpiar
    fun Limpiar(){
        txtDni.setText("")
        txtApellidos.setText("")
        txtDni.setText("")
        txtFechaNacimiento.setText("")
        txtDireccion.setText("")
        cmbDistrito.setSelection(0)
        txtTelefono.setText("")
        txtTelefono.setText("")
        txtCorreo.setText("")
        rgSexo.clearCheck()
        chkEstado.isChecked=false
        nombre=""
        apellidos=""
        dni=""
        fecha=null
        direccion=""
        distrito=""
        telefono=""
        celular=""
        correo=""
        sexo=""
        estado=false
        txtNombres.requestFocus()
    }

}

