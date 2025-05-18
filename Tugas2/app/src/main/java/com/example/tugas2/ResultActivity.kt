package com.example.tugas2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val hasil = intent.getStringExtra("Hasil")
        val nama = intent.getStringExtra("Nama")
        val nim = intent.getStringExtra("NIM")

        val txtHasil = findViewById<TextView>(R.id.txtHasil)
        txtHasil.text = "Hasil: $hasil\n" +
                        "\nNama: $nama" +
                        "\nNIM: $nim"
    }
}