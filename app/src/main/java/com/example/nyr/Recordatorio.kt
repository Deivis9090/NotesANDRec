package com.example.nyr

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class Recordatorio:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rec_vista)

        // IDENTIFICADORES DE ETIQUETAS DE REC_VISTA...

        val RecCont = findViewById<EditText>(R.id.RecP)
        val Fecha = findViewById<EditText>(R.id.FechaP)
        val Hora = findViewById<EditText>(R.id.HoraP)
        val BTNAceptar = findViewById<Button>(R.id.BTNAceptar)

        // LISTENER DE BOTON DE ACEPTAR (OBTENER DATOS)...

        BTNAceptar.setOnClickListener {

            val appWidgetManager = AppWidgetManager.getInstance(this)
            val ids = appWidgetManager.getAppWidgetIds(ComponentName(this, WidgetPrincipal::class.java))

            // SE OBTIENE CONTENIDO DE VARIABLES...

            val RecObt = RecCont.text.toString()
            val FechaObt = Fecha.text.toString()
            val HoraObt = Hora.text.toString()

            // PRESENTACION DE INFORMACION DE VARIABLES...

            val WidgetObt =   "$RecObt\n" +
                            " ----------- \n " +
                             "$FechaObt\n" +
                             "$HoraObt"

            for (appWidgetId in ids) {
                WidgetPrincipal.UPRec(this, appWidgetManager, appWidgetId, WidgetObt)
            }
        }
    }
}