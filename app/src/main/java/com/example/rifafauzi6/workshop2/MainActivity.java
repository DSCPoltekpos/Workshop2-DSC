package com.example.rifafauzi6.workshop2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nama, jurusan, nohp;
    RadioGroup rg;
    CheckBox cb1, cb2, cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nama = findViewById(R.id.edittextNama);
        jurusan = findViewById(R.id.edittextJurusan);
        nohp = findViewById(R.id.edittextNoHP);
        rg = findViewById(R.id.radio);
    }

    public void kirim (View view) {
        cb1 = findViewById(R.id.tidur);
        cb2 = findViewById(R.id.makan);
        cb3 = findViewById(R.id.maingame);
        String a = "";
        if (cb1.isChecked()) {
            a = a + "Tidur\n";
        }
        if (cb2.isChecked()) {
            a = a + "Makan\n";
        }
        if (cb3.isChecked()) {
            a = a + "Main Game\n";
        }

        Intent intent = new Intent(getApplicationContext(), Hasil.class);

        //Membuat obyek bundle
        Bundle b = new Bundle();

        //Menyisipkan tipe data String ke dalam obyek bundle
        b.putString("nama", nama.getText().toString());
        b.putString("jurusan", jurusan.getText().toString());
        b.putString("nohp", nohp.getText().toString());
        int id = rg.getCheckedRadioButtonId();
        RadioButton radioButton = (RadioButton) findViewById(id);
        b.putString("status", radioButton.getText().toString());
        b.putString("hobby", a);
        //Menambahkan bundle intent
        intent.putExtras(b);
        //memulai Activity kedua
        startActivity(intent);

        Toast.makeText(getApplicationContext(), "Kirim Data Berhasil", Toast.LENGTH_LONG).show();

    }

    public void exit (View view) {
        moveTaskToBack(true);
    }
}
