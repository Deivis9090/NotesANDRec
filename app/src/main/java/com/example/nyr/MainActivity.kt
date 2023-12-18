package com.example.nyr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // BOTONES PARA PANTALLA PRINCIPAL

        val BTNNota = findViewById<Button>(R.id.SELNota)
        val BTNRec = findViewById<Button>(R.id.SELRecordatorio)

        // NOTAS...

        BTNNota.setOnClickListener {
            val intent = Intent(this, Nota::class.java)
            startActivity(intent)
        }

        // RECORDATORIOS...

        BTNRec.setOnClickListener {
            val intent = Intent(this, Recordatorio::class.java)
            startActivity(intent)
        }

    }
}