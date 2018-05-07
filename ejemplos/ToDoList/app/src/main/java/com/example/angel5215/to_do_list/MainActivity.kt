package com.example.angel5215.to_do_list

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.util.*

class MainActivity : AppCompatActivity() {

    private var listaTareas: MutableList<Tarea> = mutableListOf()

    //	Los adaptadores los verán bien el lunes. xxdddxddxddxxd
    private val adaptador by lazy { makeAdapter(listaTareas) }

    //  Referencia a nuestra base de datos.
    private lateinit var realm: Realm

    //  Para el INTENT EXPLÍCITO:
    private val AGREGAR_TAREA_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //  Inicializamos Realm
        Realm.init(this)

        //  Creamos nuestra base de datos y además obtenemos una referencia a ella.
        val config = RealmConfiguration.Builder()
                .name("tareas.realm")
                .build()
        realm = Realm.getInstance(config)

        //  Añadiendo el adaptador para nuestra lista
        tareasListView.adapter = adaptador

        //  Añadimos un onClickListener para las tareas para poder editarlas o borrarlas.
        tareasListView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->  // closure que acepta 3 parámetros
            tareaSeleccionada(position)
        }

        //  Añadir OnClickListener para el botón
        agregarButton.setOnClickListener {
            agregarTarea()
        }

        //  Obtener las tareas por primera vez:
        val tareasIniciales = realm.where(Tarea::class.java).findAll()
        if (tareasIniciales.isNotEmpty()) {
            tareasIniciales.forEach {
                listaTareas.add(it)
            }   
        }

    }

    fun agregarTarea() {
        val intent = Intent(this, CrearTareaActivity::class.java)
        startActivityForResult(intent, AGREGAR_TAREA_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (AGREGAR_TAREA_CODE == requestCode) {
            if (Activity.RESULT_OK == resultCode) {
                val extra = data?.getStringExtra(CrearTareaActivity.EXTRA_DESCRIPCION_TAREA)

                //  Si nuestra tarea devolvió un valor lo usamos en el bloque let
                extra?.let {

                    realm.beginTransaction()
                    val tarea = realm.createObject(Tarea::class.java)
                    tarea.fecha = Date()
                    tarea.contenido = extra
                    realm.commitTransaction()
                }

                println("Guardado")

                val tareas = realm.where(Tarea::class.java).findAll()

                listaTareas.clear()

                tareas.forEach {
                    listaTareas.add(it)
                }

                adaptador.notifyDataSetChanged()
            }
        }
    }

    private fun tareaSeleccionada(position: Int) {

        AlertDialog.Builder(this).setTitle("Tarea")
                .setMessage(listaTareas[position].contenido)
                .setPositiveButton("Borrar", {
                    _, _ ->
                    val tareaSeleccionada = listaTareas.removeAt(position)

                    val tareaABorrar = realm.where(Tarea::class.java)
                            .equalTo("fecha", tareaSeleccionada.fecha)
                            .and().equalTo("contenido", tareaSeleccionada.contenido)
                            .findAll()
                    tareaABorrar.forEach {
                        realm.beginTransaction() //begin tran v;
                        it.deleteFromRealm()
                        realm.commitTransaction() // commit tran v;
                    }

                    adaptador.notifyDataSetChanged()
                })
                .setNegativeButton("Cancelar", {
                    dialog, _ -> dialog.cancel()
                })
                .create()
                .show()
    }

    //  Crea un adaptador. Equivalente a { return ArrayAdapter(...) }
    private fun makeAdapter(list: List<Tarea>): ArrayAdapter<Tarea> = ArrayAdapter(this, android.R.layout.simple_list_item_1, list)

}
