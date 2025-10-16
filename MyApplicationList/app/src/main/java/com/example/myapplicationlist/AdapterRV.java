package com.example.myapplicationlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.vh> {
Context c;
List<Film> films;

public AdapterRV(Context c, List<Film> films) {
    this.c = c;
    this.films = films;
}

    @NonNull
    @Override
    public AdapterRV.vh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // Aqui se crea una vistas nuevas
        LayoutInflater li = LayoutInflater.from(c);
        View v = li.inflate(R.layout.item, parent, false);
        return new vh(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRV.vh holder, int position) { // Esto Asocia los Datos asociamos el textView con el el elemento
        holder.nameFilm.setText(films.get(position).name);
    }

    @Override
    public int getItemCount() { // contador de cuantos elementos hay en este caso las Id que tenemos
        return films.size();
    }

    public class vh extends RecyclerView.ViewHolder {

        TextView nameFilm;
        public vh(@NonNull View itemView) {
            super(itemView);
            nameFilm = itemView.findViewById(R.id.film_name);
        }
    }
}
