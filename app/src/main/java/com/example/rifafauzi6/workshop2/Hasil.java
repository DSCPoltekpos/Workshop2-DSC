package com.example.rifafauzi6.workshop2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Hasil extends AppCompatActivity {

    TextView nama, jurusan, nohp, status, hobby ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        Bundle b = getIntent().getExtras();
        //membuat obyek dari widget textview
        nama = (TextView) findViewById(R.id.namaValue);
        jurusan = (TextView) findViewById(R.id.jurusanValue);
        nohp = (TextView) findViewById(R.id.nohpValue);
        status = (TextView) findViewById(R.id.statusValue);
        hobby = (TextView) findViewById(R.id.hobyValue);

        //menset nilai dari widget textview
        nama.setText(b.getCharSequence("nama"));
        jurusan.setText(b.getCharSequence("jurusan"));
        nohp.setText(b.getCharSequence("nohp"));
        status.setText(b.getCharSequence("status"));
        hobby.setText(b.getCharSequence("hobby"));

        //membuat back button toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

    }

    @Override
    public boolean onSupportNavigateUp() {
        Intent back = new Intent(Hasil.this, MainActivity.class);
        startActivity(back);
        return true;
    }

}
