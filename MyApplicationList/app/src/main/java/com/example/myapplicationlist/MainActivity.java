package com.example.myapplicationlist;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    RecyclerView.LayoutManager lm;
    RecyclerView.Adapter rva;

    List<Film> peliculas = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        readData();
        rv= findViewById(R.id.rv);
        lm = new LinearLayoutManager(MainActivity.this); // tambien funciona con el this unicamente
        rva = new AdapterRV(MainActivity.this, peliculas);

        // Establecer el adaptaor
        rv.setAdapter(rva);
        rv.setLayoutManager(lm);

    }

    public void readData() {
        Resources res = getResources();
        CharSequence[] names = res.getStringArray(R.array.names_movies);

        for (int i=0; i< names.length; i++) {
            String nombre = names[i].toString();
            Film f = new Film(nombre);
            peliculas.add(f);
        }
    }
}