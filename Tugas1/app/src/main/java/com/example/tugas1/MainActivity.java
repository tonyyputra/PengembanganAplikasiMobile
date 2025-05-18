package com.example.tugas1;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNamaDepan, editTextNamaBelakang;
    private TextView textViewHasil;
    private Button btnShow;
    private String namaLengkap = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNamaDepan = findViewById(R.id.editTextNamaDepan);
        editTextNamaBelakang = findViewById(R.id.editTextNamaBelakang);
        textViewHasil = findViewById(R.id.textViewResult);
        btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(v -> {
            String firstName = editTextNamaDepan.getText().toString();
            String lastName = editTextNamaBelakang.getText().toString();
            namaLengkap = firstName + " " + lastName;
            textViewHasil.setText(namaLengkap);
        });

        if (savedInstanceState != null) {
            namaLengkap = savedInstanceState.getString("NAMA_LENGKAP", "");
            textViewHasil.setText(namaLengkap);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("NAMA_LENGKAP", namaLengkap);
    }

    @Override
    protected void onRestoreInstanceState(Bundle

                                                  savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        namaLengkap =
                savedInstanceState.getString("FULL_NAME", "");
        textViewHasil.setText(namaLengkap);
    }
}