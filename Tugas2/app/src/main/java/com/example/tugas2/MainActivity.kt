package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNum1 = findViewById<EditText>(R.id.edtNum1)
        val edtNum2 = findViewById<EditText>(R.id.edtNum2)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val btnHitung = findViewById<Button>(R.id.btnHitung)

        btnHitung.setOnClickListener {
            val num1 = edtNum1.text.toString().toDoubleOrNull()
            val num2 = edtNum2.text.toString().toDoubleOrNull()
            val selectedId = radioGroup.checkedRadioButtonId

            if (num1 == null || num2 == null || selectedId == -1) {
                Toast.makeText(this, "Harap isi semua field", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val operator = findViewById<RadioButton>(selectedId).text.toString()
            val hasil = when (operator) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> 0.0
            }

            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra("Hasil", hasil.toString())
            intent.putExtra("Nama", "Muhammad Tony Putra")
            intent.putExtra("NIM", "235150707111032")
            startActivity(intent)
        }
    }
}