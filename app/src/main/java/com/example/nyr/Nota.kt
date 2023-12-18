package com.example.nyr

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

class Nota:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.nota_vista)

        // IDENTIFICADORES DE ETIQUETAS DE NOTA_VISTA...

        val NotaCont = findViewById<EditText>(R.id.NotaP)
        val ColorSelected = findViewById<Spinner>(R.id.ColorS)
        val BTNAceptar = findViewById<Button>(R.id.BTNAceptar)

        // LISTENER PARA BOTON DE ACEPTAR (OBTENER DATOS)...

        BTNAceptar.setOnClickListener {

            val appWidgetManager = AppWidgetManager.getInstance(this)
            val ID = appWidgetManager.getAppWidgetIds(ComponentName(this, WidgetPrincipal::class.java))

            // SE OBTIENEN CONTENIDO DE VARIABLES...

            val NotaText = NotaCont.text.toString()
            val ColorText = ColorSelected.selectedItem.toString()
            val BackColor = ColorList(ColorText) // SE MANDA LLAMAR FUNCION COLORLIST...

            val widgetText = "$NotaText"

            for (appWidgetId in ID) {
                WidgetPrincipal.UPNota(this, appWidgetManager, appWidgetId, widgetText, BackColor)
            }
        }
    }

    // FUNCION PARA SPINNER DE COLORES (SELECCION)...

    private fun ColorList(color: String): Int {
        return when (color) {
            "Rojo Oscuro" -> 0xFF590000.toInt()
            "Verde" -> 0xFF11A600.toInt()
            "Purpura" -> 0xFF3A00A5.toInt()
            "Azul" -> 0xFF0032E6.toInt()
            "Amarillo" -> 0xFFE6CF00.toInt()
            "Cafe" -> 0xFF653516.toInt()
            "Azul Celeste" -> 0xFF00D4FA.toInt()
            "Rosa" -> 0xFFF15CD1.toInt()
            else -> 0xFFFFFFFF.toInt()
        }
    }
}