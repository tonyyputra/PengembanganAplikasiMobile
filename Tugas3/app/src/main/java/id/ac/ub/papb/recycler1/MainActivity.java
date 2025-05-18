package id.ac.ub.papb.recycler1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rv1;
    public static String TAG = "RV1";
    ArrayList<Mahasiswa> data;
    MahasiswaAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv1 = findViewById(R.id.rv1);
        EditText etNim = findViewById(R.id.etNim);
        EditText etNama = findViewById(R.id.etNama); // sebelumnya: editTextTextPersonName2
        Button bt1 = findViewById(R.id.bt1);

        data = getData();
        adapter = new MahasiswaAdapter(this, data);
        rv1.setAdapter(adapter);
        rv1.setLayoutManager(new LinearLayoutManager(this));

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nimBaru = etNim.getText().toString().trim();
                String namaBaru = etNama.getText().toString().trim();

                if (!nimBaru.isEmpty() && !namaBaru.isEmpty()) {
                    Mahasiswa mhsBaru = new Mahasiswa();
                    mhsBaru.nim = nimBaru;
                    mhsBaru.nama = namaBaru;

                    data.add(mhsBaru);
                    adapter.notifyItemInserted(data.size() - 1);

                    // Kosongkan input
                    etNim.setText("");
                    etNama.setText("");
                }
            }
        });
    }

    public ArrayList<Mahasiswa> getData() {
        ArrayList<Mahasiswa> data = new ArrayList<>();
        List<String> nim = Arrays.asList(getResources().getStringArray(R.array.nim));
        List<String> nama = Arrays.asList(getResources().getStringArray(R.array.nama));
        for (int i = 0; i < nim.size(); i++) {
            Mahasiswa mhs = new Mahasiswa();
            mhs.nim = nim.get(i);
            mhs.nama = nama.get(i);
            Log.d(TAG,"getData "+mhs.nim);
            data.add(mhs);
        }
        return data;
    }
}