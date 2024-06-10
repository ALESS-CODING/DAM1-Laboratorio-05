package com.example.laboratorio05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Spinner
import com.example.laboratorio05.Utilidad.Util
import com.example.laboratorio05.implementaciones.ImpDistrito
import com.example.laboratorio05.interfaces.IDistrito

class MainActivity : AppCompatActivity() {
    //declarando controles
    private lateinit var cmbDistrito : Spinner
    private lateinit var txtNombres : EditText
    private lateinit var txtApellidos : EditText
    private lateinit var txtDni : EditText
    private lateinit var txtFechaNacimiento : EditText
    private lateinit var txtDireccion : EditText
    private lateinit var txtTelefono : EditText
    private lateinit var txtCelular : EditText
    private lateinit var txtCorreo : EditText
    private lateinit var rgSexo : RadioGroup
    private lateinit var rbM : RadioButton
    private lateinit var rbF : RadioButton
    private lateinit var rbOtros : RadioButton

    private lateinit var btnRegistrar : Button
    private lateinit var btnActualizar : Button

    //Declrando variables

    //declarando objetos


    //imlementaciones la interface
    val distritos:IDistrito= ImpDistrito()
    var adaptadorComboDistrito: ArrayAdapter<String>? = null
    val util:Util = Util()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
        rbM = findViewById(R.id.rbM)
        rbF = findViewById(R.id.rbF)
        rbOtros = findViewById(R.id.rbO)

        btnRegistrar = findViewById(R.id.btnRegistrar)
        btnActualizar = findViewById(R.id.btnActualizar)

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
            }
        }
    }
}